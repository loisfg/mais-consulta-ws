import React, { useState, useEffect } from "react";
import { Page } from "./styles";
import { DivUsuario, Content, BoxLeft, BoxRight, BoxAux } from "./styles";
import { UserProfilePic, Message, Specialty, List, Calendar, Hours, Button } from "../../components";
import api from "../../../src/services/api";
import swal from 'sweetalert';

export const Schedules = ({ usuario }) => {

  // const [listUbs, setListUbs] = useState([]);

  // useEffect(() => {
  //   async function searchListUbs() {
  //     const resp = awaitapi("maisconsulta").get("")
  //     setListUbs(resp.data)
  //     console.log("log", resp.data);
  //   }
  //   searchListUbs();
  // },[]);


  // const alergia = [
  //     {
  //         nome: "formiga"
  //     }
  // ]
  // async function schedule() {
  //     requisicao("post","infos/alergia/","formiga")
  // }

  return (

    <Page>
      <DivUsuario>
        <UserProfilePic nome="Tha Calazans" subtexto=" Paciente" />
      </DivUsuario>
      <Content>
        <BoxLeft>
          <Message textOne="Novo agendamento de consulta" textTwo="" />
          <Specialty nameSpecialty="Dermatologia" />
          <BoxAux>
            <List text="Escolha a unidade desejada" />
          </BoxAux>
        </BoxLeft>
        <BoxRight>
          <Calendar />
          <Hours />
          <button text="Agendar atendimento" onClick={() => {
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
        </BoxRight>
      </Content>
    </Page>
  );
}