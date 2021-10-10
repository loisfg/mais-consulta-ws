import { Page } from "./styles";
import { DivUsuario } from "./styles";
import { UserProfilePic, Menu, Message, CustomBox, DivLeft, DivRight } from "../../components"

function HomePatient() {
  return (
    <Page>
      <Menu/>
      <DivUsuario>
        <UserProfilePic nome="Tha Calazans" subtexto=" Paciente" />
      </DivUsuario>
      <Message textOne="Bem vindo" textOne="Agende agora" />
      <CustomBox />
       
    </Page>
  );
};

export default HomePatient;