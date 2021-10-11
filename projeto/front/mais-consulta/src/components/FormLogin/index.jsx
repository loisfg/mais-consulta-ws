import React, { useState, useCallback } from 'react';
import { useHistory } from "react-router-dom"
import { CustomForm, Div } from './styles';
import { Button, Input, Checkbox } from '../'
import api from "../../services/api"

export const FormLogin = () => {

  const history = useHistory()

  const [cpf, setCpf] = useState("")
  const [password, setPassword] = useState("")
  const [error, setError] = useState("")

  const handleLogin = useCallback(
    async (e) => {
      e.preventDefault()

      if (!cpf && !password) {
        setError("Preencha cpf e password para continuar!")
      } else {
        try {
          let params = {
            cpf: cpf,
            password: password
          }
          const response = await api.post("/auth/login", params)
          if (response.status === 200) {

            const usuarioString = JSON.stringify(response.data)

            localStorage.setItem("usuario", usuarioString)

            // const objetoEmFormatoDeString = localStorage.getItem('usuario');
            // const objetoMesmo = JSON.parse(objetoEmFormatoDeString)

            history.push("/home")
          }
        } catch (erro) {
          console.log(erro);
          setError("Cpf ou senha incorretos")
        }
      }
    }, [cpf, password, history])

  return (

    <>
      <CustomForm onSubmit={handleLogin}>
        {error && <p>{error}</p>}
        <Input
          label='CPF'
          type="cpf"
          id="cpf"
          size= 'big'
          onChange={e => setCpf(e.target.value)}
        />
        <Input
          label='Senha'
          type="password"
          id="password"
          size= 'big'
          onChange={e => setPassword(e.target.value)}
        />
        <Div>
          <Checkbox label='Lembrar de mim' />
          <Button type="submit" text='Entrar' />
        </Div>
      </CustomForm>
    </>
  )


};
