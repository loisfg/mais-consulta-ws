import React, { useState } from "react";
import { Form, Container } from "./styles";

export const SignUp = (props) => {
  return (
    <Container>
      {/* <Form onSubmit={this.handleSignUp} /> */}
      <input
        type="text"
        placeholder="Nome completo"
        onChange={(e) => this.setState({ nome: e.target.value })}
      />
      <input
        type="password"
        placeholder="CPF"
        onChange={(e) => this.setState({ cpf: e.target.value })}
      />
      <input
        type="text"
        placeholder="RG"
        onChange={(e) => this.setState({ rg: e.target.value })}
      />
      <input
        type="text"
        placeholder="RG"
        onChange={(e) => this.setState({ rg: e.target.value })}
      />
    </Container>
  );
};
