import { Page } from "./styles";
import { DivUsuario } from "./styles";
import { UserProfilePic, Menu } from "../../components"

function HomePatient() {
  return (
    <Page>
      <Menu/>
      <DivUsuario>
        <UserProfilePic nome="Tha Calazans" subtexto=" Paciente" />
      </DivUsuario>
    </Page>
  );
};

export default HomePatient;