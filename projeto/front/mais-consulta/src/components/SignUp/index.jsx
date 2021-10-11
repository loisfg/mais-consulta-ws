import React, { useState } from "react";
import { Container, InputFamily, CustomStack } from "./styles";
import { Stepper, IconButton } from '../'
import { PersonalData } from "./PersonalData";
import { Address } from "./Address";
import ArrowRight from '../../assets/arrow_right.svg'
import LeftArrow from '../../assets/left_arrow.svg'

export const SignUp = () => {
  const [activeStep, setActiveStep] = useState(0)
  function handleNextStep(event) {
    setActiveStep(activeStep+1)
  }
  function handleBackStep(event) {
    setActiveStep(activeStep-1)
  }
  return (
    <Container>
      <Stepper steps={["Dados pessoais", "Endereço", "Dados de acesso"]} 
               activeStep= {activeStep}/>
      <InputFamily>
      {
        activeStep === 0 && <PersonalData/>
      }
      {
        activeStep === 1 && <Address/>
      }
      </InputFamily>
      <CustomStack>
        { activeStep >= 1 && <IconButton onClick={handleBackStep} Arrow= {LeftArrow}/>}
        <IconButton onClick={handleNextStep} Arrow= {ArrowRight} />
      </CustomStack>
    </Container>
  );
};
