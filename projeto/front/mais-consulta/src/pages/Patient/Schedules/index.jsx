import React, { useState } from "react";
import api from "../../../services/api"
import { Page } from "./styles";
import { DivUsuario, Content, BoxLeft, BoxRight, BoxAux } from "./styles";
import {
  UserProfilePic,
  Message,
  Specialty,
  List,
  Calendar,
  Hours,
  Button,
} from "../../../components";
import swal from 'sweetalert';

export const Schedules = ({ usuario }) => {
  const [listUbs, setListUbs] = useState([]);
  const [daySelected, setdaySelected] = useState([0]);
  const [horaSelecionada, setHoraSelecionada] = useState();

 
    const userId = localStorage.getItem("id"); 
 
   async function cadastrar(e) {
    e.preventDefault();
    
    const data = {
      descricao: "Dermatologia",
      dtAtendimento: daySelected,
      hrAtendimento: horaSelecionada,
      idEspecialidade : 1,
      idPaciente: userId,
      idUbs: listUbs
    }
    await api("http://551f-189-78-204-97.ngrok.io/mais-consulta")
    .post("/agendamento/agendar/exame", data)

  }
  const typeOfUser = localStorage.getItem("role");
  return (
    <Page>
      <DivUsuario>
        <UserProfilePic />
      </DivUsuario>
      <Content>
        <BoxLeft>
          <Message textOne="Novo agendamento de consulta" textTwo="" />
          <Specialty nameSpecialty="Dermatologia" />
          <BoxAux>
            <List text="Escolha a unidade desejada" setListUbs={setListUbs}/>
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
                  });
                 

                } else {
                  swal("Agendamento cancelado", {
                    icon: "error",
                  });

                }
              });
          }}
          >clica</button>
          {/* <Button type="submit" text="Agendar atendimento" /> */}
        </BoxRight>
      </Content>
    </Page>
  );
};

