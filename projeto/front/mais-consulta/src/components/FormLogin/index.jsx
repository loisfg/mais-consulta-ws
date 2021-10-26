import React, { useState, useCallback } from 'react';
import { useHistory } from "react-router-dom"
import { CustomForm, Div, CustomInputMask } from './styles';
import { Button, Input, Checkbox } from '../'
import api from "../../services/api"
import { login } from '../../services/auth';

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
          login(123)
          let params = {
            cpf: cpf,
            password: password
          }
          // const response = await api.post("/auth/login", params)
          // if (response.status === 200) {
          //   const usuarioString = JSON.stringify(response.data)
          //   localStorage.setItem("usuario", usuarioString)

          //   // const objetoEmFormatoDeString = localStorage.getItem('usuario');
          //   // const objetoMesmo = JSON.parse(objetoEmFormatoDeString)
          //   history.push("/home")

          // }
          window.location.href = '/home'
        } catch (erro) {
          console.log(erro);
          setError("Cpf ou senha incorretos")
        }
      }
    }, [cpf, password, history])

  return (
    <>
      <CustomForm onSubmit={handleLogin}>
       
        {/* <Input
          label='CPF'
          id="cpf"
          type='cpf'
          required
          // value= '999.999.999-99'
          size= 'big'
          onChange={e => setCpf(e.target.value)}> */}
          <CustomInputMask 
          mask='999.999.999-99'
          value={cpf}
          onChange={(event) => setCpf(event.target.value)}
          >
          </CustomInputMask>
        {/* </Input> */}
        <Input
          label="Senha"
          type="password"
          required
          id="password"
          size= "big"
          onChange={e => setPassword(e.target.value)}
        />
         {error && <p>{error}</p>}
        <Div>
          <Checkbox label='Lembrar de mim' />
          <Button type="submit" text='Entrar' />
        </Div>
      </CustomForm>
    </>
  )


};
