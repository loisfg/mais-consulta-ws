import React from 'react';
import { CustomInput } from './styles';

export const Input = ({ size, label, onChange, type, value, endAdornment }) =>
    <CustomInput
        onChange={onChange}
        type={type}
        label={label}
        variant="standard"
        size={size}
        value={value}
        endAdornment={endAdornment}
    />

