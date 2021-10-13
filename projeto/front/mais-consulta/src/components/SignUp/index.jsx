import React, { useState } from "react";
import { Container, InputFamily, CustomStack } from "./styles";
import { Stepper, IconButton } from '../'
import { PersonalData } from "./PersonalData";
import { Address } from "./Address";
import { AccessData } from './AccessData';
import ArrowRight from '../../assets/arrow_right.svg';
import Check from '../../assets/check.svg';
import swal from 'sweetalert';

export const SignUp = () => {
  const dataForm = {
    personalData: {
      name: '',
      cpf: '',
      rg: '',
      sex: '',
      cellphone: '',
      susCard: ''
    },
    address: {
      cep: '',
      city: '',
      state: '',
      street: '',
      number: '',
      complement: '',
    },
    accessData: {
      email: '',
      password: '',
      confirmPassword: ''
    }
  }
  const [form, setForm ] = useState(dataForm);
  const [activeStep, setActiveStep] = useState(0)
  function handleStepCompleted(event) {
    swal("Cadastro realizado com sucesso!")
  }
  function handleNextStep(event) {
    event.preventDefault()
    setActiveStep(activeStep+1)
    console.log(form.personalData)
  }
  function handleBackStep(event) {
    event.preventDefault()
    setActiveStep(activeStep-1)
  }
  return (
    <Container>
      <Stepper steps={["Dados pessoais", "Endereço", "Dados de acesso"]} 
               activeStep= {activeStep}/>
      <InputFamily>
      {
        activeStep === 0 && <PersonalData data={form.personalData}/>
      }
      {
        activeStep === 1 && <Address/>
      }
      {
        activeStep === 2 && <AccessData/>
      }
      </InputFamily>
      <CustomStack isFirst = {activeStep === 0}>
        {activeStep >= 1 && <IconButton onClick={handleBackStep}/>}
        {activeStep >= 0 && activeStep < 2 ? <IconButton onClick={handleNextStep} Arrow= {ArrowRight} /> : 
        <IconButton onSubmit={handleStepCompleted} Arrow= {Check}/> }
      </CustomStack>
    </Container>
  );
};
