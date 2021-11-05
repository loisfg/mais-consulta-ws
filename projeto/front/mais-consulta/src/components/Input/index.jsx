import React from 'react';
import { CustomInput } from './styles';

export const Input = ({ onBlur, size, label, onChange, type, value, defaultValue, helperText, placeholder, maxlength, required }) =>
    <CustomInput
        onBlur={onBlur}
        onChange={onChange}
        type={type}
        label={label}
        variant="standard"
        size={size}
        value={value}
        defaultValue={defaultValue}
        helperText={helperText}
        placeholder={placeholder}
        required={required}
    />

