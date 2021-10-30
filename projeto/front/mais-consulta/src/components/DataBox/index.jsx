import React from 'react';
import { Container, Box, Panel, LeftSide, RightSide, H2, PanelTwo, H3} from './styles';
import {Input } from '../../components'


export const DataBox = () => {
  return (
    <Container>
      <Box>
      <H3> Dados Cadastrais</H3>
        <Panel>
        <LeftSide>
          <H2> Nome </H2>
          <Input size="medium" label="Maria Luisa" variant="outlined" />
          <H2> Cpf </H2>
          <Input size="medium" label="483.098.618.26" variant="outlined" />
          <H2> Número de carteiro do SUS </H2>
          <Input size="medium" label="00098480984" variant="outlined" />
          <H2> Celular </H2>
          <Input size="medium" label="(11)93229-4055" variant="outlined" />
          <H2> Cep </H2>
          <Input size="medium" label="08215-880" variant="outlined" />
          <H2> Logradouro </H2>
          <Input size="medium" label="Rua Brilhanteined" variant="outlined" />
        </LeftSide>

        <RightSide>
        <H2> Sobrenome </H2>
          <Input size="medium" label="Santos" variant="outlined" />
          <H2> RG </H2>
          <Input size="medium" label="37.560.836-9" variant="outlined" />
          <H2> Telefone Residencial</H2>
          <Input size="medium" label="(11) 2053-6573" variant="outlined" />
          <H2> Cidade </H2>
          <Input size="medium" label="São Paulo" variant="outlined" />
          <H2> Estado </H2>
          <Input size="medium" label="08215-880" variant="outlined" />
          <H2> Número </H2>
          <Input size="medium" label="80" variant="outlined" />
          <H2> Bairro </H2>
          <Input size="medium" label="Itaquera" variant="outlined" />


        </RightSide>

        
        </Panel>

        <H3> Prontuário do Médico</H3>
        <PanelTwo>

        <LeftSide>
          <H2> Peso </H2>
          <Input size="medium" label="60kg" variant="outlined" />
          <H2> Altura </H2>
          <Input size="medium" label="160cm" variant="outlined" />
          <H2> Remédios controlados </H2>
          <Input size="medium" label="Gardenal, Clomipramina..." variant="outlined" />
          <H2> Alergias </H2>
          <Input size="medium" label="Pelo de animal, Pó.." variant="outlined" />
          <H2> DST'S </H2>
          <Input size="medium" label="AIDS" variant="outlined" />
          <H2> Atividades Proibidas </H2>
          <Input size="medium" label="Não possuo nenhuma atividade proibida" variant="outlined" />
          <H2> Virgem</H2>
          <Input size="medium" label="Selecione a opção" variant="outlined" />
        </LeftSide>
        

        <RightSide>
        <H2> IMC </H2>
          <Input size="medium" label="Saudável" variant="outlined" />
          <H2> Doenças cronicas </H2>
          <Input size="medium" label="Asma, Diabetes" variant="outlined" />
          <H2> Deficiências</H2>
          <Input size="medium" label="(Digite aqui)" variant="outlined" />
          <H2> Doenças hereditarias </H2>
          <Input size="medium" label="(Digite aqui)" variant="outlined" />
          <H2> Fumante </H2>
          <Input size="medium" label="(Digite aqui)" variant="outlined" />
          <H2> Tipo Sanguíne </H2>
          <Input size="medium" label="Ex: O+ ou 0-" variant="outlined" />
          

        </RightSide>


        </PanelTwo>
       
      </Box>
    </Container>
  );
}