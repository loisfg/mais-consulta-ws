import { Page } from "./styles";
import { DivUsuario, AuxDiv, Content } from "./styles";
import { UserProfilePic, Menu, Schedule } from "../../components"

function HomePatient() {
  return (
    <Page>
      <Menu/>
      <AuxDiv>
        <DivUsuario>
          <UserProfilePic nome="Tha Calazans" subtexto=" Paciente" />
        </DivUsuario>
        <Content>
          <Schedule/>
          {/* <Calendar/> */}
        </Content>
      </AuxDiv>
    </Page>
  );
};

export default HomePatient;