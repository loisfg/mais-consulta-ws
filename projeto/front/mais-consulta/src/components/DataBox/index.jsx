import React, { useState } from "react";
import { Container } from "./styles";
import { SmallInput } from '../../pages/Doctor/Appointment/FormSection/SmallInput'
import { InputCheckable } from '../../pages/Doctor/Appointment/FormSection/InputCheckable'
import { Checkbox } from  '../../components'
import Select from "react-select";
import { bloodType } from "../../pages/Doctor/Appointment/bloodType";
export const DataBox = ({control, Controller}) => {
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
                <Controller name='prontuario.peso' control={control} render={({field}) => <SmallInput {...field} measure="kg"/>}/>
              </div>
              <div>
                <label>Altura</label>
                <Controller name='prontuario.altura' control={control} render={({field}) => <SmallInput {...field} measure="cm"/>}/>
              </div>
            </div>
          </div>
          <div className='ipt_group'>
            <Controller name='prontuario.remediosControlados' control={control} render={({field}) => <InputCheckable {...field} options={'A'} color='--green-standard' titleLabel='Remédios controlados'/>}/>
          </div>
          <div className='ipt_group'>
            <Controller name='prontuario.doencasCronicas' control={control} render={({field}) => <InputCheckable {...field} options={'A'} color='--green-standard' titleLabel='Doenças crônicas'/>}/>
          </div>
          <div className='ipt_group'>
            <Controller name='prontuario.alergias' control={control} render={({field}) => <InputCheckable {...field} options={'A'} color='--green-standard' titleLabel='Alergias'/>}/>
          </div>
          <div className='ipt_group'>
            <Controller name='prontuario.deficiencias' control={control} render={({field}) => <InputCheckable {...field} options={'A'} color='--green-standard' titleLabel='Deficiências'/>}/>
          </div>
          <div className='ipt_group'>
            <Controller name='prontuario.dsts' control={control} render={({field}) => <InputCheckable {...field} options={'A'} color='--green-standard' titleLabel='DST’s'/>}/>
          </div>
          <div className='ipt_group'>
            <Controller name='prontuario.doencasHereditarias' control={control} render={({field}) => <InputCheckable {...field} options={'A'} color='--green-standard' titleLabel='Doenças hereditárias'/>}/>
          </div>
          <div className='ipt_group'>
            <Controller name='prontuario.atividadesProibidas' control={control} render={({field}) => <InputCheckable {...field} options={'A'} color='--green-standard' titleLabel='Atividades proibidas'/>}/>
          </div>
          <div className='ipt_group'>
            <div>
              <Controller name='prontuario.fumante' control={control} render={({field}) => <Checkbox {...field} checked={false}color='var(--green-standard)' label='Fumante?'/>}/>
              <Controller name='prontuario.virgem' control={control} render={({field}) => <Checkbox {...field} checked={false} color='var(--green-standard)' label='Virgem?'/>}/>
            </div>
          </div>
          <div className="ipt_group">
            <label htmlFor="bloodType">Tipo Sanguineo</label>
            <Controller name='prontuario.tipoSanguineo' control={control} render={({field}) => <Select styles={{'height': '130rem'}} id='bloodType' options={bloodType}/>}/>
          </div>
        </div>
        <div className='btn_group'>
          <button className='btn_salvar' type='submit'>Salvar</button>
          <button className='btn_cancelar' type='button'>Cancelar</button>
        </div>
      </div>
    </Container>
  );
};
