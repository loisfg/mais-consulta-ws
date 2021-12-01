import React, { useState } from "react";
import { Container } from "./styles";
import { SmallInput } from '../../pages/Doctor/Appointment/FormSection/SmallInput'
import { InputCheckable } from '../../pages/Doctor/Appointment/FormSection/InputCheckable'
import { Checkbox } from  '../../components'
import Select from "react-select";
import { bloodType } from "../../pages/Doctor/Appointment/bloodType";
import { debounceEvent } from '../../utils/debounce'
import api from "../../services/api";
export const DataBox = ({control, Controller}) => {
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
  
  return (
    <Container>
      <div className='box'>
        <h2>Dados Cadastrais</h2>
        <div className='panel'>
            <div className='ipt_group'>
              <label>Nome *</label>
              <Controller name='dadosPessoais.nome' control={control} render={({field}) => <input required {...field} className='ipt_data' type="text" />}/>
            </div>
            <div className='ipt_group'>
              <label>CPF *</label>
              <Controller name='dadosPessoais.cpf' control={control} render={({field}) => <input required {...field} className='ipt_data' type="text" />}/>
            </div>
            <div className='ipt_group'>
              <label>Número de carteira do SUS *</label>
              <Controller name='dadosPessoais.numeroSus' control={control} render={({field}) => <input required {...field} className='ipt_data' type="text" />}/>
            </div>
            <div className='ipt_group'>
              <label>Celular</label>
              <Controller name='dadosPessoais.telefone' control={control} render={({field}) => <input {...field} className='ipt_data' type="text" />}/>
            </div>
            <div className='ipt_group'>
              <label>CEP *</label>
              <Controller name='dadosPessoais.cep' control={control} render={({field}) => <input required {...field} className='ipt_data' type="text" />}/>
            </div>
            <div className='ipt_group'>
              <label>RG *</label>
              <Controller name='dadosPessoais.rg' control={control} render={({field}) => <input required {...field} className='ipt_data' type="text" />}/>
            </div>
            <div className='ipt_group'>
              <label>Estado *</label>
              <Controller name='dadosPessoais.estado' control={control} render={({field}) => <input required {...field} className='ipt_data' type="text" />}/>
            </div>
            <div className='ipt_group'>
              <label>Telefone Residencial</label>
              <Controller name='dadosPessoais.telefone' control={control} render={({field}) => <input {...field} className='ipt_data' type="text" />}/>
            </div>
            <div className='ipt_group'>
              <label>Cidade *</label>
              <Controller name='dadosPessoais.cidade' control={control} render={({field}) => <input required {...field} className='ipt_data' type="text" />}/>
            </div>
            <div className='ipt_group'>
                <label>Endereço *</label>
                <Controller name='dadosPessoais.endereco' control={control} render={({field}) => <input required {...field} className='ipt_data' type="text" />}/>
            </div>
            <div className='ipt_group'>
              <div className='side_ipt_group'>
                <div>
                  <label>Número *</label>
                  <Controller name='dadosPessoais.numero' control={control} render={({field}) => <input required {...field} className='ipt_data' type="text" />}/>
                </div>
                <div>
                  <label>Bairro *</label>
                  <Controller name='dadosPessoais.bairro' control={control} render={({field}) => <input required {...field} className='ipt_data' type="text" />}/>
                </div>
              </div>
            </div>
            <div className='ipt_group'>
                <label>Complemento</label>
                <Controller name='dadosPessoais.complemento' control={control} render={({field}) => <input {...field} className='ipt_data' type="text" />}/>
            </div>
            
        </div>
        <h2>Prontuário Médico</h2>
        <div className="panel">
          <div className="ipt_group">
            <div className='side_ipt_group'>
              <div>
                <label>Peso</label>
                <Controller name='prontuario.peso' control={control}  render={({field}) => <SmallInput {...field} role={'Paciente'} measure="kg"/>}/>
              </div>
              <div>
                <label>Altura</label>
                <Controller name='prontuario.altura' control={control} render={({field}) => <SmallInput {...field} role={'Paciente'} measure="cm"/>}/>
              </div>
            </div>
          </div>
          <div className='ipt_group'>
            <Controller name='prontuario.remediosControlados' control={control} render={({field}) => <InputCheckable {...field} onKeyUp={debounceEvent(getRemediosControlados)} options={remediosControlados} color='--green-standard' titleLabel='Remédios controlados'/>}/>
          </div>
          <div className='ipt_group'>
            <Controller name='prontuario.doencasCronicas' control={control} render={({field}) => <InputCheckable {...field} onKeyUp={debounceEvent(getDoencasCronicas)} options={doencasCronicas} color='--green-standard' titleLabel='Doenças crônicas'/>}/>
          </div>
          <div className='ipt_group'>
            <Controller name='prontuario.alergias' control={control} render={({field}) => <InputCheckable {...field} onKeyUp={debounceEvent(getAlergias)} options={alergias} color='--green-standard' titleLabel='Alergias'/>}/>
          </div>
          <div className='ipt_group'>
            <Controller name='prontuario.deficiencias' control={control} render={({field}) => <InputCheckable {...field} onKeyUp={debounceEvent(getDeficiencias)} options={deficiencias} color='--green-standard' titleLabel='Deficiências'/>}/>
          </div>
          <div className='ipt_group'>
            <Controller name='prontuario.dsts' control={control} render={({field}) => <InputCheckable {...field} onKeyUp={debounceEvent(getDsts)} options={dsts} color='--green-standard' titleLabel='DST’s'/>}/>
          </div>
          <div className='ipt_group'>
            <div>
              <Controller name='prontuario.fumante' control={control} render={({field}) => <Checkbox {...field} color='var(--green-standard)' label='Fumante?'/>}/>
              <Controller name='prontuario.virgem' control={control} render={({field}) => <Checkbox {...field} color='var(--green-standard)' label='Virgem?'/>}/>
            </div>
          </div>
          {/* <div className="ipt_group">
            <label htmlFor="bloodType">Tipo Sanguineo</label>
            <Controller name='prontuario.tipoSanguineo' control={control} render={({field}) => <Select styles={customStyles} id='bloodType' options={bloodType}/>}/>
          </div> */}
        </div>
        <div className='btn_group'>
          <button className='btn_salvar' type='submit'>Salvar</button>
          <button className='btn_cancelar' type='button'>Cancelar</button>
        </div>
      </div>
    </Container>
  );
};
