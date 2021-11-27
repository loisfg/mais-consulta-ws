import React from "react";
import { TextSubtext, DataBox } from "../../../components";
import { Container, CustomAvatar, PatientGroup, H2 } from "./styles";
const username = localStorage.getItem("nome");
const typeOfUser = localStorage.getItem("role");

export const Profile = () => {
  const username = localStorage.getItem('nome');
  const role = localStorage.getItem('role')
  return (
    <Container>
      <PatientGroup>
        <CustomAvatar sx={{ bgcolor: "deepskyblue" }} />
        <TextSubtext textOne={username}></TextSubtext>
        <H2>{role}</H2>
      </PatientGroup>
      <DataBox usuario={username}/>
    </Container>
  );
};
