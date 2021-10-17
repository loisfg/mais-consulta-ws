import styled from 'styled-components';
import {ToggleButton, ToggleButtonGroup } from '@material-ui/core';

export const Container = styled.div`
 display: flex;
  height: 63vh;
  width: 60vw;
  border-radius: 6px;
  border: #12A583 1.5px solid;
  align-items: center;
  justify-content: space-evenly;
  flex-direction: column;
`

export const Text = styled.div`
width: 60%;
height: 10%;
display: flex;
flex-direction: column;
justify-content: space-evenly;
align-items: center;
font-size: 18px;
padding: 60px 0 0 0;
`

export const TextOne = styled.div`
`

export const TextTwo = styled.div`

`

export const CustomToggleGroup = styled(ToggleButtonGroup)`
`

export const CustomToggleButton = styled(ToggleButton)`
  border: transparent !important;
  font-family: Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif !important;
  font-weight: bold !important;
`