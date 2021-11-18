import React from 'react';
import { Container } from './styles';
import { Menu } from '../'
import { MenuDoctor } from '../MenuDoctor';

export const Wrapper = ({children, role}) => {
    return (
        <Container>
            {role === 'Medico' && <MenuDoctor/>}
            {role === 'Paciente' && <Menu/>}
            <section>
                {children}
            </section>
        </Container>
    )
}
