import styled from 'styled-components';
import InputMask from 'react-input-mask'

export const CustomForm = styled.form`
  height: 20rem;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  font-size: 3rem;
`;

export const Div = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
  height: 8vh;
  width: 28vw;
  padding: 20px 0 0px 0;
  margin-top: 30px;
  > span {
    font-size: 1.2rem;
  }
`

export const CustomInputMask = styled(InputMask)`
border: none;
width: 350px;
border-bottom: 1px solid;
/* border-inline-color: black; */
opacity: 0.87;
`