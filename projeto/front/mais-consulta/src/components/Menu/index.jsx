import * as React from 'react';
import { Tab, DivMenu, DivTab, LinkDivTab } from './styles';
import Logo from '../../assets/logo.svg';
import Home from '../../assets/home-selected.png';
import User from '../../assets/user.png';
import History from '../../assets/historico.png';
import Unidades from '../../assets/unidades.png';
import Calendar from '../../assets/calendar.png';
import Logoff from '../../assets/sair.png';

export const Menu = () => {
 
  return(
    <DivMenu>
      <img src={Logo} alt="" />
      <DivTab>
        <LinkDivTab>
          <img src={Home} alt="" />
          <Tab>
            Home
          </Tab>  
        </LinkDivTab>

        <LinkDivTab>
        <img src={History} alt="" />
          <Tab>
            Histórico
          </Tab>  
        </LinkDivTab>

        <LinkDivTab>
        <img src={Calendar} alt="" />
          <Tab>
            Agendamento
          </Tab>  
        </LinkDivTab>

        <LinkDivTab>
        <img src={Unidades} alt="" />
          <Tab>
            Mapa de unidades
          </Tab>  
        </LinkDivTab>

        <LinkDivTab>
        <img src={User} alt="" />
          <Tab>
            Perfil
          </Tab>  
        </LinkDivTab>

        <LinkDivTab>
        <img src={Logoff} alt="" />
          <Tab>
            Sair
          </Tab>  
        </LinkDivTab>   

      </DivTab>
    </DivMenu>
  );
}