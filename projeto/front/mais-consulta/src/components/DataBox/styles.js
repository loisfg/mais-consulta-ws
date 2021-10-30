import styled from 'styled-components';
import { InputData } from '@material-ui/core';

export const Container = styled.section`
    height: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
    margin: 0px 3rem;
`;

export const Box = styled.div`
    height: 50rem;
    width: 73rem;
    border-radius: 0.6rem;
    overflow-y: scroll;
    padding: 10px 0 0 13px;

`

export const Panel = styled.div`
height: 100%;
width: 90%;
display: flex;
border: 1.5px solid #19A795;
border-radius: 5px;

`

export const LeftSide = styled.div`
height: 100%;
width: 50%;
 /* background-color: yellow;  */
 display: flex;
 justify-content: space-around;
 flex-direction: column;
 align-items: flex-start;
 padding: 10px 0 0 13px;
`

export const RightSide = styled.div`
height: 100%;
width: 50%;
/* background-color: blue; */
display: flex;
justify-content: space-around;
flex-direction: column;
 align-items: flex-start;
 padding: 10px 0 0 13px;
`
export const H2 = styled.div`
color: black;
opacity: 70%;
font-size: 12px;
font-weight: 600;
font-family: Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;

`
export const PanelTwo = styled.div`
height: 100%;
width: 90%;
display: flex;
border: 1.5px solid #19A795;
border-radius: 5px;


`
export const H3 = styled.div`
color: black;
opacity: 70%;
font-size: 16px;
font-weight: 600;
font-family: Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
padding: 23px 0 0 0 ;

`