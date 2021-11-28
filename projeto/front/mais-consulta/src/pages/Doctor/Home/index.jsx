import React, { useEffect, useState } from 'react';
import './styles';
import { UserProfilePic, Patient } from '../../../components'
import { Container } from './styles'
import { PatientData as oldData } from './PatientData'
import api from '../../../services/api'
import { Link, useLocation } from 'react-router-dom';

export const Home = () => {
    const [ username, setUsername ] = useState('');
    const [ moment, setMoment ] = useState(null);
    const [data, setData] = useState([]);
    useEffect(() => {
        const dateNow = new Date();
        const doctorId = localStorage.getItem("id"); 
        setUsername(localStorage.getItem("nome"));
        setMoment(dateNow.toDateString());
        const getData = async () => {
            try {
                const response = await api('maisconsulta').get(`/medico/${doctorId}/agendamentos`);
                setData(response.data);
                // setData(oldData);
            } catch (error) {
                console.error(error);
            }
        }
        getData();
    }, []);
    
return (
        <Container>
            <UserProfilePic/>
            <div className='textfield'>
                <h1>Boa noite Dr {username}!</h1>
                <h3>{moment}</h3>
            </div>
            {
                data.length ? ( 
                <div className='hours_line'>
                <div className='line'></div>
                <div className='patient-group'>
                    <label>Próximo paciente</label>
                    
                    <div className='schedule_group'>
                    <label>{data[0].scheduleTime}</label>
                    <Link to={`/appointment/${data[0].id}`}>
                        <Patient isNext={true} name={data[0].name} age={data[0].age}/>
                    </Link>
                    </div>
                    <label>Pacientes do dia</label>
                    {
                        data.map((patient, index) => {
                            if(index > 0) {
                                return(
                                    <div className='schedule_group'>
                                        <label>{patient.scheduleTime}</label>
                                        <Patient isNext={false} name={patient.name} age={patient.age}/>
                                    </div>
                                ) 
                            }
                        })
                    }
                </div>
            </div>) : (<label style={{fontSize: '3rem', margin: '3rem 0rem'}}>Você não possui agendamentos no momento :)</label>)
            }
        </Container>
    )
};
