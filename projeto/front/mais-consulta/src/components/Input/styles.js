import { TextField } from "@material-ui/core";
import styled from 'styled-components';

const small = '45%';
const big = '100%';

export const CustomTextField = styled(TextField)`
  width: ${({size}) => size === 'small'? small : big };
`;
