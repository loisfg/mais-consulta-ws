import styled from "styled-components";

export const P = styled.p`
    color: var(--grey);
    font-weight: 600;
    margin-bottom: 10px;
    font-size: 1.6rem;
`

export const Calendario = styled.div`
    width: 51rem;
    background-color: var(--white-standard);
    border-radius: 0.6rem;
`
export const Month = styled.div`
    height: 18%;
    background-color: var(--green-standard);
    display: flex;
    justify-content: space-around;
    align-items: center;
    padding: 0 2rem;
    text-align: center;
    i {
        font-size: 1.7rem;
        cursor: pointer;
    }

    h1 {
        font-weight: 500;
        text-transform: capitalize;
        letter-spacing: 0.2rem;
        color:white;
    }

    p {
        font-size: 16px;
        color:white;
    }

    img {
        height:2vh;
        width:2vh;
        cursor: pointer;
    }
`

export const Dates = styled.div`
    h1{
        font-size: 18px;
    }
`

export const Weekdays = styled.div`
    width: 100%;
    padding: 1rem 0;
    display: flex;
    align-items: center;
    justify-content: space-between;
    flex-wrap:wrap;
`
export const ListItem = styled.div`
    font-size: 14px;
    font-weight: 400;
    letter-spacing: 0.1rem;
    width: 7rem;
    display: flex;
    justify-content: center;
    align-items: center;
`
export const Days = styled.div`
    flex-wrap: wrap;
    width: 100%;
    display: flex;
    justify-content: space-between;
`
export const ListDays = styled.div`
    font-size: 14px;
    font-weight: 400;
    letter-spacing: 0.1rem;
    width: 7rem;
    display: flex;
    justify-content: center;
    align-items: center;
    cursor: pointer;
    color: ${({isToDay}) => isToDay ? "#fff" : "#515151"};
    opacity: ${({weight}) => weight === 'light' ? 0.5 : 1};
    span{
        height: 4rem;
        width: 4rem;
        display: flex;
        align-items: center;
        justify-content: center;
        background-color: ${({isToDay}) => isToDay ? "#19A795" : "#fff"};
        border-radius: 100px;
        :hover {
            cursor: pointer;
            background-color: #19A795;
            color: white;
        }
    }
`
