import React from 'react';
import { CustomSelect, CustomSelectLabel } from './styles';
import { MenuItem } from '@material-ui/core';

export const Select = () => {
  return (
    <div>
      <CustomSelectLabel>Sexo</CustomSelectLabel>
      <CustomSelect variant='standard' size='medium'>
          <MenuItem value="">
            <em>None</em>
          </MenuItem>
          <MenuItem value={10}>Ten</MenuItem>
          <MenuItem value={20}>Twenty</MenuItem>
          <MenuItem value={30}>Thirty</MenuItem>
      </CustomSelect>
    </div>
  );
}