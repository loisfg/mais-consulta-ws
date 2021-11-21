import React from 'react';
import { Field } from './styles';
import InputAdornment from '@mui/material/InputAdornment';

export const SmallInput = ({measure, ...rest}) => {
  return(
        <Field
            id="filled-adornment-weight"
            endAdornment={<InputAdornment position="end">{measure}</InputAdornment>}
            aria-describedby="filled-weight-helper-text"
            {...rest}
        />
  );
}