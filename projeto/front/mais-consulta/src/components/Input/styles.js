import { TextField } from "@material-ui/core";
import styled from 'styled-components';

const standard = '100px';
const small = '200px';
const medium = '300px';
const big = '318px';

export const CustomTextField = styled(TextField)`
  margin: ${({size}) => size === 'small'? '5px 7px 10px 0 !important' : '0 7px 10px 0 !important'};
  width: ${({size}) => size === 'small'? small :
          size === 'medium'? medium :
          size === 'big'? big : standard};
`;
