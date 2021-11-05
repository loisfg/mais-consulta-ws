import React from 'react';
import { Container } from './styles';

export const Header = ({name,}) => {
  return (
      <Container>
          <div>
            <p>Thais Calazans de Sousa</p>
            <label>Rua Dona Maria de Camargo, 955</label>
            <label>39.582.856-9</label>
          </div>
          <div>
            <label>20 Anos</label>
            <label>Itaquera</label>
            <label>54654646456</label>
          </div>
      </Container>
  );
}