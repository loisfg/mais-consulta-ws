import * as React from 'react';
import { Tab, Container, ListOfTabs, SpaceLogo } from './styles';
import Logo from '../../assets/logo.svg';
import MenuData from './MenuData'
import { Link } from 'react-router-dom'

export const Menu = () => {
  return(
    <Container>
      <SpaceLogo>
        <img src={Logo} alt="Logo +Consulta"/>
      </SpaceLogo>
      <ListOfTabs>
        {MenuData.map((item,index) =>
          <Tab key={index}>
            <Link to={item.path}>
              <img src={item.icon} alt="" />
              <span>
                {item.title}
              </span>
            </Link>
          </Tab>
        )}
      </ListOfTabs>
    </Container>
  );
}