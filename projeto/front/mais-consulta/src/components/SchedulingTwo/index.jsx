import React from 'react';
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
import Select from 'react-select';

export const SchedulingTwo = () => {

  // const [history, sethistory] = useState([]);

    // useEffect(() => {
    //     async function searchHistory() {
    //         const resp = await api("maisconsulta").get("")
    //         sethistory(resp.data)                                                           
    //     }
    //     searchHistory();
    // }, []);

  function createData(data, hora,  consulta, medico, local) {
    return { data, hora,  consulta, medico, local };
  }

  const label = { inputProps: { 'aria-label': 'Checkbox demo' } };

  const rows = [
    createData('Frozen yoghurt', 159, 6.0, 24, 4.0),
    createData('Ice cream sandwich', 237, 9.0, 37, 4.3),
    createData('Eclair', 262, 16.0, 24, 6.0),
    createData('Cupcake', 305, 3.7, 67, 4.3),
    createData('Gingerbread', 356, 16.0, 49, 3.9),
  ];


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

            {rows.map((row) => (
              <TableRow style={{fontSize:18}}
                key={row.data}
                sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
              >
                <TableCell align="center">
                  <Checkbox
                    {...label}
                    sx={{ '& .MuiSvgIcon-root': { fontSize: 24 } }} style={{color:"#19A795",}}/>
                </TableCell>
                <TableCell align="center" style={{fontSize:16, color:"#515151"}}>{row.data}</TableCell>
                <TableCell align="center" style={{fontSize:16, color:"#515151"}}>{row.hora}</TableCell>
                <TableCell align="left" style={{fontSize:16, color:"#515151"}}>{row.consulta}</TableCell>
                <TableCell align="left" style={{fontSize:16, color:"#515151"}}>{row.medico}</TableCell>
                <TableCell align="left" style={{fontSize:16, color:"#515151"}}>{row.local}</TableCell>
                <TableCell align="center" style={{fontSize:16, color:"#515151"}}><img src={IconDownload}/></TableCell>
              </TableRow>
            ))}

          </TableBody>
        </Table>
      </TableContainer>

    </Container>
    ); 
}