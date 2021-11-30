import React from "react";
import { CustomStyledCheckbox, CustomForm } from "./styles";
export const Checkbox = ({ label, onClick, checked, color }) => (
  <CustomForm
    control={
      <CustomStyledCheckbox
        defaultChecked
        sx={{ "& .MuiSvgIcon-root": { color: {color} } }}
        onClick={onClick}
        checked={checked}
      />
    }
    label={label}
  />
);
