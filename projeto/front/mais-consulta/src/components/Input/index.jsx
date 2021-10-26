import React from 'react';
import { CustomInput } from './styles';

export const Input = ({ size, label, onChange,type }) =>
    <CustomInput 
    onChange={onChange} 
    type={type}
    label={label} 
    variant="standard" 
    size={size}
    />
