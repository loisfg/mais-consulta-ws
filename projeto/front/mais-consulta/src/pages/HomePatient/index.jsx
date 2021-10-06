import React from 'react';
import { Page } from "./styles"
import { DivUsuario } from "./styles"
<<<<<<< HEAD
import { UserProfilePic } from '../../components/UserProfilePic';
import { Menu } from '../../components/Menu';
=======
import { Menu } from '../../components/Menu';
import { UserProfilePic, FullScreen } from '../../components/';
>>>>>>> 33dbdfc14dec18c6a5539567a1d7c65bb83dfdc0

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