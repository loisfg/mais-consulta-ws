import React from 'react';
import { Container } from './styles';
import PropTypes from 'prop-types';

export const Header = ({data}) => {
  return (
      <Container>
          <div>
            <p>{data.dadosPessoais?.nome}</p>
            <label>{data.dadosPessoais?.endereco}</label>
            <label>{data.dadosPessoais?.rg}</label>
          </div>
          <div>
            <label>{data.dadosPessoais?.idade + ' anos'}</label>
            <label>{data.dadosPessoais?.bairro}</label>
            <label>{data.dadosPessoais?.numeroSus}</label>
          </div>
      </Container>
  );
}
Header.propTypes = {
    data: {
      nome: PropTypes.string.isRequired,
      endereco: PropTypes.string.isRequired,
      rg: PropTypes.string.isRequired,
      idade: PropTypes.string.isRequired,
      bairro: PropTypes.string.isRequired,
      numeroSus: PropTypes.number.isRequired
    }
};