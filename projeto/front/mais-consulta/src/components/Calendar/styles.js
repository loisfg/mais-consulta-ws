import styled from "styled-components";

export const P = styled.p`
    color:#515151;
    font-weight: 600;
    margin-bottom: 10px;
    font-size: 16px;
`

export const Calendario = styled.div`
    width: 58vh;
    height: 42vh;
    background-color: #fefefe;
    border-radius: 6px;
    /* background-color: gainsboro; */
`
export const Month = styled.div`
    width: 100%;
    height: 18%;
    background-color: #19A795;
    display: flex;
    justify-content: space-around;
    align-items: center;
    padding: 0 2rem;
    text-align: center;

    i {
    font-size: 17px;
    cursor: pointer;
    font-family: Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
  }

    h1 {
        font-size: 16px;
        font-weight: 500;
        text-transform: capitalize;
        letter-spacing: 0.2rem;
        margin-bottom: 1rem;
        color:white;
        font-family: Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
    }

    p {
    font-size: 16px;
    color:white;
    font-family: Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
  }

    img {
        height:2vh;
        width:2vh;
        cursor: pointer;
    }
`

export const Dates = styled.div`
    font-family: Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
    display:flex;
    align-items: center;
    justify-content: center;
`

export const Weekdays = styled.div`
    width: 100%;
    height: 3rem;
    padding: 0 0.1rem;
    display: flex;
    align-items: center;
    flex-wrap:wrap;
`
export const ListItem = styled.div`
    font-size: 14px;
    font-weight: 400;
    letter-spacing: 0.1rem;
    width: calc(57vh / 7);
    display: flex;
    justify-content: center;
    align-items: center;
    font-family: Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
`
export const Days = styled.div`
    flex-wrap: wrap;
    padding: 0 0.rem;
    width: 100%;
    display: flex;
    font-family: Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
`
export const ListDays = styled.div`
    font-size: 14px;
    font-weight: 400;
    letter-spacing: 0.1rem;
    width: calc(57vh / 7);
    height: 3.3rem;
    display: flex;
    justify-content: center;
    align-items: center;
    cursor: pointer;
    color: ${({isToDay}) => isToDay ? "#fff" : "#515151"};
    border-radius: 100px;
    background-color: ${({isToDay}) => isToDay ? "#19A795" : "#fff"};
    opacity: ${({weight}) => weight === 'light' ? 0.5 : 1};

    &:hover:not(.today) {
    cursor: pointer;
    background-color: #19A795;
    border-radius: 100px;
    color: white;
    }

// import styled from "styled-components";

// export const Calendario = styled.div`
//     width: 45rem;
//     height: 38rem;
//     background-color: #fefefe;
//     box-shadow: 0 0.1rem 1rem rgba(0.1, 0.1, 0.1, 0.1);
//     border-radius: 6px;
// `
// export const Month = styled.div`
//     width: 100%;
//     height: 4vw;
//     background-color: #19A795;
//     display: flex;
//     justify-content: space-around;
//     align-items: center;
//     padding: 0 2rem;
//     text-align: center;

//     i {
//     font-size: 17px;
//     cursor: pointer;
//     font-family: Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
//   }

//     h1 {
//         font-size: 17px;
//         font-weight: 500;
//         text-transform: capitalize;
//         letter-spacing: 0.2rem;
//         margin-bottom: 1rem;
//         color:white;
//         font-family: Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
//     }

//     p {
//     font-size: 16px;
//     color:white;
//     font-family: Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
//   }
// `

// export const Dates = styled.div`

// `

// export const Weekdays = styled.div`
//     width: 100%;
//     height: 4.5rem;
//     padding: 0 0.3rem;
//     display: flex;
//     align-items: center;
// `

// export const ListItem = styled.div`
//     font-size: 1.5rem;
//     font-weight: 400;
//     letter-spacing: 0.1rem;
//     width: calc(44.2rem / 7);
//     display: flex;
//     justify-content: center;
//     align-items: center;
//     font-family: Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
// `

// export const Days = styled.div`
//     flex-wrap: wrap;
//     padding: 0 0.2rem;
//     width: 100%;
//     display: flex;
//     font-family: Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
// `
// export const ListDays = styled.div`
//     font-size: 1.5rem;
//     font-weight: 400;
//     letter-spacing: 0.1rem;
//     width: calc(44.2rem / 7);
//     height: 4.5rem;
//     display: flex;
//     justify-content: center;
//     align-items: center;
//     cursor: pointer;
//     color: #515151;
//     opacity: ${({weight}) => weight === 'light' ? 0.5 : 1};
//     &:hover:not(.today) {
//     cursor: pointer;
//     background: #19A795;
//     border-radius: 100px;
//     }
// `