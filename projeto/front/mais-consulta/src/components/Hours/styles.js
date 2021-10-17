import styled from "styled-components";

export const Horario = styled.div`
    height:20vh;
    width:58vh;

    p {
        color:#515151;
        font-weight: 600;
        margin-bottom: 10px;
        font-size: 16px;
    }
`
export const List= styled.div`
    height:90%;
    width:100%;
`
export const ItemListHour = styled.div`
    height: 4vh;
    float:left;
    width: 8vh;
    color: ${({color}) => color == 'select' ? "#fff" : "#b4b4b4"};
    border-radius: 3px;
    margin-right:8px;
    margin-top: 5px;
    background-color: ${({color}) => color == 'select' ? "#19A795" : "#fff"};
    font-size: 16px;
    display: flex;
    justify-content: center;
    align-items: center;
    cursor: pointer;

    &:hover{
    cursor: pointer;
    color: white;
    background-color: #19A795;
    border-radius: 100px;
    }
`