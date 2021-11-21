import React from 'react';
import { useState } from 'react';
import { Container } from './styles';

export const InputCheckable = ({titleLabel, ...rest}) => {
  const [isChecked, setIsChecked] = useState(true);
  const handleEnableTextfield = (e) => setIsChecked(e.target.checked === true ? false : true )
return (
      <Container>
      <div className='title-group'>
        <input checked={rest.value?.length} onChange={handleEnableTextfield} type="checkbox"/>
        <label>{titleLabel}</label>
      </div>
      <input {...rest} className='styled-input' disabled={isChecked} type="text" />
      </Container>
  )
};