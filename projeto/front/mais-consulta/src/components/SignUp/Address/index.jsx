import React from 'react';
import { Input } from '../../';
import { DivInput } from './styles'

export const Address = () => {
  return (
    <>
    <Input size='medium' label="CEP"/>
    <DivInput>
        <Input size= 'medium' label="Cidade"/>
        <Input size='medium' label="Estado"/>
    </DivInput>
    <Input size= 'big' label="Logradouro"/>
    <DivInput>
        <Input size='medium' label="Número"/>
        <Input size= 'medium' label="Complemento"/>
    </DivInput>
    </>
  );
}