import React, { useEffect, useState } from "react";
import { Calendario, Month, Dates, Weekdays, ListItem, Days, ListDays, ListNextDates, ListPrevDates, PrevDate, NextDate } from "./styles";

export const Calendar = () => {
    const [days, setDays] =useState([])
    const [backDays, setBackDays] =useState([])
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

    const nextDays = 7 - lastDayIndex - 1;

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

    document.querySelectorAll("h1").innerHTML = months[date.getMonth()];

    document.querySelectorAll("p").innerHTML = new Date().toDateString();

    useEffect(() => {
        const aux_array = []
        for (let i = 1; i <= lastDay; i++) {
            if (
                i === new Date().getDate() &&
                date.getMonth() === new Date().getMonth()
            ) {
                console.log("today tem que existir");
                //   days += `<div class="today background-color: #19A795;">${i}</div>`;
            } else {
                aux_array.push(i)
            }
        }    
        const anteriores = [27, 28, 29]
        setBackDays([...anteriores])
        setDays([...aux_array]);
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
                    <h1></h1>
                    <p></p>
                </Dates>
                <i class="fas fa-angle-right next"></i>
            </Month>
            <Weekdays>
                {listItem}
            </Weekdays>
            <Days>
                {/* {daysp} */} 
                {backDays.map(day=>
                    <ListDays weight='light'>{day}</ListDays>
                )}
                {days.map(day=>
                    <ListDays weight='bold'>{day}</ListDays>
                )}
                {/* {daysn} */}
            </Days>
        </Calendario>
    );
}