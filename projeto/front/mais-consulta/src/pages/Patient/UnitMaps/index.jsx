import { Page } from "./styles";
import { DivUsuario, Content, BoxLeft, BoxRight } from "./styles";
import { UserProfilePic, Message, List, Maps } from "../../../components"

export const UnitMaps = () => {
    return (
        <Page>
            <DivUsuario>
                <UserProfilePic nome="Tha Calazans" subtexto=" Paciente" />
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
}