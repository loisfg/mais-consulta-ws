import styled from 'styled-components';

export const Container = styled.div`
  height: 100vh;
  width: 100%;
  display: flex;
  font-family: 'Rawline';
  .left_side{
    height: 100%;
    display: flex;
    width: 40%;
    padding: 0 0 0 23rem;
    .container_profile_pic{
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 50%;
        width: 100%;
        img{
            height: 10rem;
            width: 10rem;
            margin: 0 0 1rem 0;
        }
        .btn_patient{
            height: 3.5rem;
            width: 10rem;
            background-color: var(--light-blue);
            border: none;
            border-radius: 0.4rem;
            margin: 0.5rem 0 0 0;
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
  .right_side{
      height: 100%;
      width: 70%;
      display: flex;
      justify-content: center;
    }
`;
