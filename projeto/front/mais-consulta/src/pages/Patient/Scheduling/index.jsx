import React from 'react';
import { Page } from "./styles";
import { DivUsuario, AuxDiv, Content } from "./styles";
import { UserProfilePic, Schedule, WelcomeMessage, NextWeek, NoScheduling } from "../../../components"
import { Container } from '../../../components/NoScheduling/styles';

const username = localStorage.getItem("nome")
export const Scheduling = () => {
    return (
        <Page>
            <AuxDiv>
                <DivUsuario>
                    <UserProfilePic nome={username} subtexto=" Paciente" />
                </DivUsuario>
                <Content>
                    <WelcomeMessage />
                    <NextWeek />
                   <NoScheduling>
                       <Container>
                           
                       </Container>
                   </NoScheduling>
                </Content>
            </AuxDiv>
        </Page>
    );
};

