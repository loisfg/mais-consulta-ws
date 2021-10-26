import React from 'react';
import { TextSubtext, DataBox } from '../../components';
import { Container, CustomAvatar, PatientGroup } from './styles'

export const Profile = ({userName, }) => {
  return (
    <Container>
        <PatientGroup>
          <CustomAvatar sx={{ bgcolor: 'deepskyblue' }}/>
          <TextSubtext textOne='Thais Calazans'></TextSubtext>
        </PatientGroup>
        <label> Dados cadastrais </label>
        <DataBox>
        </DataBox>
    </Container>
  );
}