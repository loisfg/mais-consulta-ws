import React, { useState } from "react";
import { Container } from "./styles";
import { Stepper, Input } from '../'

export const SignUp = ({activeStep}) => {
  return (
    <Container>
      <Stepper steps={["Dados pessoais", "Endereço", "Dados de acesso"]} 
               activeStep= {activeStep}/>
      <Input size='small' label="Nome completo"/>
      <Input size='small' label="CPF"/>
      <Input size='small' label="RG"/>
    </Container>
  );
};
