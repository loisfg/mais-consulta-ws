import React from 'react';
import { Container } from './styles';

export default function Title({description}) {
  return (
    <Container>
      <label>{description}</label>
      <hr />
    </Container>
  );
}