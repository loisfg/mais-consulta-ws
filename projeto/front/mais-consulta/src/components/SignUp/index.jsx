import React, { useState } from "react";
import { Container, DivInput, InputFamily } from "./styles";
import { Stepper, Input, Select } from '../'

export const SignUp = ({activeStep}) => {
  return (
    <Container>
      <Stepper steps={["Dados pessoais", "Endereço", "Dados de acesso"]} 
               activeStep= {activeStep}/>
      <InputFamily>
        <Input 
        size='big' 
        required='required' 
        label="Nome completo"/>
        <DivInput>
          <Input size='small' label="CPF"/>
          <Input size= 'small' label="RG"/>
        </DivInput>
        <DivInput>
          <Select/>
          <Input size='small' label="Celular"/>
        </DivInput>
        <Input 
        size='big' 
        required='required' 
        label="Número da carteirinha do SUS"/>
      </InputFamily>
    </Container>
  );
};
