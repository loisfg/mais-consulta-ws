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
        onChange={e => setFormData({ ...formData, paciente: { ...formData.paciente, nome: e.target.value, ...formData.endereco } })}
        defaultValue={formData.paciente.nome}
      />

      <DivInput>
        <Input
          size='big'
          label='Email'
          onChange={e => setFormData({ ...formData, email: e.target.value, ...formData.paciente })}
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
          onChange={e => setFormData({ ...formData, telefone: e.target.value, ...formData.paciente })}
          defaultValue={formData.telefone}
          helperText="(DDD) 00000-0000"
        />
      </DivInput>

      <Input
        size='big'
        required={required}
        label="Número da carteirinha do SUS"
        onChange={e => setFormData({ ...formData, paciente: { ...formData.paciente, numeroCarteiraSus: e.target.value, ...formData.endereco } })}
        defaultValue={formData.paciente.numeroCarteiraSus}
      />
    </>
  )
}