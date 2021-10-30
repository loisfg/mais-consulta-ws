import React, { useState } from 'react';
import { Select, Input } from '../../'
import { DivInput } from './styles';

export const PersonalData = ({ formData, setFormData }) => {

  return (
    <>
      <Input
        size='big'
        required={true}
        label="Nome completo"
        onChange={e => setFormData({ ...formData, paciente: { ...formData.paciente, nome: e.target.value } })}
      />
      <DivInput>
        <Input
          required={true}
          size='medium'
          label="CPF"
          onChange={e => setFormData({ ...formData, cpf: e.target.value })}
        />
        <Input
          required={true}
          size='medium'
          label="RG"
        // onChange={e => setFormData({ ...formData, rg: e.target.value })}
        />
      </DivInput>
      <DivInput>
        <Select
          formData={formData}
          setFormData={setFormData}
        />
        <Input
          required={true}
          size='medium'
          label="Celular"
          onChange={e => setFormData({ ...formData, telefone: e.target.value })}
        />
      </DivInput>
      <Input
        size='big'
        required={true}
        label="Número da carteirinha do SUS"
        onChange={e => setFormData({ ...formData, paciente: { ...formData.paciente, numeroCarteiraSus: e.target.value } })}
      />
    </>
  )
}