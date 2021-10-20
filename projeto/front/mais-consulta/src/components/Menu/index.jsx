import React from 'react';
import { Tab, Container, ListOfTabs, SpaceLogo, Text, Redirect } from './styles';
import Logo from '../../assets/logo.svg';
import Logoff from '../../assets/sair.png';
import MenuData from './MenuData'
import { useLocation } from 'react-router-dom'
import { logout } from '../../services/auth'

export const Menu = () => {
  const location = useLocation()

  return(
    <Container>
      <SpaceLogo>
        <img src={Logo} alt="Logo +Consulta"/>
      </SpaceLogo>
      <ListOfTabs>
        {MenuData.map((item,index) =>
          <Tab key={index}>
            <Redirect to={item.path} isActive={location.pathname === item.path}> 
              <img fill="blue" src={item.icon} isActive={location.pathname === item.path} alt="" />
              <Text isActive={location.pathname === item.path}>
                {item.title}
              </Text>
            </Redirect>
          </Tab>
        )}
        <Tab key={'sair'}>
          <a href={'/'} onClick={logout}>
            <img src={Logoff} alt="" />
            <Text isActive = {false}>
              Sair
            </Text>
          </a>
        </Tab>
      </ListOfTabs>
    </Container>
  );
}