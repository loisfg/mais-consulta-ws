import React from 'react';
import { Container } from './styles';
import { MenuDoctor, TextSubtext, Header } from '../../../components'
import UserPhoto from '../../../assets/next-user.svg'

export const Appointment = () => {
  return(
    <Container>
      <MenuDoctor/>
      <div className='left_side'>
        <div className='container_profile_pic'>
          <img src={UserPhoto} alt="user" />
          <TextSubtext textOne='Alissa Edwards' textTwo='Paciente'/>
          <button className='btn_patient'>Exibir dados do paciente </button>
        </div>
        <div className='line'></div>
      </div>
      <div className='right_side'>
        <Header/>
      </div>
    </Container>
  ) ;
}