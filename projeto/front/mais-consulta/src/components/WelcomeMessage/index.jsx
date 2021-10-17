import React from 'react';
import { Text, TextOne, TextTwo} from  './styles';

export const WelcomeMessage = () => {
    return(
        <Text>
            <TextOne>
                Bem-vindo!
            </TextOne>
            <TextTwo>
            Esses são seus agendamentos :)
            </TextTwo>
        </Text>
    );
}
