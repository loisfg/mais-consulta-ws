import React from 'react';
import { CustomIconButton, CustomStack, } from './styles'
import ArrowRight from '../../assets/arrow_right.svg'

export const IconButton = () => {
  return (
    <CustomStack>
      <CustomIconButton>
        <img src={ArrowRight} alt="" />
      </CustomIconButton>
    </CustomStack>
  );
}