import styled from "styled-components";

export const CustomForm = styled.form`
  height: 70vh;
  width: 35vw;
  display: flex;
  flex-direction: column;
  align-content: space-between;
  justify-content: center;
`;

export const InputFamily = styled.form`
  height: 68%;
  width: 100%;
  padding: 0 25px !important;
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
`

export const CustomStack = styled.div`
    display: flex;
    width: 100%;
    justify-content: ${({ isFirst }) => isFirst ? 'flex-end' : 'space-between'};
    padding: 0 18px 0 18px;
`