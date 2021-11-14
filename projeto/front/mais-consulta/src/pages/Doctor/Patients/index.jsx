import React from 'react';
import { Container } from './styles';
import { MenuDoctor, UserProfilePic, SearchInput } from '../../../components'
import PatientData from './PatientData'
import { data } from './data.js'
export const Patients = () => {
    return (
        <Container>
            <MenuDoctor/>
            <div className='container_profile_pic'>
                <UserProfilePic nome= "Gregory House" subtexto='Médico'/>
            </div>
            <div className='form_group'>
                <div className='textfield'>
                    <h1>Histórico de pacientes</h1>
                </div>
                <SearchInput title='Buscar paciente'/>
            </div>
            <div className='patient_group'>
                {
                    data.map((patient, index) =>{
                        return( 
                                <PatientData name={patient.name} 
                                             age={patient.age} 
                                             lastAppointment={patient.lastAppointment}
                                />
                            )
                        })
                    }
            </div>
        </Container>
    );
}