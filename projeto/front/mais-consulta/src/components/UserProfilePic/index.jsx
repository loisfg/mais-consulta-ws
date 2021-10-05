import React from 'react';
import { CustomAvatar, Container, H3, H4, AlignText, DivNotifications } from './styles';
import Notifications from '../../assets/notifications.svg';
export const UserProfilePic = ({nome, subtexto}) => {
    return (
        <Container>
            <DivNotifications>
                <img src={Notifications} alt="Logo +Consulta" />
            </DivNotifications>
            <AlignText>
                <H3>{nome}</H3>
                <H4> {subtexto} </H4>
            </AlignText>
            <CustomAvatar sx={{ bgcolor: 'deepskyblue'}}/>
        </Container>
    )
}