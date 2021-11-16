import React, { Children } from 'react';
import { MenuDoctor } from '..';
import { Container } from './styles';

export const WrapperDoctor = () => {
  return (
    <Container>
        <MenuDoctor/>
        <section>
            {Children}
        </section>
    </Container>
  );
}