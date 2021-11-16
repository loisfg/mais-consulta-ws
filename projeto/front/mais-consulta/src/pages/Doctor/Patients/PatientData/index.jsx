import React from 'react';
import { Container } from './styles';
import UserPhoto from '../../../../assets/next-user.svg'

export default function PatientData({name, age, lastAppointment}) {
  return (
        <Container>
            <div className='data_field'>
                <img src={UserPhoto} alt="" />
                <div>
                    <label id='name'>{name}</label>
                    <label id='age'>{age}</label>
                    <label id='lastAppointment'>último atendimento: {lastAppointment}</label>
                </div>
            </div>
        </Container>
    );
}