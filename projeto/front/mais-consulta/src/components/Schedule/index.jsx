import React, { useEffect, useState } from 'react';
import { Container, Line } from './styles';
import { TextSubtext, Stickers } from '../../components';
import api from '../../services/api';

export const Schedule = ({ data, setInitialDate, setLastDate }) => {
  const weekDays = ['Segunda', 'Terça', 'Quarta', 'Quinta', 'Sexta']
  const [currentWeek, setCurrentWeek] = useState([]) 
  const startCurrentWeek = () => {
    const curr = new Date;
    const weekDays = [];
    for (let index = 1; index <= 5; index++) {
      weekDays.push(
        new Date(curr.setDate(curr.getDate() - curr.getDay() +index))
      )
    }
      setCurrentWeek(weekDays)
  }

  useEffect(() => startCurrentWeek(), [])

  useEffect(() => {
      setInitialDate(currentWeek[0]);
      setLastDate(currentWeek[currentWeek.length - 1]);
  },[currentWeek])

  const formatDate = day => day.getDate()+'.'+Number(day.getMonth() + 1)

  return (
      <Container>
        {
          currentWeek && currentWeek.map((day, index) => (
            <Line>
              <div className='date-appointment-group'>
                <TextSubtext textOne = {weekDays[index]} textTwo={formatDate(day)}/>
              </div>
              <div className='appointment-group'>
                {
                  data.map((info) => 
                    info.diaSemana === weekDays[index] &&
                    <div className='appointment'>
                      <Stickers specialty={info.especialidade} hour={info.horaAtendimento}/>
                    </div> 
                  )
                }
              </div>
            </Line>
          ))
        }
      </Container>
  );
}