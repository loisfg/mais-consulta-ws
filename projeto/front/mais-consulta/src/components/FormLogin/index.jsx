import * as React from 'react';
import { Container, Div } from './styles';
import { Button, Input, Checkbox } from '../'

export const FormLogin = () => 
<Container>
  <Input label='CPF'/>
  <Input label='Senha'/>
  <Div>
    <Checkbox label='Lembrar de mim'/>
    <Button text='Entrar'/>
  </Div>
</Container>