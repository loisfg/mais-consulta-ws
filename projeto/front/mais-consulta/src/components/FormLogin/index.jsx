import * as React from 'react';
import { Container, CustomTextField, Button, Div } from './styles';
import { Checkbox, FormControlLabel } from '@material-ui/core';

function FormLogin() {
  return (
    <Container>
      <CustomTextField required label="CPF"></CustomTextField>
      <CustomTextField required label="Senha"></CustomTextField>
      <Div>
        <FormControlLabel
          control={
            <Checkbox
                defaultChecked
                sx={{ '& .MuiSvgIcon-root': { fontSize: 24, color: "#3C5D7C" } }}
            />
          }
          label="Lembrar de mim"
        />
        <Button>Entrar</Button>
      </Div>
    </Container>
  );
}

export default FormLogin;