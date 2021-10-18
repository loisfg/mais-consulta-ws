import React from 'react';
import { Checkbox as StyledCheckbox, FormControlLabel } from '@material-ui/core';

export const Checkbox = ({label}) => 
<FormControlLabel
control={
  <StyledCheckbox
    defaultChecked
    sx={{ '& .MuiSvgIcon-root': { fontSize: '2.7rem', color: "#3C5D7C" } }}
  />
}
label= {label}
/>