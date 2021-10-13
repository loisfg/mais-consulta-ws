import styled from "styled-components";
import { Avatar } from "@material-ui/core";

export const CustomAvatar = styled(Avatar)`
    height: 600px;
`

export const Container = styled.div`
    height: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
    padding: 10px 0 0 115px;
    width: 62vh;
`
export const H3 = styled.h3`
    color: #366273;
    font-size: 16px;
    font-weight: bold;
    font-family: Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
`

export const H4 = styled.h4`
    color: #366273;
    font-size: 13px;
    font-family: Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
`

export const AlignText = styled.div`
    text-align: end;
    padding: 0 10px 0 0;
`

export const DivNotifications = styled.div`
  height: 10px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin-top: 0;
  padding-right: 12px;
  img{
      width: 70%;
  }
`