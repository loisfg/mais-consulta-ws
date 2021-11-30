import React, { useState, useEffect } from "react";
import { Container} from './styles';
import Checkbox from '@mui/material/Checkbox';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import IconDownload from '../../assets/download.svg';
import api from "../../services/api";
import Select from 'react-select';

export const SchedulingTwo = (props) => {

  const [idAgendamento, setIdAgendamento] = useState();
  function createData(data, hora,  consulta, medico, local) {
    return { data, hora,  consulta, medico, local };
  }

  const label = { inputProps: { 'aria-label': 'Checkbox demo' } };

  const idPaciente = localStorage.getItem("id"); 
  // const [idAgendamento, setIdAgendamento] = useState();
  const [listConsulta, setListConsulta] = useState([]);

  sessionStorage.idAgend = idAgendamento;

  useEffect(() => {
      async function listaConsulta() {
          const resp = await api("maisconsulta").get(`/paciente/historico/${idPaciente}`)
          setListConsulta(resp.data)
      }
      listaConsulta();
  }, []);
 
  const format = (hora) =>{
    if(hora){
     const hourArray = hora.split(":")
     return (
         `${hourArray[0]}:${hourArray[1]}`
     )
    }
  }

  const formatData = (data) =>{
    var dd = String(new Date().getDate()).padStart(2, '0');
    var mm = String(new Date().getMonth()+ 1).padStart(2, '0'); 
    var yyyy = new Date().getFullYear();
    
    data = yyyy + '/' + mm + '/' + dd;
  }

  var auxIdAgendamento;

  return (
    <Container>
      <TableContainer component={Paper} >
        <Table sx={{ fontSize: 18 }} size="medium" aria-label="a dense table">
          <TableHead>
            <TableRow>
              <TableCell align="center" style={{fontSize:16, fontWeight:700, color:"#515151"}}>Selecionar</TableCell>
              <TableCell align="center" style={{fontSize:16, fontWeight:700, color:"#515151"}}>Data</TableCell>
              <TableCell align="center" style={{fontSize:16, fontWeight:700, color:"#515151"}}>Hora</TableCell>
              <TableCell align="left" style={{fontSize:16, fontWeight:700, color:"#515151"}}>Consulta</TableCell>
              <TableCell align="left" style={{fontSize:16, fontWeight:700, color:"#515151"}}>Médico</TableCell>
              <TableCell align="left" style={{fontSize:16, fontWeight:700, color:"#515151"}}>Local</TableCell>
              <TableCell align="center" style={{fontSize:16, fontWeight:700, color:"#515151"}}>Download</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>

            {listConsulta.map((row) => (
              <TableRow style={{fontSize:18}}
                // key={row.id}
                sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
              >
                <TableCell align="center">
                  <Checkbox
                    {...label}
                    sx={{ '& .MuiSvgIcon-root': { fontSize: 24 } }} style={{color:"#19A795"}}
                    key={row.idAgendamento}
                    onClick={() =>{
                      setIdAgendamento(row.idAgendamento)
                    }}
                    />
                </TableCell>
                <TableCell align="center" style={{fontSize:16, color:"#515151"}}>{row.dtAtendimento}</TableCell>
                <TableCell align="center" style={{fontSize:16, color:"#515151"}}>{format(row.horaAtendimento)}</TableCell>
                <TableCell align="left" style={{fontSize:16, color:"#515151"}}>{row.especialidade}</TableCell>
                <TableCell align="left" style={{fontSize:16, color:"#515151"}}>{row.nomeMedico}</TableCell>
                <TableCell align="left" style={{fontSize:16, color:"#515151"}}>{row.nomeUbs}</TableCell>
                <TableCell align="center" style={{fontSize:16, color:"#515151"}}><img src={IconDownload}/></TableCell>
              </TableRow>
            ))}

          </TableBody>
        </Table>
      </TableContainer>

    </Container>
    ); 
}