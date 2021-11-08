import React from 'react';
import { Container } from './styles';
import PropTypes from 'prop-types';

export const Header = ({name, address, rg, age, neighbor, susNumber}) => {
  return (
      <Container>
          <div>
            <p>{name}</p>
            <label>{address}</label>
            <label>{rg}</label>
          </div>
          <div>
            <label>{age}</label>
            <label>{neighbor}</label>
            <label>{susNumber}</label>
          </div>
      </Container>
  );
}
Header.propTypes = {
    children: PropTypes.node,
    name: PropTypes.string.isRequired,
    address: PropTypes.string.isRequired,
    rg: PropTypes.string.isRequired,
    age: PropTypes.string.isRequired,
    neighbor: PropTypes.string.isRequired,
    susNumber: PropTypes.number.isRequired
};