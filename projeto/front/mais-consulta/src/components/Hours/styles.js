import styled from "styled-components";
export const Horario = styled.div`
    height:20vh;
    width:58vh;
    p {
        color: var(--grey);
        font-weight: 600;
        margin-bottom: 10px;
        font-size: 16px;
    }
`
export const List= styled.div`
    margin-top:8px;
    height:80%;
    width:100%;
`
export const ItemListHour = styled.div`
    height: 4vh;
    float:left;
    width: 8vh;
    color: ${({isActive}) => isActive  ? "var(--white-standard)" : "#b4b4b4"};
    border-radius: 3px;
    margin-right:8px;
    margin-top: 5px;
    font-size: 14px;
    background-color:${({isActive}) => isActive  ? "var(--green-standard)" : "var(--white-standard)"};
    display: flex;
    justify-content: center;
    align-items: center;
    cursor: pointer;
    &:hover{
        cursor: pointer;
        color: white;
        background-color: var(--green-standard);
        border-radius: 100px;
    }
    &:active {
        background-color: var(--green-standard);
    }
`