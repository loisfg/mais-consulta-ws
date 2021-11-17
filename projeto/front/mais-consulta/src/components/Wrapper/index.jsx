import React from 'react';
import { Container } from './styles';
import { Menu } from '../'
import { MenuDoctor } from '../MenuDoctor';

export const Wrapper = ({children, role}) => {
    return (
        <Container>
            {role === 'MEDICO' && <MenuDoctor/>}
            {role === 'PACIENTE' && <Menu/>}
            <section>
                {children}
            </section>
        </Container>
    )
}
