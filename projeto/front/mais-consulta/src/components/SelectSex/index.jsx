import React from 'react';
import { CustomSelect, CustomSelectLabel, CustomFormControl } from './styles';
import { MenuItem } from '@material-ui/core';

export const SelectSex = ({ formData, setFormData, required }) => {

  return (
    <CustomFormControl variant="standard" sx={{ m: 1 }}>
      <CustomSelectLabel id='select-label'>Sexo</CustomSelectLabel>
      <CustomSelect variant='standard'
        size='medium'
        id='select'
        labelId='select-label'
        label="Sexo"
        required={required}
        onChange={e => {

          setFormData({
            ...formData,
            paciente: {
              ...formData.paciente,
              sexo: e.target.value
            }
          })

        }}

        defaultValue={formData.paciente.sexo}
      >
        <MenuItem value={"feminino"}>Feminino</MenuItem>
        <MenuItem value={"masculino"}>Masculino</MenuItem>
      </CustomSelect>
    </CustomFormControl>
  );
}