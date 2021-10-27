import React from 'react';
import { CustomStyledCheckbox } from "./styles"
import { FormControlLabel } from '@material-ui/core';

export const Checkbox = ({ label }) =>
  <FormControlLabel
    control={
      <CustomStyledCheckbox
        defaultChecked
        sx={{ '& .MuiSvgIcon-root': { fontSize: '2.7rem', color: "#3C5D7C" } }}
      />
    }
    label={label}
  />