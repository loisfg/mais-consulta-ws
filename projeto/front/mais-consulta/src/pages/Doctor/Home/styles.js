import styled from 'styled-components';

export const Container = styled.div`
  height: 100vh;
  width: 100%;
  display: flex;
  font-family: 'Rawline';
.right_side{
  height: 100%;
  width: calc(100vw - 23rem);
  .textfield{
    width: 65%;
    padding: 10rem 0rem 0 10rem;
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
      /* padding: 0 2rem 0 5rem; */
      > label{
        color: var(--medium-grey);
        font-weight: 600;
      }
    }
    .patient-group{
      display: flex;
      flex-direction: column;
      /* margin: 1rem 0 1rem 0; */
      font-size: 1.7rem;
      /* padding: 0 0 0 2rem; */
      font-weight: 600;
    }
  }
}
  
`;
