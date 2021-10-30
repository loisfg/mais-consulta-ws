import React from 'react';
import { Input } from '../../';
import { DivInput } from './styles'

export const Address = ({ formData, setFormData }) => {

  return (
    <>
      <Input
        size='medium'
        label="CEP"
        onChange={e => setFormData({
          ...formData,
          paciente: {
            ...formData.paciente,
            endereco: {
              ...formData.paciente.endereco,
              cep: e.target.value
            }
          }
        })
        } />
      <Input
        size='medium'
        label="Bairro"
        onChange={e => setFormData({
          ...formData,
          paciente: {
            ...formData.paciente,
            endereco: {
              ...formData.paciente.endereco,
              bairro: e.target.value
            }
          }
        })
        } />
      <DivInput>
        <Input
          size='medium'
          label="Cidade"
          onChange={e => setFormData({
            ...formData,
            paciente: {
              ...formData.paciente,
              endereco: {
                ...formData.paciente.endereco,
                cidade: e.target.value
              }
            }
          })
          } />
        <Input
          size='medium'
          label="Estado"
          onChange={e => setFormData({
            ...formData,
            paciente: {
              ...formData.paciente,
              endereco: {
                ...formData.paciente.endereco,
                estado: e.target.value
              }
            }
          })
          } />
      </DivInput>
      <Input
        size='big'
        label="Logradouro"
        onChange={e => setFormData({
          ...formData,
          paciente: {
            ...formData.paciente,
            endereco: {
              ...formData.paciente.endereco,
              logradouro: e.target.value
            }
          }
        })
        } />
      <DivInput>
        <Input
          size='medium'
          label="Número"
          onChange={e => setFormData({
            ...formData,
            paciente: {
              ...formData.paciente,
              endereco: {
                ...formData.paciente.endereco,
                numero: e.target.value
              }
            }
          })
          } />
        <Input
          size='medium'
          label="Complemento"
          onChange={e => setFormData({
            ...formData,
            paciente: {
              ...formData.paciente,
              endereco: {
                ...formData.paciente.endereco,
                complemento: e.target.value
              }
            }
          })
          } />
      </DivInput>
    </>
  );
}