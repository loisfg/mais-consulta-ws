import React from 'react';
import { TextSubtext } from '../../components';
import { Container, CustomAvatar, PatientGroup } from './styles'

export const Profile = ({userName, }) => {
  return (
    <Container>
        <PatientGroup>
          <CustomAvatar sx={{ bgcolor: 'deepskyblue' }}/>
          <TextSubtext textOne='Thais Calazans'></TextSubtext>
        </PatientGroup>
        <iframe className="leftSide">
          <label> Dados cadastrais </label>
          <div>
          </div>
        </iframe>
    </Container>
  );
}