import styled from 'styled-components';

export const Container = styled.div`
  width: 100%;
  border-radius: 0.6rem;
  border: var(--green-standard) 0.15rem solid;
`;

export const Line = styled.div`
  height: 6rem;
  width: 100%;
  display: flex;
  background-color: var(--white-standard);
  border-bottom: var(--green-standard) 0.1rem solid;
  .date-appointment-group{
    width: 10rem;
    display: flex;
    flex-direction: column;
    justify-content: center;
    background: var(--light-green);
  }
  .appointment-group{
    width: 88%;
    display: flex;
    align-items: center;
    justify-content: center;
  }
`