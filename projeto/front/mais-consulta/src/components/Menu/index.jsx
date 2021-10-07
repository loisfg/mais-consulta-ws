import * as React from 'react';
import { Tab, DivMenu, DivTab } from './styles';
import Logo from '../../assets/logo.svg';
export const Menu = () => {
  return(
    <DivMenu>
      <img src={Logo} alt="" />
      <DivTab>
        <Tab>
          Home
        </Tab>
        <Tab>
          Histórico
        </Tab>
        <Tab>
          Agendamento
        </Tab>
        <Tab>
          Mapa de agendamento
        </Tab>
        <Tab>
          Perfil
        </Tab>
        <Tab>
          Sair
        </Tab>
      </DivTab>
    </DivMenu>
  );
}