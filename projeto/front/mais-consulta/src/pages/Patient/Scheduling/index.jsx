import React from 'react';
import { Page } from "./styles";
import { DivUsuario, AuxDiv, Content } from "./styles";
import { UserProfilePic, Schedule, WelcomeMessage, NextWeek, NoScheduling } from "../../../components"
import { Container } from '../../../components/NoScheduling/styles';

const username = localStorage.getItem("nome");
const typeOfUser = localStorage.getItem("role");
export const Scheduling = () => {
    return (
        <Page>
            <AuxDiv>
                <DivUsuario>
                    <UserProfilePic nome={username} subtexto={String(typeOfUser.toLocaleLowerCase())} />
                </DivUsuario>
                <Content>
                    <WelcomeMessage />
                    <NextWeek />
                   <NoScheduling>
                       <Container/>
                   </NoScheduling>
                </Content>
            </AuxDiv>
        </Page>
    );
};

