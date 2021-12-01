import React, { useState, useCallback } from "react";
import { useHistory } from "react-router-dom";
import { CustomForm, Div } from "./styles";
import { Button, Input, Checkbox } from "../";
import api from "../../services/api";
import { login } from "../../services/auth";

export const FormLogin = () => {
  const history = useHistory();

  const [cpf, setCpf] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const [isRemember, setIsRemember] = useState(true);

  const handleLogin = useCallback(
    async (e) => {
      e.preventDefault();
      try {
        const body = {
          cpf: cpf.replace(".", "").replace(".", "").replace("-", ""),
          password: password,
        };
        const response = await api("maisconsulta").post('/auth/signin', body)
        if(response.status === 200) {
          login(response.data)
          if(response.data.role === 'Medico') history.push('/home-doctor');
          if(response.data.role === 'Paciente') history.push('/home')
        }
      }
      catch (erro) {
        setError("CPF ou senha incorretos");
      }
    }, [history, cpf, password]);
  return (
    <>
      <CustomForm onSubmit={handleLogin}>
        <Input
          label="CPF"
          type="text"
          required
          id="text"
          size="big"
          variant="standard"
          onChange={(e) => setCpf(e.target.value)}
          placeholder="000.000.000-00"
        />
        <Input
          label="Senha"
          type="password"
          required
          id="password"
          size="big"
          variant="standard"
          onChange={(e) => setPassword(e.target.value)}
        />
        {error && <p>{error}</p>} 
        <Div>
          <Checkbox
            label="Lembrar de mim"
            checked={isRemember}
            onClick={(_) => {
              setIsRemember(!isRemember);
            }}
          />
          <button type='submit'>Entrar</button>
        </Div>
      </CustomForm>
    </>
  );
};