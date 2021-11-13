import styled from 'styled-components';
import Box from '@mui/material/Box';

export const Container = styled.div `
  height: 50vh;
  width: 50vw;
`;

export const CustomBox = styled(Box)`
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 70%;
  height: 90%;
  border: 0.2rem solid var(--light-blue);
  background-color: #fefefe;
  border-radius: 0.3rem;
  font-family: 'Rawline';
  font-size: 1.4rem;
  color: var(--grey);
  .title{
    display: flex;
    flex-direction: column;
    margin: 1rem 0 1rem 3rem;
    font-weight: 600;
  }
  .form-group{
    display: flex;
    align-items: center;
    justify-content: space-between;
    .left-side{
      display: flex;
      flex-direction: column;
      height: 50%;
      width: 100%;
      label{
        margin: 1rem 0 0 3rem;
        font-weight: 500;
      }
      input{
        margin: 0.5rem 0 0 3rem;
        padding: 0 0 0 0.5rem;
        height: 4rem;
        width: 25rem;
        border: var(--light-blue) 0.1rem solid;
        border-radius: 0.4rem;
      }
    }
    .right-side{
      height: 50%;
      width: 100%;
      display: flex;
      flex-direction: column;
      label{
        margin: 1rem 0 0 3rem;
        font-weight: 500;
      }
      input{
        margin: 0.5rem 0 0 3rem;
        padding: 0 0 0 0.5rem;
        height: 4rem;
        width: 25rem;
        border: var(--light-blue) 0.1rem solid;
        border-radius: 0.4rem;
      }
    }
  }
  .btn-group{
    height: 10%;
    width: 100%;
    display: flex;
    justify-content: flex-end;
    align-items: center;
    button{
      height: 3.4rem;
      width: 8rem;
      margin: 0 1rem 0 0;
    }
  }
`