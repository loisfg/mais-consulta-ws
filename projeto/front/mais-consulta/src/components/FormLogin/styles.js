import styled from 'styled-components';
import InputMask from 'react-input-mask'

export const CustomForm = styled.form`
  height: 20rem;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  font-size: 3rem;
  p{
    font-size: 1.3rem;
    font-weight: 500;
    color: red;
  }
`;

export const Div = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
  height: 8vh;
  width: 28vw;
  > span {
    font-size: 1.2rem;
  }
`

export const CustomInputMask = styled(InputMask)`
  border: none;
  width: 350px;
  border-bottom: 1px solid;
  opacity: 0.87;
`