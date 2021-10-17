import { Page } from "./styles";
import { DivUsuario, Content, BoxLeft, BoxRight } from "./styles";
import { UserProfilePic, Message, Specialty, List, Calendar, Hours, Button } from "../../components"

export const Schedules = () => {
    return (
        <Page>
            <DivUsuario>
                <UserProfilePic nome="Tha Calazans" subtexto=" Paciente" />
            </DivUsuario>
            <Content>
                <BoxLeft>
                    <Message textOne="Bem-vindo!" textTwo="Agende agora" />
                    <Specialty nameSpecialty="Dermatologia" />
                    <List/>
                </BoxLeft>
                <BoxRight>
                    <Calendar />
                    <Hours />
                    <Button text="Agendar atendimento" /> 
                </BoxRight>
            </Content>
       </Page>
    );
}