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


  useEffect(() => {
    async function searchListUbs() {
      const resp = await api("maisconsulta").get(`/search/ubs/1`)
      const aux = resp.data.map(list => ({ list, selected: false }))
      setListUbs(aux)
    }
    searchListUbs();
  }, []);

  useEffect(async() => {
    var dados=[];
      const resp = await api("maisconsulta").get(`/export/${idUser}/consultas/info`)
      
      var auxData = resp.data.split('\n')
      
      for (var i = 0; i < auxData.length; i++) {
        var row = [];
        if (auxData[i].length > 1) {
          row.push(auxData[i].split(';')[0])
          row.push(auxData[i].split(';')[1])
          row.push(auxData[i].split(';')[2])
          row.push(auxData[i].split(';')[3])
          row.push(auxData[i].split(';')[4])

          dados.push(row);
        }
      }
    setCsv(dados);
  }, []);

  

  useEffect(async() => {
    var dados=[];
      const resp = await api("maisconsulta").get(`/export/${props.idAgendamento}/${idUser}/consulta/info`)
      
      var auxData = resp.data.split('\n')
      
      for (var i = 0; i < auxData.length; i++) {
        var row = [];
        if (auxData[i].length > 1) {
          row.push(auxData[i].split(';')[0])
          row.push(auxData[i].split(';')[1])
          row.push(auxData[i].split(';')[2])
          row.push(auxData[i].split(';')[3])
          row.push(auxData[i].split(';')[4])

          dados.push(row);
        }
      }
    setCsv(dados);
  }, []);


  const specialties = [
    { value: 'Acupuntura', label: 'Acupuntura' },
    { value: 'Alergia e Imunologia', label: 'Alergia e Imunologia' },
    { value: 'Anestesiologia', label: 'Anestesiologia' },
    { value: 'Angiologia', label: 'Angiologia' },
    { value: 'Cancerologia', label: 'Cancerologia' },
    { value: 'Cardiologia', label: 'Cardiologia' },
    { value: 'Cirurgia Torácica', label: 'Cirurgia Torácica' },
    { value: 'Geriatria', label: 'Geriatria' },
    { value: 'Ginecologia e Obstetrícia', label: 'Ginecologia e Obstetrícia' },
    { value: 'Neurologia', label: 'Neurologia' },
    { value: 'Nutrologia', label: 'Nutrologia' },
    { value: 'Oftalmologia', label: 'Oftalmologia' },
    { value: 'Ortopedia e Traumatologia', label: 'Ortopedia e Traumatologia' },
    { value: 'Psiquiatria', label: 'Psiquiatria' },
    { value: 'Radiologia e Diagnóstico por Imagem', label: 'Radiologia e Diagnóstico por Imagem' },
    { value: 'Radioterapia', label: 'Radioterapia' },
    { value: 'Reumatologia', label: 'Reumatologia' },
    { value: 'Urologia', label: 'Urologia' },
    { value: 'Áreas de Atuação reconhecidas', label: 'Áreas de Atuação reconhecidas' },
    { value: 'Administração em Saúde', label: 'Administração em Saúde' },
    { value: 'Alergia e Imunologia Pediátrica', label: 'Alergia e Imunologia Pediátrica' },
    { value: 'Angiorradiologia e Cirurgia Endovascular', label: 'Angiorradiologia e Cirurgia Endovascular' },
    { value: 'Atendimento ao queimado', label: 'Atendimento ao queimado' },
    { value: 'Cardiologia Pediátrica', label: 'Cardiologia Pediátrica' },
    { value: 'Cirurgia Videolaparoscópica', label: 'Cirurgia Videolaparoscópica' },
    { value: 'Medicina Paliativa', label: 'Medicina Paliativa' },
    { value: 'Medicina Tropical', label: 'Medicina Tropical' },
    { value: 'Nefrologia Pediátrica', label: 'Nefrologia Pediátrica' },
    { value: 'Neonatologia', label: 'Neonatologia' },
    { value: 'Neurofisiologia Clínica', label: 'Neurofisiologia Clínica' },
    { value: 'Pneumologia Pediátrica', label: 'Pneumologia Pediátrica' },
    { value: 'Psicogeriatria', label: 'Psicogeriatria' },
    { value: 'Psicoterapia', label: 'Psicoterapia' },
    { value: 'Psiquiatria da Infância e Adolescência', label: 'Psiquiatria da Infância e Adolescência' },
    { value: 'Psiquiatria Forense', label: 'Psiquiatria Forense' },
    { value: 'Radiologia Intervencionista e Angiorradiologia', label: 'Radiologia Intervencionista e Angiorradiologia' },
    { value: 'Reumatologia Pediátrica', label: 'Reumatologia Pediátrica' },
    { value: 'Sexologia', label: 'Sexologia' },
    { value: 'Transplante de Medula Óssea', label: 'Transplante de Medula Óssea' },
    { value: 'Ultrassonografia em Ginecologia e Obstetrícia', label: 'Ultrassonografia em Ginecologia e Obstetrícia' },

  ]

  const defaultTheme = createTheme();
  const theme = createTheme({
    components: {
      // Name of the component
      MuiButton: {
        variants: [
          {
            props: { variant: 'tam' },
            style: {
              textTransform: 'none',
              color: '#515151',
              height: '2vh',
              fontSize: '16px'
            },
          },
        ],
      },
    },

  });


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
            {/* <CSVLink
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
                data={csv}
                filename={"agendamentos +Consulta.csv"}
                target="_blank"
              >
                Baixar Selecionados
              </CSVLink> */}

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
              >
                Baixar todos
              </CSVLink>
            </ButtonsExport>
          </BoxButtons>
        </LeftSide>

        <RightSide>

          <Container>
            <SchedulingTwo onClick={setIdAgendamento} idAgendamento={idAgendamento}/>
          </Container>

        </RightSide>

      </DivComboBox>

    </Page>
  );
}

