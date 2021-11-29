import React, { useState, useEffect } from "react";
import api from "../../../services/api"
import { specialties } from "./specialitiesData";
import { Page } from "./styles";
import { DivUsuario, Content, BoxLeft, BoxRight, BoxAux } from "./styles";
import { UserProfilePic, Message, List, Calendar, Hours } from "../../../components";
import swal from 'sweetalert';
import Select from 'react-select';
export const Schedules = () => {
  const [listUbs, setListUbs] = useState([]);
  const [daySelected, setdaySelected] = useState([0]);
  const [horaSelecionada, setHoraSelecionada] = useState();
  const [especialidade, setEspecialidade] = useState();
  const userId = localStorage.getItem("id"); 
 
   async function cadastrar(e) {
    e.preventDefault();
    
    const data = {
      descricao: "Dermatologia",
      dtAtendimento: daySelected,
      hrAtendimento: horaSelecionada,
      idEspecialidade : 8,
      idPaciente: userId,
      idUbs: listUbs
    }
    await api("mais-consulta").post("/agendamento/agendar/consulta", data)
    console.log("req"+data)
  }
  useEffect(() => {
    console.log("ubs"+listUbs)
  }, [listUbs])

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
            <Select options={specialties} className='react-select-container'/>
          </div>
          <BoxAux>
            <List text="Escolha a unidade desejada" listUbs={listUbs} setListUbs={setListUbs}  />
          </BoxAux>
        </BoxLeft>
        <BoxRight>
          <Calendar setdaySelected={setdaySelected}/>
          <Hours setHoraSelecionada={setHoraSelecionada} />
          <button text="Agendar atendimento" onClick={()=>{
            swal({
              text: "Deseja finalizar seu agendamento?",
              buttons: true,
              closeOnClickOutside: false,
              buttons: {
                cancel: 'Cancelar',
                confirm: {
                  text: 'Confirmar',
                  className: 'confirmar',
                  
                  onClick: {cadastrar}
                },

              },
            })
              .then((agendar) => {
                if (agendar) {
                  swal("Deseja baixar o documento de confirmação do agendamento?", {
                    icon: "success",
                    //CHAMAR O ENDPOINT AQUI
                  });
                } else {
                  swal("Agendamento cancelado", {
                    icon: "error",
                  });

                }
              });
          }}
          >Agendar</button>
        </BoxRight>
      </Content>
    </Page>
  );
};

