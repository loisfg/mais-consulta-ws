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
  const [daySelected, setdaySelected] = useState();
  const [horaSelecionada, setHoraSelecionada] = useState();

  function cadastrar(e) {
    e.preventDefault();
    console.log(horaSelecionada)
    console.log(daySelected)
    // const data = {
    //   descricao: "dermatologia",
    //   dtAtendimento: daySelected,
    //   hrAtendimento: {
    //       hour: 12,
    //       minute: 10,
    //       nano: 0,
    //       second: 0
    //     },
    //     idEspecialidade: 1,
    //     idPaciente: usuario.paciente.id,
    //     ubs: 1,
    //     data: dataSelecionada,
    //     hora: horaSelecionada  
    // }
    // await api("http://9ea7-2804-420c-102d-1900-3dfd-fba6-31db-6902.ngrok.io/mais-consulta")
    // .post()
    // console.log(listUbs+daySelected+horaSelecionada);
    // api.post("/agendamento/1/1/2/agendar/consulta", {
      // descricao: "string",
      // dtAtendimento: "string",
      // hrAtendimento: {
      //   hour: 12,
      //   minute: 10,
      //   nano: 0,
      //   second: 0
      // },
      // idEspecialidade: 1,
      // idPaciente: usuario.paciente.id,
      // ubs: 1,
      // data: dataSelecionada,
      // hora: horaSelecionada
    // }).then((resposta) => {
    //   alert("Agendou")
    // }).catch((erro) => {
    //   alert("Erro ao cadastrar música!")
    // });
  }

//   usuario.paciente.nome
  return (
    <Page>
      <DivUsuario>
        <UserProfilePic nome="{usuario.paciente.nome}" subtexto=" Paciente" />
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
          <button text="Agendar atendimento" onClick={cadastrar}
          //   swal({
          //     text: "Deseja finalizar seu agendamento?",
          //     buttons: true,
          //     closeOnClickOutside: false,
          //     buttons: {
          //       cancel: 'Cancelar',
          //       confirm: {
          //         text: 'Confirmar',
          //         className: 'confirmar',
          //         onClick: {cadastrar}
          //       },

          //     },
          //   })
          //     .then((agendar) => {
          //       if (agendar) {
          //         swal("Deseja baixar o documento de confirmação do agendamento?", {
          //           icon: "success",
          //         });
                 

          //       } else {
          //         swal("Agendamento cancelado", {
          //           icon: "error",
          //         });

          //       }
          //     });
          // }}
          >clica</button>
          {/* <Button type="submit" text="Agendar atendimento" /> */}
        </BoxRight>
      </Content>
    </Page>
  );
};

