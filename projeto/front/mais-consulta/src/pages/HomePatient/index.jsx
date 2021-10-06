import React from 'react';
import { Page } from "./styles"
import { DivUsuario } from "./styles"
import { Menu } from '../../components/Menu';
import { UserProfilePic, FullScreen } from '../../components/';

const HomePatient = () => {

    return (
        <Page>
            <DivUsuario >
                <UserProfilePic nome="Tha Calazans" subtexto=" Paciente" />
            </DivUsuario>
            <FullScreen>

            </FullScreen>
        </Page>
    )

}


export default HomePatient; 