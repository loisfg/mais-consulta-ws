import React, { useEffect, useState } from "react";
import { Controller, useForm } from "react-hook-form";
import api from '../../../services/api'
import swal from 'sweetalert';
import { DataBox } from "../../../components";
import { Container, CustomAvatar } from "./styles";

export const Profile = () => {
  const username = localStorage.getItem('nome');
  const role = localStorage.getItem('role');
  const [ patientData, setPatientData ] = useState({})
  const {control, reset, handleSubmit} = useForm();

  useEffect(() => {
    async function getData() {
      const idPaciente = localStorage.getItem("id"); 
      try {
        const response = await api("maisconsulta").get(`/paciente/${idPaciente}`);
        const aux = {
          ...response.data,
          prontuario: {
            ...response.data.prontuario,
            doencasHereditarias: response.data.prontuario?.doencasHereditarias?.map(option => 
                ({
                  value: option.id,
                  label: option.nome
                })
              )
          }
        }
        setPatientData(aux)
      } catch (error) {
        console.log(error);
      }
    }
    getData()
  }, [])
  
  useEffect(() => {if(patientData) reset(patientData)}, [patientData])

  const onSubmit = async (data) => {
    const idPaciente = localStorage.getItem('id')
    try {
      await api('maisconsulta').put(`/paciente`, {...data, idPaciente})
      swal("Dados alterados com sucesso!");
    } catch (error) {
      console.log(error);
      swal("Ocorreu um erro ao salvar os dados.");
    }
  }

  return (
    <Container onSubmit={handleSubmit(onSubmit)}>
      <div className="patient_group">
        <CustomAvatar sx={{ bgcolor: "deepskyblue" }} />
        <h1>{username}</h1>
        <h2>{role}</h2>
      </div>
      <DataBox control={control} Controller={Controller} usuario={username}/>
    </Container>
  );
};
