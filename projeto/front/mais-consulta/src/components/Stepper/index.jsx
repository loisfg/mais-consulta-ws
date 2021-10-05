import React from 'react';
import { StyledStepper, StyledStep, StyledStepLabel } from './styles';

export function Stepper({steps, activeStep}) {
  return <StyledStepper activeStep={activeStep} alternativeLabel>
      {steps.map((label) => (
        <StyledStep key={label}>
            <StyledStepLabel>{label}</StyledStepLabel>
        </StyledStep>
    ))}
  </StyledStepper>;
}