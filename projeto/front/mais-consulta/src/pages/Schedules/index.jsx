import { Page } from "./styles";
import { AuxDiv, DivUsuario, Content, BoxLeft, BoxRight, Footer } from "./styles";
import { UserProfilePic, Message, Specialty, List, Calendar, Hours, Button } from "../../components"

export const Schedules = () => {
    return (
        <Page>
           <AuxDiv>
                <DivUsuario>
                    <UserProfilePic nome="Tha Calazans" subtexto=" Paciente" />
                </DivUsuario>
            </AuxDiv>
            <Content>
                <BoxLeft>
                    <Message textOne="Bem-vindo!" textTwo="Agende agora" />
                    <Specialty nameSpecialty="Dermatologia" />
                    <List/>
                </BoxLeft>
                <BoxRight>
                    <Calendar />
                    <Hours />
                </BoxRight>
            </Content>
            <Footer>
                <Button text="Agendar atendimento" /> 
            </Footer>
        </Page>
    );
}