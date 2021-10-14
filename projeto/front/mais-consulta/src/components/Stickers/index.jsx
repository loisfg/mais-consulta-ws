import React from 'react';
import { BoxSticker } from './styles';

export const  Stickers = ({specialty, hour}) => {
  return (
       <BoxSticker>
            {specialty}
            {hour}
       </BoxSticker>

  );
}

