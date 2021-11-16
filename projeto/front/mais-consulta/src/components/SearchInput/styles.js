import styled from 'styled-components';

export const Container = styled.div`
  height: 11vh;
  width: 30vw;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  margin: 0 0 0 3rem;
  label{
      font-family: 'Rawline';
      font-size: 1.2rem;
      font-weight: 500;
      margin: 1rem 0;
  }
  .search{
    height: 100%;
    width: 80%;
    padding: 0 0 0 0.5rem;
    border: var(--light-blue) 0.1rem solid;
    border-radius: 0.4rem;
  }
`;
