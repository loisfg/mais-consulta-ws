import React from 'react';
import { Container } from './styles';
import Search from '../../assets/search.svg'

export const SearchInput = ({title}) => {
  return (
      <Container>
          <label>{title}</label>
          <div className='search'>
              <img src={Search} alt="" />
          </div>
      </Container>
  );
}