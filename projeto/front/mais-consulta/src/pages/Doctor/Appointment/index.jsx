import React, { useEffect, useState } from 'react';
import { useForm, Controller } from 'react-hook-form';
import { useLocation, useHistory } from 'react-router-dom'
import Select from "react-select";
import UserPhoto from '../../../assets/next-user.svg';
import api from '../../../services/api';
import {  Checkbox, Modal, Container, TextSubtext, Header, FormSection, InputCheckable, DateInput, bloodData, SmallInput, PatientModal, mockData} from './appointmentImports';
import swal from 'sweetalert';
import { debounceEvent } from '../../../utils/debounce';

export const Appointment = ({name}) => {
  const [bloodType, setBloodType] = useState([]);
  const [showModal, setShowModal] = useState(false);
  const {control, reset, handleSubmit} = useForm();
  const [ patientData, setPatientData ] = useState({})
  const location = useLocation();
  const history = useHistory();
  const [ remediosControlados, setRemediosControlados ] = useState([]);
  const [ doencasCronicas, setDoencasCronicas ] = useState([]);
  const [ alergias, setAlergias ] = useState([]);
  const [ deficiencias, setDeficiencias ] = useState([]);
  const [ dsts, setDsts ] = useState([]);
  const getRemediosControlados = async (event) => {
    const nome = event.target.value;
    try {
      const res = await api('maisconsulta').get(`/infos/remedios/auto/${nome}`);
      const aux = res.data.map(option => 
        ({
          value: option.id,
          label: option.nome
        })
      )
      setRemediosControlados(aux)
    } catch (error) {
      console.log(error)
    }
  }
  const getDoencasCronicas = async (event) => {
    const nome = event.target.value;
    try {
      // const res = await api('maisconsulta').get(`/infos/doencasCronicas/auto/${nome}`);
      const res = {data:[{id: 1, nome:'Diabetes'}]}
      const aux = res.data.map(option => 
        ({
          value: option.id,
          label: option.nome
        })
      )
      setDoencasCronicas(aux)
    } catch (error) {
      console.log(error)
    }
  }
  const getAlergias = async (event) => {
    const nome = event.target.value;
    try {
      // const res = await api('maisconsulta').get(`/infos/alergias/auto/${nome}`);
      const res = {data:[{id: 1, nome:'Gatos'}]}
      const aux = res.data.map(option => 
        ({
          value: option.id,
          label: option.nome
        })
      )
      setAlergias(aux)
    } catch (error) {
      console.log(error)
    }
  }
  const getDeficiencias = async (event) => {
    const nome = event.target.value;
    try {
      // const res = await api('maisconsulta').get(`/infos/deficiencias/auto/${nome}`);
      const res = {data:[{id: 1, nome:'Auditiva'}]}
      const aux = res.data.map(option => 
        ({
          value: option.id,
          label: option.nome
        })
      )
      setDeficiencias(aux)
    } catch (error) {
      console.log(error)
    }
  }
  const getDsts = async (event) => {
    const nome = event.target.value;
    try {
      // const res = await api('maisconsulta').get(`/infos/dsts/auto/${nome}`);
      const res = {data:[{id: 1, nome:'Sifilis'}]}
      const aux = res.data.map(option => 
        ({
          value: option.id,
          label: option.nome
        })
      )
      setDsts(aux)
    } catch (error) {
      console.log(error)
    }
  }

  useEffect(() => {
    setBloodType(bloodData)
     const getPatientData = async () => {
      const pathnameArray = location.pathname.split('/');
      const idPaciente = pathnameArray[pathnameArray.length-1];
      try {
        const response = await api('maisconsulta').get(`/paciente/${idPaciente}`);
        setPatientData(response.data);
      } catch (error) {
        console.log(error)
      }
    }
    getPatientData()
  }, []);

  useEffect(() => {
    if(patientData) reset(patientData)
  }, [patientData])
  const handleOpen = () => setShowModal(true);
  const handleClose = () => setShowModal(false);
  const onSubmit = async (data) => {
    const idMedico = localStorage.getItem('id');
    try {
      // await api('maisconsulta').post(`/medico/${idMedico}/atendimento`, data)
      swal('Atendimento realizado','Atendimento realizado com sucesso', "success").then(() => history.push('/home-doctor'))
    } catch (error) {
      console.log(error)
    }
  }
  return(
    <Container onSubmit={handleSubmit(onSubmit)}>
      <Modal open={showModal} onClose={handleClose}>
        <PatientModal Controller={Controller} control={control} onClose={handleClose} />
      </Modal>
      <div className='left-side'>
        <div className='container-profile-pic'>
          <img src={UserPhoto} alt="user" />
          <TextSubtext textOne={patientData.dadosPessoais?.nome} textTwo='Paciente'/>
          <button type={"button"} onClick={handleOpen} className='btn-patient'>
            Exibir dados do paciente 
          </button>
        </div>
        <div className='line'></div>
      </div>
      <div className='right-side'>
        <Header data={patientData}/>
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
                <Controller name='prontuario.remediosControlados' onKeyUp={debounceEvent(getRemediosControlados)} options={remediosControlados} control={control} render={({field}) => <InputCheckable {...field} titleLabel='Remédios controlados'/> }/>
              </div>
            </div>
            <div className="row">
              <div className="field-group">
                <Controller name='prontuario.doencasCronicas' control={control} render={({field}) => <InputCheckable onKeyUp={debounceEvent(getDoencasCronicas)} options={doencasCronicas} {...field} titleLabel='Doenças crônicas'/>} />
              </div>
              <div className="field-group">
                <Controller name='prontuario.alergias' control={control} render={({field}) => <InputCheckable onKeyUp={debounceEvent(getAlergias)} options={alergias} {...field} titleLabel='Alergias'/> }/>
              </div>
            </div>
            <div className="row">
              <div className="field-group">
                <Controller name='prontuario.deficiencias' control={control} render={({field}) => <InputCheckable onKeyUp={debounceEvent(getDeficiencias)} options={deficiencias} {...field} titleLabel='Deficiências'/> }/>
              </div>
              <div className="field-group">
                <Controller name='prontuario.dsts' control={control} render={({field}) => <InputCheckable onKeyUp={debounceEvent(getDsts)} options={dsts} {...field} titleLabel='DST’s'/> }/>
              </div>
            </div>
            <div className="row">
              <div className="field-group">
                <Controller name='prontuario.fumante' control={control} render={({field}) => <Checkbox {...field} sx={{ '& .MuiSvgIcon-root': { fontSize: 25 }}}/>}/>
                <label id='fumante'>Fumante?</label>
                <Controller name='prontuario.virgem' control={control} render={({field}) => <Checkbox {...field} sx={{ '& .MuiSvgIcon-root': { fontSize: 25 }}}/>}/>
                <label id='virgem'>Virgem?</label>
              </div>
            </div>
          </div>
        </FormSection>
        <FormSection sectionTitle='Diagnóstico'>
          <div className='input-group'>
            <label>Queixas</label>
            <Controller name='diagnostico.queixa' control={control} render={({field}) => <input required {...field} type="text" /> }/>
            <label>Terminologia</label>
            <Controller name='diagnostico.terminologia' control={control} render={({field}) => <input required {...field} type="text" /> }/>
            <label>Medicamentos</label>
            <Controller name='diagnostico.medicamentos' control={control} render={({field}) => <input required {...field} type="text" /> }/>
            <label>Orientações médicas</label>
            <Controller name='diagnostico.orientacoesMedicas' control={control} render={({field}) => <textarea required {...field} cols="20" rows="5"/>}/>
          </div>
          <div className='btn-group'>
            <button id='btn_cancel' type={"button"}>Cancelar</button>
            <button id='btn_save' type='submit'>Salvar</button>
          </div>
        </FormSection>
      </div>
    </Container>
  ) ;
}