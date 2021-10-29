import React from 'react';
import { Container, Box, Panel, LeftSide, RightSide, H2, PanelTwo} from './styles';
import {Input } from '../../components'


export const DataBox = () => {
  return (
    <Container>
      <Box>
        <Panel>
        <LeftSide>
          <H2> Nome </H2>
          <Input size="medium" label="Maria Luisa" variant="outlined" />
          <H2> Cpf </H2>
          <Input size="big" label="483.098.618.26" variant="outlined" />
          <H2> Número de carteiro do SUS </H2>
          <Input size="big" label="00098480984" variant="outlined" />
          <H2> Celular </H2>
          <Input size="big" label="(11)93229-4055" variant="outlined" />
          <H2> Cep </H2>
          <Input size="big" label="08215-880" variant="outlined" />
          <H2> Logradouro </H2>
          <Input size="big" label="Rua Brilhanteined" variant="outlined" />
        </LeftSide>

        <RightSide>
        <H2> Sobrenome </H2>
          <Input size="big" label="Santos" variant="outlined" />
          <H2> RG </H2>
          <Input size="big" label="37.560.836-9" variant="outlined" />
          <H2> Telefone Residencial</H2>
          <Input size="big" label="(11) 2053-6573" variant="outlined" />
          <H2> Cidade </H2>
          <Input size="big" label="São Paulo" variant="outlined" />
          <H2> Estado </H2>
          <Input size="big" label="08215-880" variant="outlined" />
          <H2> Número </H2>
          <Input size="small" label="80" variant="outlined" />
          <H2> Bairro </H2>
          <Input size="big" label="Itaquera" variant="outlined" />


        </RightSide>

        
        </Panel>
        <PanelTwo>
          <H2> Prontuário do Médico</H2>

        </PanelTwo>
       
      </Box>
    </Container>
  );
}