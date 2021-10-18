import styled from 'styled-components';
import { Avatar } from '@material-ui/core';

export const Container = styled.section`
  height: 100vh;
  width: 100vw;
  display: flex;
`;
export const RightSide = styled.div`
    width: 81%;
    background: purple;
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
`

export const PatientGroup = styled.div`
  height: 20%;
  width: 20%;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
`

export const CustomAvatar = styled(Avatar)`
  margin: 0 0 20px 0;
  width: 150px !important;
  height: 150px !important;
`
