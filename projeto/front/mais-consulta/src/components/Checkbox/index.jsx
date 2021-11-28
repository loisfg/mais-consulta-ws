import React from "react";
import { CustomStyledCheckbox } from "./styles";
import { FormControlLabel } from "@material-ui/core";

export const Checkbox = ({ label, onClick, checked, color }) => (
  <FormControlLabel
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
