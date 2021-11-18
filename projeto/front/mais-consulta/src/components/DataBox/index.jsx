import React from "react";
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
import { Input, AutoCompleteInput } from "../../components";

export const DataBox = () => {
  const username = localStorage.getItem("nome")
  const top100Films = [
    { title: 'Sim' },
    {
      title: 'Não',
    }, 
  ]
  return (
    <Container>
      <Box>
        <H3> Dados Cadastrais </H3>
        <Panel>
          <LeftSide>
            <Input
              size="samll"
              label="Nome"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue={username}
            />
            <Input
              size="samll"
              label="CPF"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="48309861826"
            />
            <Input
              size="samll"
              label="Número de carteira do SUS"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="34314341"
            />
            <Input
              size="samll"
              label="Celular"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="(11) 93229-4055"
            />
            <Input
              size="samll"
              label="CEP"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="08215-880"
            />
            <Input
              size="samll"
              label="Logradouro"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="Rua Luau Brilhante"
            />
          </LeftSide>

          <RightSide>
            <Input
              size="samll"
              label="RG"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="37.560.836-9"
            />
            <Input
              size="samll"
              label="Telefone Residencial"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="(11) 2053-6573"
            />
            <Input
              size="samll"
              label="Cidade"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="São Paulo"
            />
            <Input
              size="samll"
              label="Estado"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="São Paulo"
            />
            <Input
              size="samll"
              label="Número"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="80"
            />
            <Input
              size="samll"
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
              size="samll"
              label="Peso"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="60kg"
            />
            <Input
              size="samll"
              label="Altura"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="160cm"
            />
            <Input
              size="samll"
              label="Remédios controlados"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="Gardenal"
            />
            <Input
              size="samll"
              label="Alergias"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="Pelo de animal"
            />
            <Input
              size="samll"
              label="DST'S"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="AIDS"
            />
            <Input
              size="samll"
              label="Atividades Proibidas"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="Não possuo nenhuma atividade proibida"
            />
            <AutoCompleteInput  label={"Virgem"}/>
          </LeftSide>

          <RightSide>
            <Input
              size="samll"
              label="IMC"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="11"
            />
            <Input
              size="medium"
              label="Doenças cronicas"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="Asma"
            />
            <Input
              size="samll"
              label="Deficiências"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="Não possuo nenhuma deficiência"
            />
            <Input
              size="samll"
              label="Doenças hereditarias"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue="Não possuo nenhuma doença hereditária"
            />
          <AutoCompleteInput  label={"Fumente"} opcoes={{title: "olaaa"}}/>
            <AutoCompleteInput  label={"Tipo Sanguíneo"} opcoes={{title: "oi"}}/>
          </RightSide>
        </PanelTwo>
      </Box>
    </Container>
  );
};
