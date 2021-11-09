import styled from 'styled-components';

export const Container = styled.div`
  height: 100vh;
  width: 100%;
  display: flex;
  font-family: 'Rawline';
  .left-side{
    height: 100%;
    display: flex;
    width: 60rem;
    padding: 0 0 0 23rem;
    .container-profile-pic{
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 40rem;
        width: 100%;
        img{
            height: 10rem;
            width: 10rem;
            margin: 0 0 1rem 0;
        }
        .btn-patient{
          height: 3.5rem;
          width: 10rem;
          background-color: var(--light-blue);
          border: none;
          border-radius: 0.4rem;
          margin: 1.5rem 0 0 0;
          font-size: 1rem;
          color: var(--white-standard);
          font-family: 'Rawline';
          font-weight: 500;
        }
    }
    .line{
        height: 100%;
        width: 0.4rem;
        background-color: var(--light-blue);
    }
  }
  .right-side{
    height: 100%;
    width: 70%;
    display: flex;
    flex-direction: column;
    align-items: center;
    .form-section{
      margin: 1.5rem 0;
      display: flex;
      flex-direction: column;
      align-items: center;
      justify-content: space-between;
    }
    .form-section-last-appointment{
      margin: 1.5rem 0;
      display: flex;
      align-items: center;
      justify-content: space-between;
    }
    .row{
      display: flex;
      width: 100%;
      .field-group{
        width: 50%;
        display: flex;
        align-items: center;
        label{
          font-size: 1.4rem;
        }
      }
    }
  }
`;
