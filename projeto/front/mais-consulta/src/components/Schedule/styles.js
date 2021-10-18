import styled from 'styled-components';

export const Container = styled.div`
  display: flex;
  height: 65vh;
  width: 60vw;
  border-radius: 6px;
  border: var(--green-standard) 1.5px solid;
`;

export const  LeftSide = styled.div `
height: 100%;
width: 10%;
display: flex;
flex-direction: column;
justify-content: center;
border-radius: 6px;
background-color: #C0E2DE;
`

export const  RightSide = styled.div `
height: 100%;
width: 90%;
display: flex;
flex-direction: column;
`

export const Line = styled.div`
height: 20%;
width: 100%;
display: flex;
align-items: center;
justify-content: space-between;
padding: 0 0 0 20px;
background-color: var(--white-standard);
opacity: 60%;
border-bottom: var(--green-standard) 1.5px solid;
border-radius: 6px;
display: flex;
justify-content: space-around;
`