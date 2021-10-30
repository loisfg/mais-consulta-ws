import React, { useState, useCallback } from "react";
import { CustomForm, InputFamily, CustomStack } from "./styles";
import { Stepper, IconButton } from '../'
import { PersonalData } from "./PersonalData";
import { Address } from "./Address";
import { AccessData } from './AccessData';
import ArrowRight from '../../assets/arrow_right.svg';
import Check from '../../assets/check.svg';
import api from "../../services/api"
import swal from "sweetalert";

export const SignUp = ({ setValue }) => {

  const [formData, setFormData] = useState({
    cpf: '',
    email: '',
    password: '',
    telefone: '',
    paciente: {
      nome: '',
      numeroCarteiraSus: '',
      sexo: '',
      dtNascimento: '',
      endereco: {
        cep: '',
        cidade: '',
        complemento: '',
        estado: '',
        logradouro: '',
        numero: ''
      }
    }
  })

  const [activeStep, setActiveStep] = useState(0)

  const handleCadastro = useCallback(
    async (e) => {
      e.preventDefault()

      try {

        const response = await api.post("paciente/paciente/signup", formData)

        if (response.status === 201) {
          swal("Cadastro realizado com sucesso!!")
          setValue(0)
          setFormData({})
        } else if (response.status === 409) {
          swal("Usuario já cadastrado")
          setValue(0)
          setFormData({})
        }

      } catch (erro) {
        console.log(erro);
        setValue(0)
        setFormData({})
      }

    }, [formData, setValue])

  function handleNextStep(event) {
    event.preventDefault()
    setActiveStep(activeStep + 1)
    console.log(formData);
  }
  function handleBackStep(event) {
    event.preventDefault()
    setActiveStep(activeStep - 1)
    console.log(formData);
  }

  return (
    <CustomForm>
      <Stepper
        steps={["Dados pessoais", "Endereço", "Dados de acesso"]}
        activeStep={activeStep}
      />
      <InputFamily>
        {
          activeStep === 0 && <PersonalData
            formData={formData}
            setFormData={setFormData}
          />
        }
        {
          activeStep === 1 && <Address
            formData={formData}
            setFormData={setFormData}
          />
        }
        {
          activeStep === 2 && <AccessData
            formData={formData}
            setFormData={setFormData}
          />
        }
      </InputFamily>
      <CustomStack isFirst={activeStep === 0}>
        {activeStep >= 1 && <IconButton onClick={handleBackStep} />}
        {activeStep >= 0 && activeStep < 2 ? <IconButton
          onClick={handleNextStep} Arrow={ArrowRight} /> :
          <IconButton onClick={handleCadastro} Arrow={Check} />}
      </CustomStack>
    </CustomForm>
  );
};
