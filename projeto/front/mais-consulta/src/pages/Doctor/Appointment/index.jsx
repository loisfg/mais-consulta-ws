import React, { useEffect } from 'react';
import { Container } from './styles';
import { MenuDoctor, TextSubtext, Header } from '../../../components';
import UserPhoto from '../../../assets/next-user.svg';
import { FormSection } from './FormSection';
import SmallInput from './FormSection/SmallInput';
import { InputCheckable } from './FormSection/InputCheckable';
import { DateInput } from './FormSection/DateInput'
import PatientModal from './FormSection/PatientModal'
import { Checkbox, Select, MenuItem, Modal } from '@material-ui/core';

export const Appointment = ({name, date}) => {
  const [bloodType, setBloodType] = React.useState([]);
  const [showModal, setShowModal] = React.useState(false);
  const handleOpen = () => setShowModal(true);
  const handleClose = () => setShowModal(false);
  useEffect(() =>
    setBloodType(['A+', 'A-', 'B+','B-','AB+', 'AB-','O+', 'O']), 
  []);
  const handleChange = (event) => {
    setBloodType(event.target.value);
  };
  const data = [{
    name: 'Catarina',
    lastName: 'Ayla Castro',
    cpf: '494.444.333-08',
    susNumber: 5172784766154,
    age: '52 anos',
    address: 'Quadra 912 Sul Alameda 3',
    rg: '37.620.064-9',
    neighbor: 'Plano Diretor Sul',
    telephone:'(11) 2053-6573',
    city: 'São Paulo',
    state: 'São Paulo',
    cellphone:'(11) 93229-4055',
    cep: '08215-880'
  },
  {
    date: '03/10/2021',
    ubs: 'UBS Vila Maria',
    doctor: 'Luis Fernando Rocha'
  }]
  return(
    <Container>
      <MenuDoctor/>
      <Modal
        open={showModal}
        onClose={handleClose}
      >
        <PatientModal title='Dados Cadastrais' 
        name={data[0].name}
        cpf={data[0].cpf}
        susNumber={data[0].susNumber}
        cellphone={data[0].cellphone}
        cep={data[0].cep}
        street={data[0].address}
        lastName={data[0].lastName}
        rg={data[0].rg}
        telephone={data[0].telephone}
        city={data[0].city}
        state={data[0].state}
        neighbor={data[0].neighbor}
        onClose={handleClose}
        />
      </Modal>
      <div className='left-side'>
        <div className='container-profile-pic'>
          <img src={UserPhoto} alt="user" />
          <TextSubtext textOne={name} textTwo='Paciente'/>
          <button onClick={() => setShowModal(true)} className='btn-patient'>
            Exibir dados do paciente 
          </button>
        </div>
        <div className='line'></div>
      </div>
      <div className='right-side'>
        <Header 
        name= 'Catarina Ayla Castro'
        address={data[0].address}
        rg={data[0].rg}
        age={data[0].age}
        neighbor={data[0].neighbor}
        susNumber= {data[0].susNumber}
        />
        <FormSection sectionTitle='Último atendimento'>
          <div className='form-section-last-appointment'>
            <TextSubtext className='text-tab' textOne='Data' textTwo={data[1].date}/>
            <TextSubtext className='text-tab' textOne='Local' textTwo={data[1].ubs}/>
            <TextSubtext className='text-tab' textOne='Medico atendente' textTwo={data[1].doctor}/>
          </div>
        </FormSection>
        <FormSection sectionTitle='Prontuário'>
          <div className='form-section'>
            <div className="row">
              <div className="field-group">
                <SmallInput title='Peso' measure='kg'/>
                <SmallInput title='Altura' measure='cm'/>
              </div>
              <div className="field-group">
                <InputCheckable titleLabel='Doenças crônicas'/>
              </div>
            </div>
            <div className="row">
              <div className="field-group">
                <InputCheckable titleLabel="Remédios controlados"/>
              </div>
              <div className="field-group">
                <InputCheckable titleLabel="Alergias"/>
              </div>
            </div>
            <div className="row">
              <div className="field-group">
                <InputCheckable titleLabel='DST’s'/>
              </div>
              <div className="field-group">
                <InputCheckable titleLabel='Deficiências'/>
              </div>
            </div>
            <div className="row">
              <div className="field-group">
                <Checkbox sx={{ '& .MuiSvgIcon-root': { fontSize: 25 }}}/>
                <label>Fumante?</label>
                <Checkbox sx={{ '& .MuiSvgIcon-root': { fontSize: 25 }}}/>
                <label>Virgem?</label>
              </div>
              <div className="field-group">
                <InputCheckable titleLabel='Doenças hereditárias'/>
              </div>
            </div>
            <div className="row">
                <div className='select-group'>
                  <label>Tipo Sanguíneo</label>
                  <Select
                    id="demo-simple-select-standard"
                    value={bloodType}
                    onChange={handleChange}
                  >
                    <MenuItem value="">
                      <em>Insira o tipo sanguíneo</em>
                    </MenuItem>
                    {bloodType.map((type) =><MenuItem value={type}>{type}</MenuItem>)}
                  </Select>
                </div>
                <div className="field-group">
                  <InputCheckable titleLabel='Atividades proibidas'/>
                </div>
            </div>
          </div>
        </FormSection>
        <FormSection sectionTitle='Diagnóstico'>
          <div className='input-group'>
            <label>Queixas</label>
            <input type="text" />
            <label>Terminologia</label>
            <input type="text" />
            <label>Medicamentos</label>
            <input type="text" />
            <label>Orientações médicas</label>
            <textarea cols="20" rows="5"></textarea>
            <DateInput titleLabel="Atestado"/>
          </div>
          <div className='btn-group'>
            <button id='btn_cancel'>Cancelar</button>
            <button id='btn_save'>Salvar</button>
          </div>
        </FormSection>
      </div>
    </Container>
  ) ;
}