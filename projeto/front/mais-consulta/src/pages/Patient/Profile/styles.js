import styled from 'styled-components';
import { Avatar } from '@material-ui/core';

export const Container = styled.section`
  height: 100vh;
  width: 100%;
  display: flex;
  display: flex;
  justify-content: center;
  align-items: flex-start;
  .leftSide{
    width: 53rem;
    display: flex;
    flex-direction: column; 
    border-style: none;
    background: red;
    align-items: flex-start;
    label{
      font-size: 1.6rem;
      font-weight: bold;
      color: white;
    }
  }
  .customIframe {
     margin: 2rem 0px 0 0rem;
  }
  .patient_group{
    height: 80%;
    width: 30%;
    display: flex;
    align-items: center;
    justify-content: flex-start;
    margin: 5rem 0 0 0;
    flex-direction: column;
    border-right: var(--green-standard) 2px solid;
    h1{
      font-size: 1.6rem;
      font-weight: 600;
      color: var(--grey);
      margin: 0 0 0.8rem;
    }
    h2{
      color: var(--grey);
      font-weight: 500;
    }
  }

`;

export const CustomAvatar = styled(Avatar)`
  margin: 0 0 20px 0;
  width: 12rem !important;
  height: 12rem !important;
`

export const H2 = styled.div`
color: black;
opacity: 70%;
font-size: 16px;
font-weight: 600;
font-family: Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
`