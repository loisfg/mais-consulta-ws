import React from 'react';
import { Container, Box, Panel, LeftSide, RightSide } from './styles';
import {Input } from '../../components'


export const DataBox = () => {
  return (
    <Container>
      <Box>
        <Panel>
        <LeftSide>
          <Input>
          
          </Input>
          
        </LeftSide>
        <RightSide>
        </RightSide>
        </Panel>
      </Box>
    </Container>
  );
}