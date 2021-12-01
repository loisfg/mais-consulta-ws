import styled from 'styled-components';

export const Container = styled.div`
  cursor: pointer;
  height: 20vh;
  width: 20%;
  margin: 0 2rem 1rem 3rem;
  font-family: 'Rawline';
  img{
    height: 40%;
  }
  .data_field{
    height: 100%;
    width: 100%;
    display: flex;
    align-items: center;
    padding: 0 0 0 2rem;
    border: var(--light-blue) 0.1rem solid;
    border-radius: 0.4rem;
    > div{
      display: flex;
      flex-direction: column;
      margin: 0 0 0 3rem;
      label{
        margin: 0.3rem 0;
      }
      #name{
        font-size: 1.6rem;
        font-weight: 600;
      }
      #age{
        font-size: 1.4rem;
        font-weight: 500;
      }
      #lastAppointment{
        font-size: 1rem;
        font-weight: 500; 
      }
    }
  }
`;