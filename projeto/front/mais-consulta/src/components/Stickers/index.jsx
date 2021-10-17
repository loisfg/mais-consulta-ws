import React from 'react';
import { BoxSticker, RightSide, LeftSide } from './styles';

export const Stickers = ({ color, specialty, hour }) => {
     return (
          <BoxSticker>
               <RightSide>
                    {specialty}
               </RightSide>
               <LeftSide>
                    {hour}
               </LeftSide>
          </BoxSticker>

     );
}

