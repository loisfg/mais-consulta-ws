import styled from "styled-components";
export const Horario = styled.div`
    width: 50rem;
    display: flex;
    flex-direction: column;
    align-items: center;
    p {
        color: var(--grey);
        font-weight: 600;
        margin-bottom: 10px;
        font-size: 16px;
    }
`
export const List= styled.div`
    width: 100%;
    display: flex;
    flex-wrap: wrap;
`
export const ItemListHour = styled.div`
    display: flex;
    justify-content: center;
    align-items: center;
    flex-wrap: wrap;
    width: 8vh;
    color: ${({isActive}) => isActive  ? "var(--white-standard)" : "#b4b4b4"};
    border-radius: 100px;
    margin: 0.5rem 0.8rem 0 0;
    padding: 0.8rem 0;
    font-size: 1.4rem;
    background-color:${({isActive}) => isActive  ? "var(--green-standard)" : "var(--white-standard)"};
    cursor: pointer;
    :hover{
        cursor: pointer;
        color: white;
        background-color: var(--green-standard);
        border-radius: 100px;
    }
    :active {
        background-color: var(--green-standard);
    }
`