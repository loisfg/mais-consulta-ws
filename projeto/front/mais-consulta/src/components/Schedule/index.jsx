import React from 'react';
import { Container, LeftSide, RightSide } from './styles';
import { TextSubtext } from '../../components';
export const Schedule = ({date}) => {
  return (
      <Container>
          <LeftSide>
            <TextSubtext textOne = "Segunda" textTwo= "oi"/>
            <TextSubtext textOne = "Terça" textTwo= "oi"/>
            <TextSubtext textOne = "Quarta" textTwo= "oi"/>
            <TextSubtext textOne = "Quinta" textTwo= "oi"/>
            <TextSubtext textOne = "Sexta" textTwo= "oi"/>
            <TextSubtext textOne = "Sábado" textTwo= "oi"/>
          </LeftSide>
          <RightSide>
            olaa
          </RightSide>
      </Container>
  );
}