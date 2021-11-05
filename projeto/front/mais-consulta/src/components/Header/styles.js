import styled from 'styled-components';

export const Container = styled.div`
  height: 9rem;
  width: 80%;
  display: flex;
  justify-content: space-between;
  align-items: center;
  max-width: 90rem;
  margin: 1.5rem 0 0 0;
  border-radius: 0.6rem;
  border: var(--light-blue) 0.2rem solid;
  p {
    font-family: 'Rawline';
    font-size: 1.5rem;
    font-weight: 500;
  }
  label{
    font-family: 'Rawline';
    font-size: 1.2rem;
    font-weight: 300;
  }
  div{
    height: 100%;
    display: flex;
    margin: 1rem 1rem;
    flex-direction: column;
    justify-content: space-evenly;
  }
`;
