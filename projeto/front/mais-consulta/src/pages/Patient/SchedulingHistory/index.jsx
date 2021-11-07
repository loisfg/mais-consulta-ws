import React from 'react';
import { Container, DivUsuario, Mensage} from './styles';
import { UserProfilePic} from '../../../components'

// import { Container } from './styles';

export const SchedulingHistory = ({ usuario }) => {
  return (
    <Container>
        <DivUsuario>
             <UserProfilePic nome={usuario.paciente.nome} subtexto="Paciente" />
        </DivUsuario>
           <Mensage>
                Histórico de agendamentos
           </Mensage>
    </Container>
    
  );
}

