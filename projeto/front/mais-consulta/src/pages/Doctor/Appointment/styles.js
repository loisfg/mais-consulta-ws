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
    .btn-patient{
      cursor: pointer;
    }
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
    overflow: scroll;
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
      .select-group{
        display: flex;
        flex-direction: column;
        align-items: flex-start;
        width: 25rem;
        height: 7rem;
        > div{
          height: 50%;
          width: 60%;
          font-size: 1.3rem;
          border: var(--light-blue) solid 0.1px;
        }
        label{
          font-size: 1.4rem;
          margin: 0 0 1rem 0;
        }
      }
    }
    .input-group{
      display: flex;
      flex-direction: column;
      align-items: flex-start;
      justify-content: space-between;
      width: 100%;
      label{
        font-size: 1.4rem;
        margin: 0.4rem 0;
      }
      input{
        border: var(--light-blue) solid 0.1rem;
        height: 100%;
        border-radius: 0.4rem;
        margin: 0 0 1rem 0;
      }
      textarea{
        border: var(--light-blue) solid 0.1rem;
        border-radius: 0.5rem;
        width: 100%;
      }
    }
  }
`;
