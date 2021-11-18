import React from 'react';
import { Container, CustomAutoComplete,  CustomTextfield } from './styles';

export function AutoCompleteInput(props) {

  return (
    <Container>
        <CustomAutoComplete
             multiple
             id="input-autocomplete"
             options={[{title: "Sim"}, {title: "Não"}]}
             getOptionLabel={(option) => option.title}
             renderInput={(params) => (
               <CustomTextfield {...params} label={props.label} />
             )}
        />
    </Container>
  )
}