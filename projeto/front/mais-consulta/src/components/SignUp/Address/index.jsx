import React, { useState, useEffect, useCallback } from 'react';
import { Input } from '../../';
import { DivInput } from './styles'
import { SelectState } from '../../'
import api from "../../../services/api";

export const Address = ({ formData, setFormData, required }) => {

  const [bairro, setBairro] = useState(formData.paciente.endereco.bairro);
  const [cidade, setCidade] = useState(formData.paciente.endereco.cidade);
  const [logradouro, setLogradouro] = useState(formData.paciente.endereco.logradouro);
  const [estado, setEstado] = useState();

  const [dataResponse, setDataResponse] = useState({})

  async function buscarCep() {
    if (formData.paciente.endereco.cep !== '') {
      try {
        await api("viacep").get(`/ws/${formData.paciente.endereco.cep}/json/`)
          .then(response => {
            if (response.data.erro) {
            } else {
              setDataResponse(response.data)
            }
          })
      } catch (error) {
        console.log(error)
      }
    }
  }

  useEffect(() => {

    setBairro(dataResponse.bairro);
    setCidade(dataResponse.localidade);
    setLogradouro(dataResponse.logradouro);
    setEstado(dataResponse.uf);

    setFormData({
      ...formData,
      paciente: {
        ...formData.paciente,
        endereco: {
          ...formData.paciente.endereco,
          bairro: dataResponse.bairro,
          cidade: dataResponse.localidade,
          estado: dataResponse.uf,
          logradouro: dataResponse.logradouro,
        }
      }
    })

  }, [dataResponse])

  return (
    <>
      <Input
        size='medium'
        label="CEP"
        required={required}
        onChange={e => {
          setFormData({
            ...formData,
            paciente: {
              ...formData.paciente,
              endereco: {
                ...formData.paciente.endereco,
                cep: e.target.value.replace("-", "")
              }
            }
          })
        }}
        onBlur={_ => buscarCep()}
        defaultValue={formData.paciente.endereco.cep}
        helperText="00000-000"
      />
      <Input
        size='big'
        label={"Bairro"}
        required={required}
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
        }
        defaultValue={bairro}
        value={bairro}
      />
      <DivInput>
        <Input
          size='medium'
          label={"Cidade"}
          required={required}
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
          }
          defaultValue={cidade}
          value={cidade}
        />

        <SelectState
          formData={formData}
          setFormData={setFormData}
        />
      </DivInput>
      <Input
        size='big'
        label="Logradouro"
        required={required}
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
        }
        defaultValue={logradouro}
        value={logradouro}
      />
      <DivInput>
        <Input
          size='medium'
          label="Número"
          required={required}
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
          }
          defaultValue={formData.paciente.endereco.numero}
        />
        <Input
          size='medium'
          label="Complemento"
          required={required}
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
          }
          defaultValue={formData.paciente.endereco.complemento}
        />
      </DivInput>
    </>
  );
}