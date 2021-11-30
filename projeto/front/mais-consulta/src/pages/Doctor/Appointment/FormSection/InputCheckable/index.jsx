import React, { useEffect } from 'react';
import { useState } from 'react';
import { Container } from './styles';
import CustomSelect from '../../../../../components/CustomSelect';
import { remedios } from '../../../../AutoCompleteTest/remedios';

export const InputCheckable = ({titleLabel, color, ...rest}) => {
  const [isChecked, setIsChecked] = useState(true);
  const [ data, setData ] = useState([])
  const handleEnableTextfield = (e) => setIsChecked(e.target.checked === true ? false : true );
  useEffect(() => {
    console.log(rest)
    // const opt = rest.value.map(option => 
    //   ({
    //     value: option.id,
    //     label: option.nome
    //   })
    // )
    // setData(opt)
  }, [])
  return (
      <Container color={color}>
        <CustomSelect options={data}/>
      </Container>
  )
};