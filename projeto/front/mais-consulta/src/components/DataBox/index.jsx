import React, { useState } from "react";
import { useForm, Controller } from 'react-hook-form';
import { Container } from "./styles";
import { SmallInput } from '../../pages/Doctor/Appointment/FormSection/SmallInput'
import { InputCheckable } from '../../pages/Doctor/Appointment/FormSection/InputCheckable'
import { Checkbox } from  '../../components'
import Select from "react-select";
import { bloodType } from "../../pages/Doctor/Appointment/bloodType";
export const DataBox = ({data}) => {
  const {control, reset, handleSubmit} = useForm();
  return (
    <Container>
      <div className='box'>
        <h2>Dados Cadastrais</h2>
        <div className='panel'>
            <div className='ipt_group'>
              <label>Nome</label>
              <Controller name='prontuario.peso' control={control} render={({field}) => <input className='ipt_data' type="text" />}/>
            </div>
            <div className='ipt_group'>
              <label>CPF</label>
              <input className='ipt_data' type="text" />
            </div>
            <div className='ipt_group'>
              <label>Número de carteira do SUS</label>
              <input className='ipt_data' type="text" />
            </div>
            <div className='ipt_group'>
              <label>Celular</label>
              <input className='ipt_data' type="tel" />
            </div>
            <div className='ipt_group'>
              <label>CEP</label>
              <input className='ipt_data' type="text" />
            </div>
            <div className='ipt_group'>
              <label>RG</label>
              <input className='ipt_data' type="text" />
            </div>
            <div className='ipt_group'>
              <label>Estado</label>
              <input className='ipt_data' type="text" />
            </div>
            <div className='ipt_group'>
              <label>Telefone Residencial</label>
              <input className='ipt_data' type="text" />
            </div>
            <div className='ipt_group'>
              <label>Cidade</label>
              <input className='ipt_data' type="text" />
            </div>
            <div className='ipt_group'>
              <label>RG</label>
              <input className='ipt_data' type="text" />
            </div>
            <div className='ipt_group'>
                <label>Logradouro</label>
                <input className='ipt_data' type="text" />
            </div>
            <div className='ipt_group'>
              <div className='side_ipt_group'>
                <div>
                  <label>Número</label>
                  <input id='ipt_numero' type="text" />
                </div>
                <div>
                  <label>Bairro</label>
                  <input id='ipt_bairro' type="text" />
                </div>
              </div>
            </div>
            
        </div>
        <h2>Prontuário do Médico</h2>
        <div className="panel">
          <div className="ipt_group">
            <div className='side_ipt_group'>
              <div>
                <label>Peso</label>
                <SmallInput measure="kg"/>
              </div>
              <div>
                <label>Altura</label>
                <SmallInput measure="cm"/>
              </div>
            </div>
          </div>
          <div className='ipt_group'>
            <InputCheckable color='--green-standard' titleLabel='Remédios controlados'/>
          </div>
          <div className='ipt_group'>
            <InputCheckable color='--green-standard' titleLabel='Doenças crônicas'/>
          </div>
          <div className='ipt_group'>
            <InputCheckable color='--green-standard' titleLabel='Alergias'/>
          </div>
          <div className='ipt_group'>
            <InputCheckable color='--green-standard' titleLabel='Deficiências'/>
          </div>
          <div className='ipt_group'>
            <InputCheckable color='--green-standard' titleLabel='DST’s'/>
          </div>
          <div className='ipt_group'>
            <InputCheckable color='--green-standard' titleLabel='Doenças hereditárias'/>
          </div>
          <div className='ipt_group'>
            <InputCheckable color='--green-standard' titleLabel='Atividades proibidas'/>
          </div>
          <div className='ipt_group'>
            <div>
              <Checkbox color='var(--green-standard)' label='Fumante?'/>
              <Checkbox color='var(--green-standard)' label='Virgem?'/>
            </div>
          </div>
          <div className="ipt_group">
            <label htmlFor="bloodType">Tipo Sanguineo</label>
            <Select styles={{'height': '130rem'}} id='bloodType' options={bloodType}/>
          </div>
        </div>
      </div>
    </Container>
  );
};
