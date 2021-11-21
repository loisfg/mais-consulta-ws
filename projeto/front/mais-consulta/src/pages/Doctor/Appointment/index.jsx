import React, { useEffect, useState } from 'react';
import { useForm, Controller } from 'react-hook-form';
import Select from "react-select";
import UserPhoto from '../../../assets/next-user.svg';
import {  Checkbox, Modal, Container, TextSubtext, Header, FormSection, InputCheckable, DateInput, defaultValues, bloodData, SmallInput, PatientModal} from './appointmentImports';

export const Appointment = ({name, date}) => {
  const [bloodType, setBloodType] = useState([]);
  const [showModal, setShowModal] = useState(false);
  const {control, handleSubmit} = useForm(defaultValues);

  useEffect(() => setBloodType(bloodData), []);

  const handleOpen = () => setShowModal(true);
  const handleClose = () => setShowModal(false);
  const onSubmit = data => console.log(data)
  return(
    <Container onSubmit={handleSubmit(onSubmit)}>
      <Modal open={showModal} onClose={handleClose}>
        <PatientModal Controller={Controller} control={control} onClose={handleClose} />
      </Modal>
      <div className='left-side'>
        <div className='container-profile-pic'>
          <img src={UserPhoto} alt="user" />
          <TextSubtext textOne={name} textTwo='Paciente'/>
          <button onClick={handleOpen} className='btn-patient'>
            Exibir dados do paciente 
          </button>
        </div>
        <div className='line'></div>
      </div>
      <div className='right-side'>
        <Header name= 'Catarina Ayla Castro'/>
        <FormSection sectionTitle='Último atendimento'>
          <div className='form-section-last-appointment'>
            <TextSubtext className='text-tab' textOne='Data' />
            <TextSubtext className='text-tab' textOne='Local' />
            <TextSubtext className='text-tab' textOne='Medico atendente' />
          </div>
        </FormSection>
        <FormSection sectionTitle='Prontuário'>
          <div className='form-section'>
            <div className="row">
              <div className="field-group">
                <div className='field'>
                  <label>Peso</label>
                  <Controller name='prontuario.peso' control={control} render={({field}) => <SmallInput {...field} measure='kg'/>}/>
                </div>
                <div className='field'>
                  <label>Altura</label>
                  <Controller name='prontuario.altura' control={control} render={({field}) => <SmallInput {...field} measure='cm'/>}/>
                </div>
              </div>
              <div className="field-group">
                <Controller name='prontuario.doencasCronicas' control={control} render={({field}) => <InputCheckable {...field} titleLabel='Doenças crônicas'/>} />
              </div>
            </div>
            <div className="row">
              <div className="field-group">
                <Controller name='prontuario.remediosControlados' control={control} render={({field}) => <InputCheckable {...field} titleLabel='Remédios controlados'/> }/>
              </div>
              <div className="field-group">
                <Controller name='prontuario.alergias' control={control} render={({field}) => <InputCheckable {...field} titleLabel='Alergias'/> }/>
              </div>
            </div>
            <div className="row">
              <div className="field-group">
                <Controller name='prontuario.dsts' control={control} render={({field}) => <InputCheckable {...field} titleLabel='DST’s'/> }/>
              </div>
              <div className="field-group">
                <Controller name='prontuario.deficiencias' control={control} render={({field}) => <InputCheckable {...field} titleLabel='Deficiências'/> }/>
              </div>
            </div>
            <div className="row">
              <div className="field-group">
                <Controller name='prontuario.isFumante' control={control} render={({field}) => <Checkbox {...field} sx={{ '& .MuiSvgIcon-root': { fontSize: 25 }}}/>}/>
                <label>Fumante?</label>
                <Controller name='prontuario.isVirgem' control={control} render={({field}) => <Checkbox {...field} sx={{ '& .MuiSvgIcon-root': { fontSize: 25 }}}/>}/>
                <label>Virgem?</label>
              </div>
              <div className="field-group">
                <Controller name='prontuario.doencasHereditarias' control={control} render={({field}) => <InputCheckable {...field} titleLabel='Doenças hereditárias'/> }/>
              </div>
            </div>
            <div className="row">
                <div className='select-group'>
                  <label>Tipo Sanguíneo</label>
                  <Controller name='prontuario.tipoSanguineo' control={control} render={({field}) => <Select {...field} options={bloodType}/>}/>
                </div>
                <div className="field-group">
                  <Controller name='prontuario.atividadesProibidas' control={control} render={({field}) => <InputCheckable {...field} titleLabel='Atividades proibidas'/> }/>
                </div>
            </div>
          </div>
        </FormSection>
        <FormSection sectionTitle='Diagnóstico'>
          <div className='input-group'>
            <label>Queixas</label>
            <Controller name='diagnostico.queixa' control={control} render={({field}) => <input {...field} type="text" /> }/>
            <label>Terminologia</label>
            <Controller name='diagnostico.terminologia' control={control} render={({field}) => <input {...field} type="text" /> }/>
            <label>Medicamentos</label>
            <Controller name='diagnostico.medicamentos' control={control} render={({field}) => <input {...field} type="text" /> }/>
            <label>Orientações médicas</label>
            <Controller name='diagnostico.orientacoesMedicas' control={control} render={({field}) => <textarea {...field} cols="20" rows="5"/>}/>
          </div>
          <Controller name='diagnostico.atestado' control={control} render={({field}) => <DateInput {...field} titleLabel="Atestado"/>}/>
          <div className='btn-group'>
            <button id='btn_cancel'>Cancelar</button>
            <button id='btn_save' type='submit'>Salvar</button>
          </div>
        </FormSection>
      </div>
    </Container>
  ) ;
}