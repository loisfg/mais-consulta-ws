import React from 'react';
import { CustomTextField } from './styles';

export const Input = ({ size, required, label, onChange }) =>
    <CustomTextField 
    onChange={onChange} 
    label={label} 
    variant="standard" 
    required={required}
    size={size} />
