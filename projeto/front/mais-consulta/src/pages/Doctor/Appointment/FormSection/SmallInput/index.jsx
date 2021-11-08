import React from 'react';
import { Container, Field } from './styles';
import InputAdornment from '@mui/material/InputAdornment';

export default function SmallInput({title, measure}) {
  return(
      <Container>
        <label>{title}</label>
        <Field
            id="filled-adornment-weight"
            endAdornment={<InputAdornment position="end">{measure}</InputAdornment>}
            aria-describedby="filled-weight-helper-text"
        />
      </Container>
  );
}