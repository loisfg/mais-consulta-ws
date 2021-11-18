import React from 'react';
import { DivInput } from './styles';


export const InputData = ({ size, label, onChange, type }) => {
  return (
    <DivInput
    onChange={onChange} 
    type={type}
    label={label} 
    variant="Outlined" 
    size={size}
    />
  );
}

