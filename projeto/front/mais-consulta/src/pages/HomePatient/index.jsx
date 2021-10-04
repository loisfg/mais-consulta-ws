import React from 'react';
import { Page } from "./styles"
import { DivUsuario } from "./styles"
import UserProfilePic from '../../components/UserProfilePic';

const HomePatient = () => {

    return (
        <>
            <Page>
                <DivUsuario >
                    <UserProfilePic />
                </DivUsuario>
            </Page>
        </>
    )

}


export default HomePatient; 