import React, { useEffect } from 'react';
import { useState } from 'react';
import { Container } from './styles';
import CustomSelect from '../../../../../components/CustomSelect';

export const InputCheckable = ({titleLabel, color, options, ...rest}) => {
  const [isChecked, setIsChecked] = useState(true);
  const handleEnableTextfield = (e) => setIsChecked(e.target.checked === true ? false : true );
  return (
      <Container color={color}>
        <h1>{titleLabel}</h1>
        <CustomSelect options={options} {...rest}/>
      </Container>
  )
};