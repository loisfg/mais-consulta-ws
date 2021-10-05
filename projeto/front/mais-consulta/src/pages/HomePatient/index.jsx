import React from 'react';
import { Page } from "./styles"
import { DivUsuario } from "./styles"
import UserProfilePic from '../../components/UserProfilePic';
import { Menu } from '../../components/Menu';
import { UserProfilePic } from '../../components/';

const HomePatient = () => {

    return (
        <Page>
            <DivUsuario >
                <UserProfilePic nome="Tha Calazans" subtexto=" Paciente" />
            </DivUsuario>
        </Page>
    )

}


export default HomePatient; 