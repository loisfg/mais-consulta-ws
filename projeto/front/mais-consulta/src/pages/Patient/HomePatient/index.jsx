import { Page } from "./styles";
import { DivUsuario, AuxDiv, Content } from "./styles";
import {
  UserProfilePic,
  Schedule,
  WelcomeMessage,
  NextWeek,
} from "../../../components";

export const HomePatient = ({ usuario }) => {
  const username = localStorage.getItem("nome")
  return (
    <Page>
      <AuxDiv>
        <DivUsuario>
          <UserProfilePic nome={username} subtexto="Paciente" />
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
