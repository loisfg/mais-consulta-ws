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

export const DataBox = ({ usuario }) => {
  console.log(usuario);

  // cpf: "48309861826"
  // email: "gustavo@gmail.com"
  // paciente:
  // dtNascimento: "1962-11-02"
  // endereco:
  // bairro: "sunt velit enim"
  // cep: "sed nulla aute laboris sunt"
  // cidade: "ullamco nostrud"
  // complemento: "tempor ut"
  // estado: "fugiat consectetur"
  // idEndereco: 1
  // logradouro: "adipisicing"
  // numero: "dolor magna sint"
  // __proto__: Object
  // idPaciente: 1
  // nome: "Gustavo Cassimiro"
  // numeroCarteiraSus: "34314341"
  // sexo: "masculino"
  // telefone: null

  return (
    <Container>
      <Box>
        <H3> Dados Cadastrais</H3>
        <Panel>
          <LeftSide>
            {/* <H2> Nome </H2> */}
            <Input
              size="medium"
              label="Nome"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue={usuario.paciente.nome}
            />
            {/* <H2> Cpf </H2> */}
            <Input
              size="medium"
              label="CPF"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue={usuario.cpf}
            />
            {/* <H2> Número de carteiro do SUS </H2> */}
            <Input
              size="medium"
              label="Número de carteira do SUS"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue={usuario.paciente.numeroCarteiraSus}
            />
            {/* <H2> Celular </H2> */}
            <Input
              size="medium"
              label="Celular"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue={usuario.paciente.telefone}
            />
            {/* <H2> Cep </H2> */}
            <Input
              size="medium"
              label="CEP"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue={usuario.paciente.endereco.cep}
            />
            {/* <H2> Logradouro </H2> */}
            <Input
              size="medium"
              label="Logradouro"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue={usuario.paciente.endereco.logradouro}
            />
          </LeftSide>

          <RightSide>
            {/* <H2> RG </H2> */}
            <Input
              size="medium"
              label="RG"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue={usuario.rg}
            />
            {/* <H2> Telefone Residencial</H2> */}
            <Input
              size="medium"
              label="Telefone Residencial"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue={usuario.paciente.telefone}
            />
            {/* <H2> Cidade </H2> */}
            <Input
              size="medium"
              label="Cidade"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue={usuario.paciente.endereco.cidade}
            />
            {/* <H2> Estado </H2> */}
            <Input
              size="medium"
              label="Estado"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue={usuario.paciente.endereco.estado}
            />
            {/* <H2> Número </H2> */}
            <Input
              size="medium"
              label="Número"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue={usuario.paciente.endereco.numero}
            />
            {/* <H2> Bairro </H2> */}
            <Input
              size="medium"
              label="Bairro"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue={usuario.paciente.endereco.bairro}
            />
          </RightSide>
        </Panel>

        <H3> Prontuário do Médico</H3>
        <PanelTwo>
          <LeftSide>
            {/* <H2> Peso </H2> */}
            <Input
              size="medium"
              label="Peso"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue={usuario.paciente.nome}
            />
            {/* <H2> Altura </H2> */}
            <Input
              size="medium"
              label="Altura"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue={usuario.paciente.nome}
            />
            {/* <H2> Remédios controlados </H2> */}
            <Input
              size="medium"
              label="Remédios controlados"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue={usuario.paciente.nome}
            />
            {/* <H2> Alergias </H2> */}
            <Input
              size="medium"
              label="Alergias"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue={usuario.paciente.nome}
            />
            {/* <H2> DST'S </H2> */}
            <Input
              size="medium"
              label="DST'S"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue={usuario.paciente.nome}
            />
            {/* <H2> Atividades Proibidas </H2> */}
            <Input
              size="medium"
              label="Atividades Proibidas"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue={usuario.paciente.nome}
            />
            {/* <H2> Virgem</H2> */}
            <AutoCompleteInput  label={"Virgem"}/>
          </LeftSide>

          <RightSide>
            {/* <H2> IMC </H2> */}
            <Input
              size="medium"
              label="IMC"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue={usuario.paciente.nome}
            />
            {/* <H2> Doenças cronicas </H2> */}
            <Input
              size="medium"
              label="Doenças cronicas"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue={usuario.paciente.nome}
            />
            {/* <H2> Deficiências</H2> */}
            <Input
              size="medium"
              label="Deficiências"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue={usuario.paciente.nome}
            />
            {/* <H2> Doenças hereditarias </H2> */}
            <Input
              size="medium"
              label="Doenças hereditarias"
              variant="outlined"
              placeholder="Adicionar informação"
              defaultValue={usuario.paciente.nome}
            />
            {/* <H2> Fumante </H2> */}
            <AutoCompleteInput  label={"Fumente"}/>
            {/* <H2> Tipo Sanguíne </H2> */}
            <AutoCompleteInput  label={"Tipo Sanguíneo"} />
          </RightSide>
        </PanelTwo>
      </Box>
    </Container>
  );
};
