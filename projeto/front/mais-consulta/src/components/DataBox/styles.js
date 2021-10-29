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
    width: 60rem;
    background: pink;
    border-radius: 0.6rem;
    overflow-y: scroll;

`

export const Panel =  styled.div`
height: 90%;
width: 100%;
background-color: #19A795;
display: flex;
`

export const LeftSide = styled.div`
height: 100%;
width: 55%;
background-color: black;
`

export const RightSide = styled.div`
height: 100%;
width: 45%;
background-color: blue;
`

