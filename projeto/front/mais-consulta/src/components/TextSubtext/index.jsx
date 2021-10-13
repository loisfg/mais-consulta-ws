import React from 'react';
import { BoxText, Text, SubText } from './styles';

export const TextSubtext = ({ textOne, textTwo }) => {
    return (
        <BoxText>
            <Text>{textOne}</Text>
            <SubText>{textTwo}</SubText>
        </BoxText>
    );
}