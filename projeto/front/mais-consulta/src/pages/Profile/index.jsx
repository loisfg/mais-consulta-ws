import React from 'react';
import { Menu, TextSubtext } from '../../components';
import { Container, RightSide, CustomAvatar, PatientGroup } from './styles'

export const Profile = ({userName, }) => {
  return (
    <Container>
      <Menu/>
      <RightSide>
        <PatientGroup>
          <CustomAvatar sx={{ bgcolor: 'deepskyblue' }}/>
          <TextSubtext textOne='Thais Calazans'></TextSubtext>
        </PatientGroup>
      </RightSide>
    </Container>
  );
}