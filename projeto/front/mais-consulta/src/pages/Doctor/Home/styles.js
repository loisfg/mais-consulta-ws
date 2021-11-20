import styled from 'styled-components';

export const Container = styled.div`
  width: 100%;
  display: flex;
  padding-left: 5rem;
  flex-direction: column;
  font-family: 'Rawline';
  .textfield {
    display: flex;
    flex-direction: column;
    h1{
      color: var(--grey);
      font-size: 3rem;
      font-weight: 600;
      margin: 0 0 0.7rem 0;
    }
    h3{
      color: var(--light-grey);
      font-weight: 400;
    }
  }
  .hours_line{    
    display: flex;
    margin: 3rem 0 0 0;
    .line{
      height: 100%;
      width: 0.2rem;
      border-radius: 1rem;
      background-color: #E9E5E5;
    }
    .hours{
      height: 100%;
      display: flex;
      flex-direction: column;
      justify-content: space-between;
      > label{
        color: var(--medium-grey);
        font-weight: 600;
      }
    }
    .patient-group{
      display: flex;
      flex-direction: column;
      font-size: 1.7rem;
      font-weight: 600;
    }
  }
`;
