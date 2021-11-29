import styled from "styled-components";

export const Page = styled.div`
    height: 100vh;
    width: 100%;
    display: flex;
    padding: 0% 5% 4%;
    flex-direction: column;
    justify-content: space-between;
`
export const DivUsuario = styled.div`
    height: 11vh;
    width: 100%;
    background-color: #fff;
    justify-content: flex-end;
`
export const Content = styled.div`
    height: 100%;
    min-width: 90%;
    width: 100%;
    display: flex;
    align-items: center;
    justify-content: space-around;
`
export const BoxLeft = styled.div`
    height: 100%;
    width: 50%;
    display:flex;
    flex-direction: column;
    justify-content: space-between;
    align-items: flex-start;
    border-right: 2px solid #19A795;
`
export const BoxAux = styled.div`
    width: 85%;
    height: 75%;
`

export const BoxRight = styled.div`
    height: 100%;
    width: 50%;
    display:flex;
    flex-direction: column;
    justify-content: space-between;
    align-items: center;

    button{
    font-size: 16px;
    border-style: none;
    border-radius: 0.5rem;
    color: white;
    font-family: Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
    background-color: var(--green-standard);
    cursor: pointer;
    width: 130px;
    height: 50px;
    margin-top: 16px;
    }
`

export const Filter = styled.div`
height:2vh;
margin-bottom: 48px;
width:75%;
display: flex;
flex-direction: column;
`
export const P = styled.p`
color: #515151;
font-size: 18px;
width:auto;
font-weight: 600;
font-family: Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
`