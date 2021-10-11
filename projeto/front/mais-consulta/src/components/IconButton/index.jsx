import React from 'react';
import { CustomIconButton } from './styles'

export const IconButton = ({onClick, Arrow}) => {
  return (
      <CustomIconButton onClick= {onClick}>
        <img src={Arrow} alt="" />
      </CustomIconButton>
  );
}