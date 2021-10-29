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
            variant='standard'
        />
        <DivInput>
            <Input required={true} size='medium' label="CPF" variant='standard'/>
            <Input required={true} size= 'medium' label="RG" variant='standard'/>
        </DivInput>
        <DivInput>
            <Select/>
            <Input required={true} size='medium' label="Celular" variant='standard'/>
        </DivInput>
        <Input 
        size='big' 
        required={true} 
        label="Número da carteirinha do SUS" variant='standard'/>
    </>
  )
}