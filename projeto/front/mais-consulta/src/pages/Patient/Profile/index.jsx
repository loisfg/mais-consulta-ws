import React, { useEffect, useState } from "react";
import api from '../../../services/api'
import { TextSubtext, DataBox } from "../../../components";
import { Container, CustomAvatar, PatientGroup, H2 } from "./styles";

export const Profile = () => {
  const username = localStorage.getItem('nome');
  const role = localStorage.getItem('role');
  const [ patientData, setPatientData ] = useState({})

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

  return (
    <Container>
      <div className="patient_group">
        <CustomAvatar sx={{ bgcolor: "deepskyblue" }} />
        <h1>{username}</h1>
        <h2>{role}</h2>
      </div>
      <DataBox usuario={username}/>
    </Container>
  );
};
