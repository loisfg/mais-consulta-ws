import React from 'react';
import { Container, Text, TextOne, TextTwo} from './styles';
import { Button } from "../../components";


export const NoScheduling = () => {
  return (
    <Container>
        <Text>
            <TextOne>
            Você não possui agendamentos nesse período :)
            </TextOne>
            <TextTwo>
            Vamos agendar uma consulta hoje?
            </TextTwo>
        </Text>
     
       <Button type="submit" text='Agendar agora' />
       
    </Container>

  );
};

