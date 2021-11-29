import React, { useEffect, useState } from "react";
import { Page } from "./styles";
import { DivUsuario, AuxDiv, Content } from "./styles";
import { UserProfilePic, Schedule, WelcomeMessage } from "../../../components";
import { data as oldData} from './data'
import api from "../../../services/api";

export const HomePatient = () => {
  const [ data, setData ] = useState([]);
  const [ initialDate, setInitialDate ] = useState('');
  const [ lastDate, setLastDate ] = useState('');
  useEffect(() => {
    async function getSchedule() {
      const idPaciente = localStorage.getItem('id');
      try {
        if(initialDate && lastDate){
          const res = await api('maisconsulta').get('/paciente/agenda/' + idPaciente, {
            headers:{dtStart: formatDate(initialDate), dtEnd: formatDate(lastDate)}
          });
          setData(res.data)
        }
      } catch (error) {
        console.log(error)
      }
    }
    getSchedule()
  }, [initialDate, lastDate])
  const formatDate = day => {
    let dia;
    if(day.getDate() > 10){
      dia = day.getDate()
    } else{
      dia = '0' + day.getDate();
    }
    return day.getFullYear() + '-' + Number(day.getMonth() + 1) + '-' + dia;
  }
  useEffect(() => console.log(initialDate), [initialDate]);
  useEffect(() => console.log(lastDate), [lastDate]);

  return (
    <Page>
      <AuxDiv>
        <DivUsuario>
          <UserProfilePic/>
        </DivUsuario>
        <Content>
          <WelcomeMessage />
          <Schedule setInitialDate={setInitialDate} setLastDate={setLastDate} data={data}/>
        </Content>
      </AuxDiv>
    </Page>
  );
};
