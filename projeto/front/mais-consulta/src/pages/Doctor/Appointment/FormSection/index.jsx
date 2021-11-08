import React from 'react';
import { Container } from './styles';
import Title from './Title';

export const FormSection = ({children, sectionTitle}) => {
  return (
      <Container>
          <Title description={sectionTitle}/>
          {children}
      </Container>
  );
}