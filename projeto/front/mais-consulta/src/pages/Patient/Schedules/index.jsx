import React, { useState, useEffect } from "react";
import api from "../../../services/api"
import { Page } from "./styles";
import { DivUsuario, Content, BoxLeft, BoxRight, BoxAux } from "./styles";
import { UserProfilePic, Message, List, Calendar, Hours } from "../../../components";
import swal from 'sweetalert';
import Select, { StylesConfig } from 'react-select';
export const Schedules = ({ usuario }) => {
  const specialties = [
    {value: 'Acupuntura', label: 'Acupuntura'},
    {value: 'Alergia e Imunologia', label: 'Alergia e Imunologia'},
    {value: 'Anestesiologia', label: 'Anestesiologia'},
    {value: 'Medicina Legal e Perícia Médica', label: 'Medicina Legal e Perícia Médica'},
    {value: 'Medicina Nuclear', label: 'Medicina Nuclear'},
    {value: 'Reumatologia', label: 'Reumatologia'},
    {value: 'Urologia', label: 'Urologia'},
    {value: 'Áreas de Atuação reconhecidas', label: 'Áreas de Atuação reconhecidas'},
    {value: 'Administração em Saúde', label: 'Administração em Saúde'},
    {value: 'Ecografia Vascular com Doppler', label: 'Ecografia Vascular com Doppler'},
    {value: 'Eletrofisiologia Clínica Invasiva', label: 'Eletrofisiologia Clínica Invasiva'},
    {value: 'Psiquiatria da Infância e Adolescência', label: 'Psiquiatria da Infância e Adolescência'},
    {value: 'Psiquiatria Forense', label: 'Psiquiatria Forense'},
    {value: 'Radiologia Intervencionista e Angiorradiologia', label: 'Radiologia Intervencionista e Angiorradiologia'},
    {value: 'Reumatologia Pediátrica', label: 'Reumatologia Pediátrica'},
    {value: 'Sexologia', label: 'Sexologia'},
    {value: 'Transplante de Medula Óssea', label: 'Transplante de Medula Óssea'},
    {value: 'Ultrassonografia em Ginecologia e Obstetrícia', label: 'Ultrassonografia em Ginecologia e Obstetrícia'},
]
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

