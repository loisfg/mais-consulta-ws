import React from 'react';
import Home from '../../assets/homesvg.svg';
import User from '../../assets/user.png';
import History from '../../assets/historico.png';
import Unidades from '../../assets/unidades.png';
import Calendar from '../../assets/calendar.png';

export default [
    {
        title: 'Home',
        path: '/home',
        icon: Home
    },
    {
        title: 'Historico',
        path: '/historico',
        icon: History
    },
    {
        title: 'Agendamento',
        path: '/agendamento',
        icon: Calendar
    },
    {
        title: 'Mapa de unidades',
        path: '/mapa-de-unidades',
        icon: Unidades
    },
    {
        title: 'Perfil',
        path: '/perfil',
        icon: User
    }
]