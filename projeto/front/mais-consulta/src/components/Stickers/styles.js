import styled from 'styled-components';

export const BoxSticker = styled.div`
    width: 30%;
    height: 50%;
    background-color: ${({color}) => color === 'green'? 'var(--light-green)' : 
    color === 'purple'? 'var(--light-purple)' :
    color === 'blue'? 'var(--light-purple)' : 'var(--light-green)'};
    align-items: center;
    display: flex;
    justify-content: space-between;
    border-radius: 3px;
    border-left: 10px solid var(--green-standard);
    color: black;
    font-weight: bold;
    font-size: 13px;
`

export const  RightSide = styled.div`
    height: 100%;
    width: 11rem;
    display: flex;
    justify-content: center;
    align-items: center;
`

export const  LeftSide = styled.div`
    height: 100%;
    width: 11rem;
    display: flex;
    justify-content: center;
    align-items: center;
`
