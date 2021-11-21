import React from "react";
import ReactDOM from "react-dom";
import {
  Tab,
  Container,
  ListOfTabs,
  SpaceLogo,
  Text,
  Redirect,
} from "./styles";
import Logo from "../../assets/logo.svg";
import Logoff from "../../assets/sair.png";
import MenuData from "./MenuData";
import { useLocation } from "react-router-dom";
import { logout } from "../../services/auth";
import Icon from "./Icon";
import "./styles";

import iconSet from "./selection.json";
import { iconList } from "icomoon-react";

export const Menu = () => {
  const location = useLocation();
  console.log(iconList(iconSet));
  return (
    <Container>
      <SpaceLogo>
        <img src={Logo} alt="Logo + Consulta" />
      </SpaceLogo>
      <ListOfTabs>
        {MenuData.map((item, index) => (
          <Tab key={index}>
            <Redirect to={item.path} isActive={location.pathname === item.path}>
              <Icon
                color={location.pathname === item.path ? "#19A795" : "#515151"}
                size="3rem"
                icon={item.icon}
              />
              <Text isActive={location.pathname === item.path}>
                {item.title}
              </Text>
            </Redirect>
          </Tab>
        ))}
        <Tab key={"sair"}>
          <a href={"/"} onClick={logout}>
            <img src={Logoff} alt="" />
            <Text isActive={false}>Sair</Text>
          </a>
        </Tab>
      </ListOfTabs>
    </Container>
  );
};
