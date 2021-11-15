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

   async function cadastrar(e) {
    e.preventDefault();
    console.log(daySelected)
    console.log(horaSelecionada)
    const data = {
      descricao: "Dermatologia",
      dtAtendimento: daySelected,
      hrAtendimento: horaSelecionada,
      idEspecialidade : 1,
      idPaciente: 1,
      idUbs: 1
    }
    await api("http://7e02-2804-420c-102d-1900-212f-bb94-2820-461e.ngrok.io/mais-consulta")
    .post("/agendamento/agendar/exame", data)

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

