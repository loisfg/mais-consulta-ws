import React from 'react';
import { CustomIconButton } from './styles'
import LeftArrow from '../../assets/left_arrow.svg';

export const IconButton = ({ onClick, Arrow = LeftArrow }) => {
  return (
    <CustomIconButton onClick={onClick}>
      <img src={Arrow} alt="" />
    </CustomIconButton>
  );
}