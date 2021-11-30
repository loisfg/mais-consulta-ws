import React from 'react';
import { SelectSex, Input } from '../../'
import { DivInput } from './styles';

export const PersonalData = ({ formData, setFormData, required }) => {

  return (
    <>
      <Input
        size='big'
        required={required}
        label="Nome completo"
        onChange={e => setFormData({ ...formData, paciente: { ...formData.paciente, nome: e.target.value } })}
        defaultValue={formData.paciente.nome}
      />
      <Input
        size='big'
        required={required}
        label="Data de nascimento"
        onChange={e => setFormData({ ...formData, paciente: { ...formData.paciente, nome: e.target.value } })}
        defaultValue={formData.dt_nascimento}
      />  
      <DivInput>
        <Input
          size='big'
          label='Email'
          onChange={e => setFormData({ ...formData, email: e.target.value })}
          defaultValue={formData.email}
        />
      </DivInput>

      <DivInput>
        <SelectSex
          required={required}
          formData={formData}
          setFormData={setFormData}
        />
        <Input
          required={required}
          size='medium'
          label="Telefone"
          onChange={e => setFormData({ ...formData, telefone: e.target.value })}
          defaultValue={formData.telefone}
          helperText="(DDD) 00000-0000"
        />
      </DivInput>

      <Input
        size='big'
        required={required}
        label="Número da carteirinha do SUS"
        onChange={e => setFormData({ ...formData, paciente: { ...formData.paciente, numeroCarteiraSus: e.target.value } })}
        defaultValue={formData.paciente.numeroCarteiraSus}
      />
    </>
  )
}