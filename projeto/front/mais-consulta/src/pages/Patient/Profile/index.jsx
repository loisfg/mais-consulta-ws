import React, { useEffect, useState } from "react";
import { Controller, useForm } from "react-hook-form";
import api from '../../../services/api'
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
        const response = api("maisconsulta").get(`/paciente/${idPaciente}`);
        setPatientData(response.data)
      } catch (error) {
        console.log(error);
      }
    }
  })
  
  useEffect(() => {if(patientData) reset(patientData)}, [patientData])

  const onSubmit = async (data) => {
    const idPaciente = localStorage.getItem('id')
    try {
      // await api('maisconsulta').put(`/paciente/${idPaciente}/atendimento`, data)
    } catch (error) {
      console.log(error);
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
