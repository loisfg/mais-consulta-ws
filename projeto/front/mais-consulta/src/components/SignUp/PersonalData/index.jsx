import React from 'react';
import { Select, Input } from '../../'
import { DivInput } from './styles';

export const PersonalData = ({data}) => {
  return(
    <>
        <Input 
            size='big' 
            required={true} 
            label="Nome completo"
            value={data.name}
        />
        <DivInput>
            <Input required={true} size='medium' label="CPF"/>
            <Input required={true} size= 'medium' label="RG"/>
        </DivInput>
        <DivInput>
            <Select/>
            <Input required={true} size='medium' label="Celular"/>
        </DivInput>
        <Input 
        size='big' 
        required={true} 
        label="Número da carteirinha do SUS"/>
    </>
  )
}