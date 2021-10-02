import React, { useState } from "react";
import { Form, Container } from "./styles";

const SignUp = (props) => {
  const [userData, setUserData] = useState();

  // setUserData({
  //   nome: "",
  //   dtNascimento: "",
  //   numeroCartaoSus: "",
  //   cep: "",
  //   cidade: "",
  //   estado: "",
  //   bairro: "",
  //   logradouro: "",
  //   numero: "",
  //   complemento: "",
  //   cpf: "",
  //   email: "",
  //   password: "",
  //   telefone: "",
  //   error: "",
  //   sexo: [
  //     { id: 0, text: "Selecione o sexo: " },
  //     { id: 1, text: "M" },
  //     { id: 2, text: "F" },
  //     { id: 3, text: "Outros" },
  //   ],
  //   selectItem: 0,
  // });

  // this.handleSelectItem = this.handleSelectItem.bind(this);

  // const handleSelectItem = (e) => {
  //   this.setState({ selectItem: e.target.value });
  // };

  // const handleSignUp = (e) => {
  //   e.preventDefault();
  //   alert("Bem vindo usuário");
  // };

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

export default SignUp;
