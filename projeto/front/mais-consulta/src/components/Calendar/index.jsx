import React, { useEffect, useState } from "react";
import { Calendario, Month, Dates, Weekdays, ListItem, Days, ListDays, ListNextDates, ListPrevDates, PrevDate, NextDate } from "./styles";


// };
// document.querySelector(".fas fa-angle-left prev").addEventListener("click", () => {
//     date.setMonth(date.getMonth() - 1);
//     renderCalendar();
// });

// document.querySelector(".fas fa-angle-left next").addEventListener("click", () => {
//     date.setMonth(date.getMonth() + 1);
//     renderCalendar();
// });

// renderCalendar();



// const vdays = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31];

// const listDays = vdays.map((day) =>
//     <ListDays>
//         {day}
//     </ListDays>
// );

// const prevDate = [26, 27, 28, 29, 30];

// const listPrevDates = prevDate.map((pdate) =>
//     <PrevDate>
//         {pdate}
//     </PrevDate>
// );

// const nextDates = [1, 2, 3, 4, 5, 6];

// const listNextDates = nextDates.map((ndate) =>
//     <NextDate>
//         {ndate}
//     </NextDate>
// );

export const Calendar = () => {
    const [days, setDays] =useState([]);
    const date = new Date();
// const renderCalendar = () => {
date.setDate(1);
// console.log(date.getDay);

const monthDays = document.querySelectorAll(".days");

const lastDay = new Date(
    date.getFullYear(),
    date.getMonth() + 1, 0
).getDate();


const prevLastDay = new Date(
    date.getFullYear(),
    date.getMonth(), 0
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

let daysp = "";
let daysn = "";

for (let x = firstDayIndex; x > 0; x--) {
    daysp +=
        <PrevDate>
            {/* {console.log(prevLastDay - x.value + 1)} */}
        </PrevDate>;
}

for (let j = 1; j <= nextDays; j++) {
    daysn +=
        <NextDate>
            {console.log(j)}
        </NextDate>;
}

    useEffect(() =>{
        for (let i = 1; i <= lastDay; i++) {
            if (
                i === new Date().getDate() &&
                date.getMonth() === new Date().getMonth()
            ) {
                console.log("today tem que existir");
                console.log(i);
                //   days += `<div class="today background-color: #19A795;">${i}</div>`;
            } else {
                const newDay = [...days,i];
                setDays(newDay);
                console.log(days);
            }
        }    
    },[])

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
                {days.forEach(day=>{
                    // console.log("abc"+day);
                    <ListDays>{day}</ListDays>
                })}
                {/* {daysn} */}
            </Days>
        </Calendario>
    );
}