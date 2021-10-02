import React from 'react';
import { Container, CustomTextField } from './styles';
import photo from '../../assets/logo.svg';

import { TextField } from '@material-ui/core';


function FormLogin() {
  return (
    <Container>
      <img src={photo} alt="Logo +Consulta" />
      <CustomTextField required label="CPF"></CustomTextField>
      <CustomTextField required label="Senha"></CustomTextField>
    </Container>
  );
}

export default FormLogin;