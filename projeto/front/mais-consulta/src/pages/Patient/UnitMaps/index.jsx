import { Page } from "./styles";
import { DivUsuario, Content, BoxLeft, BoxRight } from "./styles";
import { UserProfilePic, Message, List, Maps } from "../../../components";
const username = localStorage.getItem("nome");
const typeOfUser = localStorage.getItem("role");
export const UnitMaps = () => {
  return (
    <Page>
      <DivUsuario>
        <UserProfilePic nome={username} subtexto={String(typeOfUser.toLocaleLowerCase())} />
      </DivUsuario>
      <Content>
        <BoxLeft>
          <Message textOne="Unidades próximas a você" textTwo="" />
          <List />
        </BoxLeft>
        <BoxRight>
          <Maps />
        </BoxRight>
      </Content>
    </Page>
  );
};
