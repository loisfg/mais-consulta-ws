import React, { useState } from "react";
import { Container, DivInput } from "./styles";
import { Stepper, Input } from '../'

export const SignUp = ({activeStep}) => {
  return (
    <Container>
      <Stepper steps={["Dados pessoais", "Endereço", "Dados de acesso"]} 
               activeStep= {activeStep}/>
      <Input required='required' label="Nome completo"/>
      <DivInput>
        <Input label="CPF"/>
        <Input label="RG"/>
      </DivInput>
    </Container>
  );
};
