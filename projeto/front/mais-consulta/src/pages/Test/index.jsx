import { React, useEffect, useState } from 'react';
import api from '../../../src/services/api.js'
import { Dropdown } from '@material-ui/core' 
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';

export const Test = () => {
  const [remediosResponse, setRemediosResponse] = useState([]);
  const [remediosNome, setRemediosNome] = useState('');
  const [remediosId, setRemediosId] = useState(0);
  const [remediosControlado, setRemediosControlado] = useState(false);

  const remedio = {
    nome : ""
  }

  const [age, setAge] = React.useState('');

  const handleChange = (event) => {
    setAge(event.target.value);
  };

  async function buscar(e) {
    remedio.nome = e.target.value;
      try {
        await api("maisconsulta").get(`infos/remedios/auto/${remedio.nome}`)
          .then(response => {
            if (response.data.erro) {
            } else {
              setRemediosResponse(response.data)
              setRemediosNome(response.data.nome)
              setRemediosId(response.data.id)
              setRemediosControlado(response.data.controlado)
            }
          })
      } catch (error) {
        console.log(error)
      }
      console.log(remediosResponse)
  }

  return (
    //   <div>
    //     <form>
    //     <label>Input teste</label>
    //     <Dropdown/>
    //     <br />
    //     <input type="text" onChange={buscar}/>
    //     <br />
    //     <button type="submit">Enviar</button>
    //     </form>
    //   </div>

    <div>
      <FormControl variant="standard" sx={{ m: 1, minWidth: 120 }}>
        <InputLabel id="demo-simple-select-standard-label">Age</InputLabel>
        <Select
          labelId="demo-simple-select-standard-label"
          id={remediosId}
          value={remediosNome}
          onChange={}
          label="Remedios"
        >
          <MenuItem value="">
            <em>None</em>
          </MenuItem>
          <MenuItem value={10}>Ten</MenuItem>
          <MenuItem value={20}>Twenty</MenuItem>
          <MenuItem value={30}>Thirty</MenuItem>
        </Select>
      </FormControl>
    </div>
      
    );
}

/*
<div>
      <FormControl variant="standard" sx={{ m: 1, minWidth: 120 }}>
        <InputLabel id="demo-simple-select-standard-label">Age</InputLabel>
        <Select
          labelId="demo-simple-select-standard-label"
          id="demo-simple-select-standard"
          value={age}
          onChange={handleChange}
          label="Age"
        >
          <MenuItem value="">
            <em>None</em>
          </MenuItem>
          <MenuItem value={10}>Ten</MenuItem>
          <MenuItem value={20}>Twenty</MenuItem>
          <MenuItem value={30}>Thirty</MenuItem>
        </Select>
      </FormControl>
</div>
*/