import React, { useEffect, useState } from 'react';
import { Container } from './styles';
import { UserProfilePic, SearchInput } from '../../../components'
import PatientData from './PatientData'
import { data as oldData } from './data.js'
import api from "../../../services/api";
export const Patients = () => {
    const [data, setData] = useState([]);
    useEffect(() => {
        const getData = async () => {
            try {
                const idMedico = localStorage.getItem('id')
                const response = await api('maisconsulta').get(`/medico/${idMedico}/historico`);
                setData(response.data);
                // setData(oldData);
            } catch (error) {
                console.error(error);
            }
        }
        getData();
    }, [])
    return (
        <Container>
            <div className='container_profile_pic'>
                <UserProfilePic/>
            </div>
            <div className='form_group'>
                <div className='textfield'>
                    <h1>Histórico de pacientes</h1>
                </div>
                {/* <SearchInput title='Buscar paciente'/> */}
            </div>
            <div className='patient_group'>
                {
                    data.map((patient) =>{
                        return( 
                                <PatientData name={patient.nome} 
                                             age={patient.idade} 
                                             lastAppointment={patient.ultimoAtendimento}
                                             onClick={() => console.log('Teste')}
                                />
                            )
                        })
                    }
            </div>
        </Container>
    );
}