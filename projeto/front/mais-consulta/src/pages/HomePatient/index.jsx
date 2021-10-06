import React from "react";
import { Page } from "./styles";
import { DivUsuario } from "./styles";
import { UserProfilePic, VerticalTabs } from "../../components/";

const HomePatient = () => {
  return (
    <Page>
      <DivUsuario>
        <UserProfilePic nome="Tha Calazans" subtexto=" Paciente" />
        <VerticalTabs />
      </DivUsuario>
    </Page>
  );
};

export default HomePatient;
