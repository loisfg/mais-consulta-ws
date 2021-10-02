import React from "react";
import { RightSide, LeftSide, Page, DivLogo, CustomToggleGroup,CustomToggleButton } from "./styles"
import Login from "../../components/FormLogin"
import Logo from '../../assets/logo.svg';

const Initial = (props) => {
  const theme = {main:"#12A583"}
  return (
    <Page>
      <LeftSide>
        <DivLogo>
          <img src={Logo} alt="Logo +Consulta" />
        </DivLogo>
        <CustomToggleGroup exclusive>
          <CustomToggleButton theme={theme}>Entrar</CustomToggleButton>
          <CustomToggleButton>Cadastrar</CustomToggleButton>
        </CustomToggleGroup>
        <Login/>
      </LeftSide>
      <RightSide/>
    </Page>
  );
};

export default Initial;
