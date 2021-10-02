import styled from 'styled-components';
import { TextField } from '@material-ui/core';


export const Container = styled.div`
  height: 40rem;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: flex-start;
  margin-top: 40px;
  justify-content: center;
  img{
      width: 30%;
  }
`;

export const CustomTextField = styled(TextField)`
  margin-top: 10px !important
`