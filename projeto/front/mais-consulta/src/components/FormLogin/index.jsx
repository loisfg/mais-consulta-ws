import React from 'react';
import { Container } from './styles';
import photo from '../../assets/logo.svg';
import { TextField } from '@material-ui/core';

function FormLogin() {
  return (
    <Container>
      <img src={photo} alt="Logo +Consulta" />
      <TextField required label="CPF"></TextField>
      <TextField required label="Senha" style= "margin-top: 10px"></TextField>
    </Container>
  );
}

export default FormLogin;