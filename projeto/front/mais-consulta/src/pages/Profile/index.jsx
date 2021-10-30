import React from 'react';
import { TextSubtext, DataBox } from '../../components';
import { Container, CustomAvatar, PatientGroup, H2  } from './styles'

export const Profile = ({userName, }) => {
  return (
    <Container>
        <PatientGroup>
          <CustomAvatar sx={{ bgcolor: 'deepskyblue' }}/>
          <TextSubtext textOne='Thais Calazans'></TextSubtext>
          <H2> Paciente</H2>
        </PatientGroup>
        {/* <label> Dados cadastrais </label> */}
       
        <DataBox>
          {/* <Input size="medium" label="Outlined" variant="outlined"></Input> */}
        </DataBox>:
    </Container>
  );
}