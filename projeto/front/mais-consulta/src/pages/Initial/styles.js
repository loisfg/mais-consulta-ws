import styled from "styled-components";
import photo from "../../assets/initialPhoto.jpg";
import { ToggleButton, ToggleButtonGroup, Tabs, Tab, Box, Typography } from "@material-ui/core";

export const Page = styled.section`
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  width: 100vw;
`;

export const DivPages = styled.div`

`
export const RightSide = styled.div`
  height: 100%;
  width: 50%;
  opacity: 87%;
  background: url(${photo}) center no-repeat;
  background-size: cover;
`;

export const LeftSide = styled.div`
  height: 100%;
  width: 50%;
  background-size: cover;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
`;

export const DivLogo = styled.div`
  height: 100px;
  width: 150px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin-top: 40px;
  img{
      width: 100%;
  }
`
export const CustomToggleGroup = styled(ToggleButtonGroup)`
  /* color: white; */
`

export const CustomToggleButton = styled(ToggleButton)`
  border: transparent !important;
  font-family: Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif !important;
  font-weight: bold !important;
`

export const CustomTabs = styled(Tabs)``

export const CustomTab = styled(Tab)`
  
`

export const CustomBox = styled(Box)`  
  
`

export const CustomTypography = styled(Typography)`
`
