import React from 'react';
import { Input } from '../../';
import { DivInput } from './styles'

export const Address = () => {
  return (
    <>
    <Input size='medium' label="CEP" variant='standard'/>
    <DivInput>
        <Input size= 'medium' label="Cidade" variant='standard'/>
        <Input size='medium' label="Estado" variant='standard'/>
    </DivInput>
    <Input size= 'big' label="Logradouro" variant='standard' />
    <DivInput>
        <Input size='medium' label="Número" variant='standard' />
        <Input size= 'medium' label="Complemento" variant='standard'/>
    </DivInput>
    </>
  );
}