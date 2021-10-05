import React from 'react';
import { Page } from "./styles"
import { DivUsuario } from "./styles"
import UserProfilePic from '../../components/UserProfilePic';
import { Menu } from '../../components/Menu';

const HomePatient = () => {

    return (
        <>
            <Page>
                <DivUsuario >
                    <UserProfilePic />
                    <Menu />
                </DivUsuario>
            </Page>
        </>
    )

}


export default HomePatient; 