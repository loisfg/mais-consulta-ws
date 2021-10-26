import { TextField } from "@material-ui/core";
import styled from 'styled-components';

const small = '30%';
const medium = '45%';
const big = '100%';

export const CustomInput = styled(TextField)`
  width: ${({size}) => size === 'small'? small : 
          size === 'medium' ? medium : big
  };
  > label{
    font-size: 1.2rem !important;
  }
`;
