import React from 'react';
import { Container } from './styles';
import { MenuDoctor, TextSubtext, Header } from '../../../components';
import UserPhoto from '../../../assets/next-user.svg';
import { FormSection } from './FormSection';
import  SmallInput from './FormSection/SmallInput'

export const Appointment = ({name, date}) => {
  const data = {
    name: 'Catarina Ayla Castro',
    address: 'Quadra 912 Sul Alameda 3',
    rg: '37.620.064-9',
    age: '52 anos',
    neighbor: 'Plano Diretor Sul',
    susNumber: 5172784766154,
    date: '03/10/2021',
    ubs: 'UBS Vila Maria',
    doctor: 'Luis Fernando Rocha'
  }
  return(
    <Container>
      <MenuDoctor/>
      <div className='left-side'>
        <div className='container-profile-pic'>
          <img src={UserPhoto} alt="user" />
          <TextSubtext textOne={name} textTwo='Paciente'/>
          <button className='btn-patient'>Exibir dados do paciente </button>
        </div>
        <div className='line'></div>
      </div>
      <div className='right-side'>
        <Header 
        name= {data.name}
        address={data.address}
        rg={data.rg}
        age={data.age}
        neighbor={data.neighbor}
        susNumber= {data.susNumber}
        />
        <FormSection sectionTitle='Último atendimento'>
          <div className='form-section'>
            <TextSubtext className='text-tab' textOne='Data' textTwo={data.date}/>
            <TextSubtext className='text-tab' textOne='Local' textTwo={data.ubs}/>
            <TextSubtext className='text-tab' textOne='Medico atendente' textTwo={data.doctor}/>
          </div>
        </FormSection>
        <FormSection sectionTitle='Prontuário'>
          <div className='form-section'>
            <div className="row">
              <div className="field-group">
                <SmallInput title='Peso' measure='kg'/>
                <SmallInput title='Peso' measure='kg'/>
              </div>
            </div>
          </div>
        </FormSection>
        <FormSection sectionTitle='Diagnóstico'>
          <div className='form-section'>
            <TextSubtext className='text-tab' textOne='Data' textTwo={data.date}/>
            <TextSubtext className='text-tab' textOne='Local' textTwo={data.ubs}/>
            <TextSubtext className='text-tab' textOne='Medico atendente' textTwo={data.doctor}/>
          </div>
        </FormSection>
      </div>
    </Container>
  ) ;
}