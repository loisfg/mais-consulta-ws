import React from 'react';
import { CustomTypography, CustomPagination, Aclopar } from './styles';

export const Pagination = ({week}) => {
  return (
    <>
      <Aclopar>
      <CustomTypography>
        {week}
      </CustomTypography>
      <CustomPagination/>
      </Aclopar>
      
      
    </>
  )
}