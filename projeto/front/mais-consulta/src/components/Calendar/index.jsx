import React, { useEffect, useState } from "react";
import { P, Calendario, Month, Dates, Weekdays, ListItem, Days, ListDays } from "./styles";
import Next from '../../assets/voltar.png';
import Back from '../../assets/proximo.png';
import { generate } from './daysGenerate';
import swal from 'sweetalert';

export const Calendar = (props) => {
    const [data, setData] = useState({})

    useEffect(() => setData(generate()), [])


    const [color, setColor] = useState([]);

    const setColorSelecionado = (index) =>{
        const auxiliar = data.days.map((data,i)=>{
           data.selected = i==index ? true : false
           return data
        })
        setColor(auxiliar);
    }

    return (
        <Calendario>
            <P>Selecione a data do agendamento</P>
            <Month>
                <img class="next" src={Next} alt="" />
                <Dates>
                    <h1>{data.mounth}</h1>
                </Dates>
                <img class="back" src={Back} alt="" />
            </Month>
            <Weekdays>
                {data.weekdays && data.weekdays.map((weekday) =>
                    <ListItem>
                        {weekday}
                    </ListItem>
                )}
            </Weekdays>
            <Days>
                {data.previousDays && data.previousDays.map(day =>
                    <ListDays weight='light' onclick={()=> {
                        swal("Você não pode selecionar uma data anterior!", {
                            buttons: false,
                            timer: 3000,
                        });
                    }}>{day}</ListDays>
                )}
                {data.days && data.days.map((index, day) =>
                    <ListDays weight='bold' isToDay={data.currentDay== day} onClick={() => {
                        const aux = day;
                        if(day < new Date().getDate()){
                            swal("Você não pode selecionar uma data anterior!", {
                                buttons: false,
                                icon: "error",
                                timer: 3000,
                            });
                        }
                        else{
                            props.setdaySelected(`${new Date().getFullYear()}-${new Date().getMonth()+1}-${day}`)
                            console.log(props.setdaySelected)
                        }
                        // setColorSelecionado(index)

                    }} >{day}</ListDays>
                )}
                {data.nextDays && data.nextDays.map(day =>
                    <ListDays weight='light'>{day}</ListDays>
                )}
            </Days>
        </Calendario>
    );
}