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

export const Schedules = ({ username }) => {

//   usuario.paciente.nome
  return (
    <Page>
      <DivUsuario>
        <UserProfilePic nome={username} subtexto=" Paciente" />
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
