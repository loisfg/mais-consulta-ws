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

export const Schedules = ({ usuario }) => {

//   usuario.paciente.nome
  return (
    <Page>
      <DivUsuario>
        <UserProfilePic nome={usuario.paciente.nome} subtexto=" Paciente" />
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
          <Button type="submit" text="Agendar atendimento" />
        </BoxRight>
      </Content>
    </Page>
  );
};
import { UserProfilePic, Message, Specialty, List, Calendar, Hours, Button } from "../../../components"
import { useState } from "react";

export const Schedules = (event) => {
    const [ubs,setUbs] = useState();
    return (
        <Page>
            <DivUsuario>
                <UserProfilePic nome="Tha Calazans" subtexto=" Paciente" />
            </DivUsuario>
            <Content>
                <BoxLeft>
                    <Message textOne="Novo agendamento de consulta" textTwo="" />
                    <Specialty nameSpecialty="Dermatologia"/>
                    <BoxAux>
                        <List text="Escolha a unidade desejada" />
                    </BoxAux>
                </BoxLeft>
                <BoxRight>
                    <Calendar />
                    <Hours />
                    <button type="submit" text="Agendar atendimento" onClick = {(e)=>{
                        setspeciality(e.target.value)
                        console.log(e.target.value)
                    }}>CLICAAAA </button>
                </BoxRight>
            </Content>
        </Page>
    );
}
