import React from 'react';
import './styles';
import { UserProfilePic, Patient } from '../../../components'
import { Container } from './styles'
import { PatientData } from './PatientData'
import { Link, useLocation } from 'react-router-dom';

export const Home = () => {
const location = useLocation()
return (
        <Container>
            <div className='right_side'>
                <div className='textfield'>
                    <h1>Boa noite Dr House!</h1>
                    <h3>01 Nov 01:31</h3>
                </div>
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
                    <div className='patient-group'>
                        <label>Próximo paciente</label>
                        <Link to={'/appointment'}>
                            <Patient isNext={true} name={PatientData[0].name} age={PatientData[0].age}/>
                        </Link>
                        <label>Pacientes do dia</label>
                        {
                            PatientData.map((patient, index) =>{
                                if(index > 0){
                                    return <Patient isNext={false} name={patient.name} age={patient.age}></Patient>
                                }
                            })
                        }
                    </div>
                </div>
            </div>
            <div className='container_profile_pic'>
                <UserProfilePic nome= "Gregory House" subtexto='Médico'/>
            </div>
        </Container>
    )
};
