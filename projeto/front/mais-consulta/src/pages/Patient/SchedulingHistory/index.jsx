import React, { useState, useEffect } from "react";
import { Page } from "./styles";
import api from "../../../services/api";
import { ButtonsExport, ButtonsSelect, DivUsuario, DivComboBox, LeftSide, RightSide, Container, P, BoxButtons, Filter } from './styles';
import { UserProfilePic, WelcomeMessageTwo, SchedulingTwo, Button, ButtonTwo } from '../../../components'
import Select from 'react-select';
import TextField from '@mui/material/TextField';
import AdapterDateFns from '@mui/lab/AdapterDateFns';
import LocalizationProvider from '@mui/lab/LocalizationProvider';
import DatePicker from '@mui/lab/DatePicker';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { CSVLink } from 'react-csv'

export const SchedulingHistory = ( props, usuario ) => {

  const [value, setValue] = useState(null);
  const [specialty, setSpecialty] = useState();
  const [ubsSelect, setUbsSelect] = useState();
  const [idAgendamento, setIdAgendamento] = useState();
  const idUser = localStorage.getItem("id");
  const [listUbs, setListUbs] = useState([]);
  const [csv, setCsv] = useState([]);
  const [csvid, setCsvId] = useState([]);

  const idAgen =sessionStorage.getItem("idAgend"); 
  console.log("id ag:", idAgen)
  useEffect(() => {
    async function searchListUbs() {
      const resp = await api("maisconsulta").get(`/search/ubs/1`)
      const aux = resp.data.map(list => ({ list, selected: false }))

      setListUbs(aux)
    }
    searchListUbs();
  }, []);

  function getAgendamentosId() {
    api("maisconsulta").get(`/export/${sessionStorage.getItem("idAgend")}/${idUser}/consulta/info`)
    .then((res) => {
      setCsvId(res.data);
    })
    .catch((error) => {
      console.log(error);
    })
  } 


  function getAgendamentos() {
    api("maisconsulta").get(`/export/${idUser}/consultas/info`)
      .then((res) => {
        setCsv(res.data);
      })
      .catch((error) => {
        console.log(error);
      })
    }    


  const specialties = [
    { value: 'Acupuntura', label: 'Acupuntura' },
    { value: 'Alergia e Imunologia', label: 'Alergia e Imunologia' },
    { value: 'Anestesiologia', label: 'Anestesiologia' },
    { value: 'Angiologia', label: 'Angiologia' },
    { value: 'Cancerologia', label: 'Cancerologia' },
    { value: 'Cardiologia', label: 'Cardiologia' },
    { value: 'Cirurgia Torácica', label: 'Cirurgia Torácica' },
    { value: 'Sexologia', label: 'Sexologia' },
    { value: 'Transplante de Medula Óssea', label: 'Transplante de Medula Óssea' },
    { value: 'Ultrassonografia em Ginecologia e Obstetrícia', label: 'Ultrassonografia em Ginecologia e Obstetrícia' },

  ]

  return (
    <Page>
      <DivUsuario>
        <UserProfilePic />
      </DivUsuario>

      <DivComboBox>
        <LeftSide>
          <WelcomeMessageTwo text="Histórico de agendamentos" />

          <BoxButtons>
            {/* <ButtonsSelect>
              <Filter>
                <P>Especialidade</P>
                <Select options={specialties} />
              </Filter>
              <Filter>
                <P>Data da consulta</P>
                <LocalizationProvider dateAdapter={AdapterDateFns}>
                  <DatePicker
                    label="Selecione uma data"
                    value={value}
                    onChange={(newValue) => {
                      setValue(newValue);
                    }}
                    renderInput={(params) => <TextField {...params} />}
                  />
                </LocalizationProvider>
              </Filter>
              <Filter>
                <P>Posto de saúde</P>
                <Select options={listUbs} />
              </Filter>
            </ButtonsSelect> */}

            <ButtonsExport>
            <CSVLink
                style={{
                  width: "170px",
                  fontSize: "14px",
                  borderRadius: "5px",
                  backgroundColor: "#FFFFFF",
                  color: "#515151",
                  fontFamily: "Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif",
                  cursor: "pointer",
                  border: "#19A795 1px solid",
                  height: "50px",
                  textAlign: "center",
                  textDecoration: "none",
                  padding: "1.7rem 1.8rem",
                }}
                data={csvid}
                filename={"agendamento.csv"}
                target="_blank"
                onClick={getAgendamentosId()}
              >
                Baixar Selecionados
              </CSVLink>

              <CSVLink
                style={{
                  fontSize: "16px",
                  borderStyle: "none",
                  borderRadius: "5px",
                  color: "#FFFFFF",
                  fontFamily: "Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif",
                  backgroundColor: "#19A795",
                  cursor: "pointer",
                  width: "150px",
                  height: "50px",
                  textAlign: "center",
                  textDecoration: "none",
                  padding: "1.7rem 1.8rem",
                }}
                data={csv}
                filename={"agendamentos +Consulta.csv"}
                target="_blank"
                onClick={getAgendamentos()}
              >
                Baixar todos
              </CSVLink>
            </ButtonsExport>
          </BoxButtons>
        </LeftSide>

        <RightSide>

          <Container>
            <SchedulingTwo onClick={setIdAgendamento}/>
          </Container>

        </RightSide>

      </DivComboBox>

    </Page>
  );
}

