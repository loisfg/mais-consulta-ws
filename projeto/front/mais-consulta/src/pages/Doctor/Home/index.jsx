import React from 'react';
import './styles';
import { UserProfilePic, MenuDoctor } from '../../../components'
import { Container } from './styles'

export const Home = () => (
    <Container>
        <MenuDoctor/>
        <div className='right_side'>
            <div className='textfield'>
                <h1>Boa noite Dr House!</h1>
                <h3>01 Nov 01:31</h3>
            </div>
            <label>Próximo paciente</label>
            <div className='hours_line'>
                <div className='hours'>
                    <label>09:30h</label>
                    <label>10:30h</label>
                    <label>11:30h</label>
                    <label>12:30h</label>
                    <label>13:30h</label>
                    <label>14:30h</label>
                </div>
                <div className='line'></div>
            </div>
        </div>
        <div className='container_profile_pic'>
            <UserProfilePic nome= "Gregory House" subtexto='Médico'/>
        </div>
    </Container>
);