import React from "react";
import { TextSubtext, DataBox } from "../../../components";
import { Container, CustomAvatar, PatientGroup, H2 } from "./styles";
const username = localStorage.getItem("nome")
export const Profile = () => {
  return (
    <Container>
      <PatientGroup>
        <CustomAvatar sx={{ bgcolor: "deepskyblue" }} />
        <TextSubtext textOne={username}></TextSubtext>
        <H2> Paciente</H2>
      </PatientGroup>
      <DataBox usuario={username}/>
    </Container>
  );
};
