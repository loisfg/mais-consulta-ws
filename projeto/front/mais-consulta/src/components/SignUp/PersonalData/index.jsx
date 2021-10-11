import React from 'react';
import { Select, Input } from '../../'
import { DivInput } from './styles';

export const PersonalData = () => {
  return(
    <>
        <Input 
            size='big' 
            required='required' 
            label="Nome completo"
        />
        <DivInput>
            <Input size='medium' label="CPF"/>
            <Input size= 'medium' label="RG"/>
        </DivInput>
        <DivInput>
            <Select/>
            <Input size='medium' label="Celular"/>
        </DivInput>
        <Input 
        size='big' 
        required='required' 
        label="Número da carteirinha do SUS"/>
    </>
  )
}