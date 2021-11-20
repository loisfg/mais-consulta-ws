import React, { useState } from "react";
import {
  Container,
  Box,
  Panel,
  LeftSide,
  RightSide,
  H2,
  PanelTwo,
  H3,
} from "./styles";
import { Input } from "../../components";

export const DataBox = () => {
  const username = localStorage.getItem("nome")

  const [textos, setTextos] = useState([
    {title: 'Sim'},
    {title: 'nao'},

  ]);
  return (
    <Container>
      <Box>
        <H3> Dados Cadastrais </H3>
        <Panel>
          <LeftSide>
            <Input
              size="big"
              label="Nome"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue={username}
            />
            <Input
              size="big"
              label="CPF"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="48309861826"
            />
            <Input
              size="big"
              label="Número de carteira do SUS"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="34314341"
            />
            <Input
              size="big"
              label="Celular"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="(11) 93229-4055"
            />
            <Input
              size="big"
              label="CEP"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="08215-880"
            />
            <Input
              size="big"
              label="Logradouro"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="Rua Luau Brilhante"
            />
          </LeftSide>

          <RightSide>
            <Input
              size="big"
              label="RG"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="37.560.836-9"
            />
            <Input
              size="big"
              label="Telefone Residencial"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="(11) 2053-6573"
            />
            <Input
              size="big"
              label="Cidade"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="São Paulo"
            />
            <Input
              size="big"
              label="Estado"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="São Paulo"
            />
            <Input
              size="big"
              label="Número"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="80"
            />
            <Input
              size="big"
              label="Bairro"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="Itaquera"
            />
          </RightSide>
        </Panel>

        <H3> Prontuário do Médico</H3>
        <PanelTwo>
          <LeftSide>
            <Input
              size="big"
              label="Peso"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="60kg"
            />
            <Input
              size="big"
              label="Altura"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="160cm"
            />
            <Input
              size="big"
              label="Remédios controlados"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="Gardenal"
            />
            <Input
              size="big"
              label="Alergias"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="Pelo de animal"
            />
            <Input
              size="big"
              label="DST'S"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="AIDS"
            />
            <Input
              size="big"
              label="Atividades Proibidas"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="Não possuo nenhuma atividade proibida"
            />
            
          </LeftSide>

          <RightSide>
            <Input
              size="big"
              label="IMC"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="11"
            />
            <Input
              size="big"
              label="Doenças cronicas"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="Asma"
            />
            <Input
              size="big"
              label="Deficiências"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="Não possuo nenhuma deficiência"
            />
            <Input
              size="big"
              label="Doenças hereditarias"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="Não possuo nenhuma doença hereditária"
            />
          
          </RightSide>
        </PanelTwo>
      </Box>
    </Container>
  );
};
