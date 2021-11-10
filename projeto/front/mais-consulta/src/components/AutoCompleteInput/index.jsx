import React from 'react';
import { Container, CustomAutoComplete,  CustomTextfield } from './styles';
export const AutoCompleteInput = ({label}) => {
return (
    <Container>
        <CustomAutoComplete
             multiple
             id="input-autocomplete"
             options={top100Films}
             getOptionLabel={(option) => option.title}
             renderInput={(params) => (
               <CustomTextfield {...params} label={label} />
             )}
        />
    </Container>
  )
};

const top100Films = [
  { title: 'The Shawshank Redemption', year: 1994 },
  { title: 'The Godfather', year: 1972 },
  { title: 'The Godfather: Part II', year: 1974 },
  { title: 'The Dark Knight', year: 2008 },
  { title: '12 Angry Men', year: 1957 },
  { title: "Schindler's List", year: 1993 },
  { title: 'Pulp Fiction', year: 1994 },
  {
    title: 'The Lord of the Rings: The Return of the King',
    year: 2003,
  },
  { title: 'The Good, the Bad and the Ugly', year: 1966 },
  { title: 'Fight Club', year: 1999 },
  {
    title: 'The Lord of the Rings: The Fellowship of the Ring',
    year: 2001,
  },
  {
    title: 'Star Wars: Episode V - The Empire Strikes Back',
    year: 1980,
  }
]