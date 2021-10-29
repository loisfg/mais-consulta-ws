import React from 'react';
import { CustomInput } from './styles';

export const Input = ({ size, label, onChange,type,variant}) =>
    <CustomInput 
    onChange={onChange} 
    type={type}
    label={label} 
    variant={variant}
    size={size}

    />

    