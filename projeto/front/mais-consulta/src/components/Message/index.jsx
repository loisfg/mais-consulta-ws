import * as React from 'react';
import { BoxText, H1,H2 } from './styles';

export const Message = ({ textOne, textTwo }) => {
    return (
        <BoxText>
            <H1>{textOne}</H1>
            <H2>{textTwo}</H2>
        </BoxText>
    );
}