import React from 'react';
import { CustomTextField } from './styles';

export const Input = ({size, required, label, fullWidth}) => 
<CustomTextField label={label} variant="standard" required={required} 
size={size} />