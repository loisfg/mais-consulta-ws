import React from 'react';
import { CustomSelect, CustomSelectLabel, CustomFormControl } from './styles';
import { MenuItem } from '@material-ui/core';

export const Select = () => {
  const [sex, setAge] = React.useState('');
  const handleChange = (event) => {
    setAge(event.target.value);
  };
  return (
    <CustomFormControl variant="standard" sx={{ m: 1 }}>
      <CustomSelectLabel id='select-label'>Sexo</CustomSelectLabel>
      <CustomSelect variant='standard'
        size='medium'
        id='select'
        labelId='select-label'
        label="Sexo">
        <MenuItem value={"feminino"}>Feminino</MenuItem>
        <MenuItem value={"masculino"}>Masculino</MenuItem>
      </CustomSelect>
    </CustomFormControl>
  );
}