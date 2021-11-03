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
  const [isMedico, setIsMedico] = useState(false);

  const handleLogin = useCallback(
    async (e) => {
      e.preventDefault();
      if (!cpf && !password) {
        setError("Preencha cpf e password para continuar!");
      } else {
        try {
          let params = {
            cpf: cpf.replace(".", "").replace(".", "").replace("-", ""),
            password: password,
          };

          console.log(params);

          let response = {};

          if (isMedico === false) {
            response = await api.post("/auth/signin", params);
          } else if (isMedico === true) {
            response = await api.post("//signin", params);
          }

          if (response.status === 200) {
            const usuarioString = JSON.stringify(response.data);
            login(usuarioString);
            history.push("/home");
          }
        } catch (erro) {
          console.log(erro);
          setError("Cpf ou senha incorretos");
        }
      }
    },
    [cpf, password, history, isMedico]
  );

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
          <Checkbox
            label="Sou médico"
            checked={isMedico}
            onClick={(_) => {
              setIsMedico(!isMedico);
            }}
          />
          <Button type="submit" text="Entrar" />
        </Div>
      </CustomForm>
    </>
  );
};
