import React, { useEffect, useState } from "react";
import { Calendario, Month, Dates, Weekdays, ListItem, Days, ListDays } from "./styles";

export const Calendar = () => {
    const [days, setDays] =useState([])
    const [backDays, setBackDays] =useState([])
    const [nextDays, setNextDays] =useState([])
    const [isToDays, setToDays] =useState()

    const date = new Date();
    date.setDate(1);

    const lastDay = new Date(
        date.getFullYear(),
        date.getMonth() + 1, 0
    ).getDate();


    const firstDayIndex = date.getDay();

    const lastDayIndex = new Date(
        date.getFullYear(),
        date.getMonth(), + 1
    ).getDate();

    // const nextDays = 7 - lastDayIndex - 1;

    const months = [
        "Janeiro",
        "Fevereiro",
        "Março",
        "Abril",
        "Maio",
        "Junho",
        "Julho",
        "Agosto",
        "Setembro",
        "Outubro",
        "Novembro",
        "Dezembro",
    ];

    // document.querySelectorAll("h1").innerHTML = months[date.getMonth()];

    // document.querySelectorAll("p").innerHTML = new Date().toDateString();
    useEffect(() => {
        const aux_array = []
        for (let i = 1; i <= lastDay; i++) {
            if (
                i === new Date().getDate() &&
                date.getMonth() === new Date().getMonth()
            ) {
                aux_array.push(i)
                setToDays(i);
                
            } else {
                aux_array.push(i)
            }
        }    
        const anteriores = [27, 28, 29, 30, 31]
        const proximos = [1, 2, 3, 4, 5, 6]
        
        setBackDays([...anteriores]);
        setDays([...aux_array]);
        setNextDays([...proximos]);
    },[])

    useEffect(() => console.log('days', days), [days])

    const weekdays = ["Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sáb"];

    const listItem = weekdays.map((weekday) =>
        <ListItem>
            {weekday}
        </ListItem>
    );

    return (
        <Calendario>
            <Month>
                <i class="fas fa-angle-left prev"></i>
                <Dates>
                    <h1>{months[date.getMonth()]}</h1>
                    <p>{new Date().toDateString()}</p>
                </Dates>
                <i class="fas fa-angle-right next"></i>
            </Month>
            <Weekdays>
                {listItem}
            </Weekdays>
            <Days>
                {backDays.map(day=>
                    <ListDays weight='light'>{day}</ListDays>
                )}
                {days.map(day=>
                    <ListDays weight='bold' isToDay={isToDays==day} >{day}</ListDays>
                )}
                {nextDays.map(day=>
                    <ListDays weight='light'>{day}</ListDays>
                )}
            </Days>
        </Calendario>
    );
}