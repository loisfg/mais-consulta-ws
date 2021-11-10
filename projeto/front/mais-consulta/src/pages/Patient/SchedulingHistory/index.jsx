import React from 'react';
import { Page } from "./styles";
import { DivUsuario, DivComboBox, LeftSide, RightSide, Container } from './styles';
import { UserProfilePic, WelcomeMessageTwo, SchedulingTwo } from '../../../components'



export const SchedulingHistory = ({ usuario }) => {
  return (
    <Page>
        <DivUsuario>
             <UserProfilePic nome={usuario.paciente.nome} subtexto="Paciente" />
        </DivUsuario>
        <WelcomeMessageTwo/>
        <DivComboBox>
        <LeftSide>

        </LeftSide>
        
        <RightSide>

        </RightSide>

        </DivComboBox>
          <Container>
          <SchedulingTwo/>
          </Container>
      

    </Page>
  );
}

