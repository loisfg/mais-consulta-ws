import React from 'react';
import { Page } from "./styles";
import { DivUsuario, DivComboBox, LeftSide, RightSide, Container, H3, Agrupamento } from './styles';
import { UserProfilePic, WelcomeMessageTwo, SchedulingTwo, AutoCompleteInput, Button, ButtonTwo } from '../../../components'
export const SchedulingHistory = ({ usuario }) => {
  return (
    <Page>
        <DivUsuario>
             <UserProfilePic/>
        </DivUsuario>
        <WelcomeMessageTwo/>
        <DivComboBox>
        <LeftSide>\
         <Agrupamento>
         <H3> Perído </H3>
        <AutoCompleteInput  label={"Dias da semana"}/>
         </Agrupamento>
         <Agrupamento>
         <H3> Especilidade </H3>
        <AutoCompleteInput  label={"Gastro"}/>
         </Agrupamento>
         <Agrupamento>
         <H3> Tipo de procedimento </H3>
        <AutoCompleteInput  label={"Exames"}/>
         </Agrupamento>
         
        
        </LeftSide>
        
        <RightSide>
        <ButtonTwo type="submit" text='Baixar Selecionados'/>
        <Button type="submit" text='Baixar Tudo'/>
        </RightSide>

        </DivComboBox>
          <Container>
          <SchedulingTwo/>
          
          </Container>
      

    </Page>
  );
}

