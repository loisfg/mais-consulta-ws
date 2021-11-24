import styled from 'styled-components';

export const Container = styled.form `
  height: 100vh;
  width: 100%;
  display: flex;
  font-family: 'Rawline';
  .left-side{
    height: 100%;
    display: flex;
    width: 60rem;
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
    width: 80%;
    display: flex;
    flex-direction: column;
    align-items: center;
    overflow-y: auto;
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
      justify-content: space-between;
      .field-group{
        width: 47%;
        display: flex;
        align-items: center;
        span{
          padding: 3px;
        }
        label{
          font-size: 1.4rem;
        }
        .field{
          display: flex;
          flex-direction: column;
          font-family: var(--rawline);
          font-weight: 500;
          font-size: 1.7rem;
          margin: 0 3rem 0 0;
        }
      }
      .select-group{
        display: flex;
        flex-direction: column;
        align-items: flex-start;
        justify-content: center;
        width: 50%;
        height: 7rem;
        > div{
          height: 50%;
          width: 60%;
          font-size: 1.3rem;
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
      height: 70%;
      width: 100%;
      label{
        font-size: 1.4rem;
        margin: 1rem 0;
      }
      input[type="text"]{
        border: var(--light-blue) solid 0.1rem;
        height: 15%;
        width: 100%;
        border-radius: 0.4rem;
      }
      #date-input{
        margin: 0;
        > label {
          margin: 0;
        }
      }
      textarea{
        border: var(--light-blue) solid 0.1rem;
        border-radius: 0.5rem;
        width: 100%;
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
      margin: 3rem 0 1rem 1rem;
      border: none;
    }
    #btn_save{
      background-color: var(--light-blue);
      border-radius: 0.4rem;
      color: white;
      cursor: pointer;
    }
    #btn_cancel{
      border-radius: 0.4rem;
      color: var(--grey);
      cursor: pointer;
    }
  }
`;