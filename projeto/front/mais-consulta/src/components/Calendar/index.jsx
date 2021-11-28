import React, { useEffect, useState } from "react";
import { P, Calendario, Month, Dates, Weekdays, ListItem, Days, ListDays } from "./styles";
import Next from '../../assets/voltar.png';
import Back from '../../assets/proximo.png';
import { generate } from './daysGenerate';

export const Calendar = (props) => {
    const [data, setData] = useState({})

    useEffect(() => setData(generate()), [])

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
                    <ListDays weight='light' style="pointer-events:none;">{day}</ListDays>
                )}
                {data.days && data.days.map(day =>
                    <ListDays weight='bold' isToDay={data.currentDay== day} onClick={() => {
                        props.setdaySelected(`${new Date().getFullYear()}-${new Date().getMonth()+1}-${day}`)
                    }} >{day}</ListDays>
                )}
                {data.nextDays && data.nextDays.map(day =>
                    <ListDays weight='light'>{day}</ListDays>
                )}
            </Days>
        </Calendario>
    );
}