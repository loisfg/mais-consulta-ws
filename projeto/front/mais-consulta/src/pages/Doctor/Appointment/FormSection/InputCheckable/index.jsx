import React from 'react';
import { useState } from 'react';
import { Container } from './styles';
import CustomSelect from '../../../../../components/CustomSelect';

export const InputCheckable = ({titleLabel, color, options, onKeyUp ,...rest}) => {
  const [isChecked, setIsChecked] = useState(false);
  const handleEnableTextfield = (e) => setIsChecked(e.target.checked);
  return (
    <Container color={color}>
        <div className='title-group'>
            <input checked={isChecked} onChange={handleEnableTextfield} type="checkbox"/>
            <label>{titleLabel}</label>
        </div>
        <CustomSelect disabled={!isChecked} color={color} onKeyUp={onKeyUp} options={options} {...rest}/>
    </Container>
  )
};