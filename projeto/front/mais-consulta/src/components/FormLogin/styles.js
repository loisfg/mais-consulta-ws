import styled from 'styled-components';
import {TextField} from '@material-ui/core';

export const Container = styled.div `
  height: 20rem;
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 0  0 40px 0;
  justify-content: center;
`;

export const CustomTextField = styled(TextField)
`
  margin-top: 30px !important;
  width: 300px;
`

export const Button = styled.button `
  height: 32px;
  width: 95px;
  font-size: 12px;
  border-style: none;
  border-radius: 5px;
  color: white;
  font-family: Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
  background-color: #12A583;
  cursor: pointer;
`

export const Div = styled.div `
  display: flex;
  align-items: center;
  justify-content: space-between;
  height: 8vh;
  width: 28vw;
  margin-top: 10px;
`