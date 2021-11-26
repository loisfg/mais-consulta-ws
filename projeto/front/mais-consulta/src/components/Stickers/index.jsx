import React from 'react';
import { BoxSticker } from './styles';

export const Stickers = ({ specialty, hour }) => 
     (
          <BoxSticker>
               <div>
                    {specialty}
               </div>
               <div>
                    {hour}
               </div>
          </BoxSticker>
     )
