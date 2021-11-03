import React from 'react';
import { Container } from './styles';
import UserPatient from '../../assets/user-patient.svg'
import DayPatient from '../../assets/next-user.svg'

export function Patient({name,age, isNext = false}) {
  return (
      <Container isNext={isNext}>
        <div className='name_age'>
          <img src={isNext? UserPatient : DayPatient} alt="" />
          <label>{name}</label>
        </div>
        <label>{age}</label>
      </Container>
  );
}