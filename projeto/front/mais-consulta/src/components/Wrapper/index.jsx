import React from 'react';

import { Container } from './styles';
import { Menu } from '../'

export const Wrapper = ({children}) => {
    return (
        <Container>
            <Menu/>
            <section>
                {children}
            </section>
        </Container>
    )
}
