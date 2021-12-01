import React, { useEffect } from "react";
import { CustomStyledCheckbox, CustomForm } from "./styles";
export const Checkbox = ({ label, color, ...rest }) => 
{
  useEffect(()=> console.log(rest), [rest])
  return(
  <CustomForm
    control={
      <CustomStyledCheckbox
        sx={{ "& .MuiSvgIcon-root": { color: {color} } }}
        onChange={rest.onChange}
        value={rest.value}
        {...rest}
      />
    }
    label={label}
  />
);
}