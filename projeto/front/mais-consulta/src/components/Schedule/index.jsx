import React from 'react';
import { Container, LeftSide, RightSide, Line } from './styles';
import { TextSubtext, Stickers } from '../../components';

export const Schedule = ({date}) => {
  return (
      <Container>
          <LeftSide>
            <TextSubtext textOne = "Segunda" textTwo= "20.09"/>
            <TextSubtext textOne = "Terça" textTwo= "21.09"/>
            <TextSubtext textOne = "Quarta" textTwo= "22.09"/>
            <TextSubtext textOne = "Quinta" textTwo= "23.09"/>
            <TextSubtext textOne = "Sexta" textTwo= "24.09"/>
            <TextSubtext textOne = "Sábado" textTwo= "25.09"/>
          </LeftSide>
          <RightSide>
            <Line>
              <Stickers color="purple" specialty="Dentista"  hour="10am-11am"/>
              <Stickers specialty="Dermatologista"  hour="07am-08am"/>
            </Line>
            <Line/>
            <Line/>
            <Line>
              <Stickers specialty="Pediatra"  hour="08am-09am"></Stickers>
            </Line>
            <Line/>
            <Line/>
          </RightSide>
      </Container>
  );
}