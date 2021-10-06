import React from 'react';
import { CustomTextField } from './styles';

export const Input = ({ size, label, onChange }) => <CustomTextField onChange={onChange} required size={size}
    label={label} />