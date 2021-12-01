import React, { useState, useEffect } from "react";
import api from "../../../services/api"
import { Page } from "./styles";
import { DivUsuario, Content, BoxLeft, BoxRight, BoxAux } from "./styles";
import { UserProfilePic, Message, List, Calendar, Hours } from "../../../components";
import swal from 'sweetalert';
import Select from 'react-select';
import { useHistory } from "react-router";
export const Schedules = () => {
  const [specialities, setSpecialities] = useState([]);
  const [listUbs, setListUbs] = useState([]);
  const [listHours, setListHours] = useState([]);
  const [ubs, setUbs] = useState(); 
  const [daySelected, setDaySelected] = useState('');
  const [hourSelected, setHourSelected] = useState();
  const [ speciality, setSpeciality ] = useState();
  const history = useHistory();
  const userId = localStorage.getItem("id"); 
 
   async function cadastrar(e) {
    
    const data = {
      descricao: "",
      dtAtendimento: formatDate(daySelected),
      hrAtendimento: hourSelected,
      idEspecialidade : speciality,
      idPaciente: userId,
      idUbs: ubs
    }
      await api("maisconsulta").post("/agendamento/agendar/consulta", data)
      swal('Atendimento realizado','Atendimento realizado com sucesso', "success")
      .then(() => history.push('/home'))
      .catch(() => swal('Error','Ocorreu um erro', "error"))
  }
  
  useEffect(() => {
    try {
      const getSpecialities = async () => {
        const response = await api("maisconsulta").get("/agendamento/especialidades")
        console.log("req"+response.data)
        const aux = response.data.map(item => ({value: item.id, label: item.descricao}))
        setSpecialities(aux)
      }
      getSpecialities()
    } catch (error) {
      
    }
  }, [])
  
  const handleSpecialities = speciality => setSpeciality(speciality.value)
  
  useEffect(() => {
    async function searchListUbs() {
      const response = await api("maisconsulta").get(`/search/ubs/${speciality}`)
      const aux = response.data.map(list => ({list, selected: false}))
      setListUbs(aux)
  }
  searchListUbs();
  }, [speciality])

  const setSelectedUbs = index => {
    const auxiliar = listUbs.map((data, i)=> {
       data.selected = i==index
       return data
    })
    setUbs(auxiliar[index].list.idUbs)
    setListUbs(auxiliar)
}
const formatDate = date => {
  let dia;
  if(date) {
    console.log(date)
    date = date.split("-");
    if(date[2] > 10){
      dia = date[2]
    } else{
      dia = '0' + date[2];
    }
    return date[0] + '-' + date[1] + '-' + dia;
  }
}
useEffect(() => {
  async function searchHours() {
      const resp = await api("maisconsulta").get(`/agendamento/horarios/livres/${formatDate(daySelected)}/${ubs}`)
      const aux = resp.data.map(hour => ({hour, selected: false}))
      setListHours(aux)
  }
  searchHours();
},[ubs, daySelected])

const setSelectedHour = index => {
    const auxiliar = listHours.map((data,i)=>{
       data.selected = i==index
       return data
    })
    setHourSelected(auxiliar[index].hour)
    setListHours(auxiliar)
}
  return (
    <Page>
      <DivUsuario>
        <UserProfilePic />
      </DivUsuario>
      <Content>
        <BoxLeft>
          <Message textOne="Novo agendamento de consulta" textTwo="" />
          <div className="filter_group">
            <p>Selecione a especialidade</p>
            <Select options={specialities} onChange={(e) => handleSpecialities(e)} className='react-select-container'/>
          </div>
          <BoxAux>
            { listUbs.length ? <List text="Escolha a unidade desejada" onClick={setSelectedUbs} listUbs={listUbs} /> : null}
          </BoxAux>
        </BoxLeft>
        <BoxRight>
          { listUbs.length ? <Calendar onClick={setDaySelected}/> : null}
          { listHours.length ? <Hours onClick={setSelectedHour} listHours={listHours} /> : null}
          {hourSelected && <button text="Agendar atendimento" onClick={()=>{
            swal({
              text: "Deseja finalizar seu agendamento?",
              buttons: true,
              closeOnClickOutside: false,
              buttons: {
                cancel: 'Cancelar',
                confirm: {
                  text: 'Confirmar',
                  className: 'confirmar'
                },
              },
            })
            .then(agendar => {
              if (agendar) cadastrar()
            });
          }}
          >Agendar</button>}
        </BoxRight>
      </Content>
    </Page>
  );
};

