import { Page } from "./styles";
import { DivUsuario, AuxDiv, Content } from "./styles";
import { UserProfilePic, Menu, Message, CustomBox, DivLeft, DivRight, Calendar } from "../../components"

function HomePatient() {
  return (
    <Page>
      <Menu/>
      <AuxDiv>
        <DivUsuario>
          <UserProfilePic nome="Tha Calazans" subtexto=" Paciente" />
        </DivUsuario>
        <Content>
          <Calendar/>
        </Content>
      </AuxDiv>
    </Page>
  );
};

export default HomePatient;