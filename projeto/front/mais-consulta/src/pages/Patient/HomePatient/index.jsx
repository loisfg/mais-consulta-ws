import { Page } from "./styles";
import { DivUsuario, AuxDiv, Content } from "./styles";
import {
  UserProfilePic,
  Schedule,
  WelcomeMessage,
  NextWeek,
} from "../../../components";

export const HomePatient = ({ usuario }) => {
  return (
    <Page>
      <AuxDiv>
        <DivUsuario>
          <UserProfilePic nome={usuario.paciente.nome} subtexto="Paciente" />
        </DivUsuario>
        <Content>
          <WelcomeMessage />
          <NextWeek />
          <Schedule />
        </Content>
      </AuxDiv>
    </Page>
  );
};