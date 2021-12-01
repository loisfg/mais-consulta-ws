import React from 'react';
import { CustomAvatar, Container, H3, H4, AlignText, DivNotifications } from './styles';
import Notifications from '../../assets/notifications.svg';
export const UserProfilePic = () => {
    const nome = localStorage.getItem('nome');
    const role = localStorage.getItem('role');
    return (
        <Container>
            <AlignText>
                <H3>{nome}</H3>
                <H4> {role} </H4>
            </AlignText>
            <CustomAvatar sx={{ bgcolor: 'deepskyblue' }} />
        </Container>
    )
}