import React, { useEffect, useState } from "react";
import { Horario, ItemListHour, List } from "./styles";

export const Hours = (props) => {
    const hours = ["9:00","9:15","9:30","9:45","10:00","10:15","10:30"];
    const [horaSelecionada, setHoraSelecionada] = useState(0);
    const listHours = hours.map((hora) =>
        <ItemListHour onClick={() => {
            props.setHoraSelecionada(hora)
        }}>{hora}</ItemListHour>
    );

    return (
        <>
            <Horario>
                <p>Horários disponíveis</p>
                <List>
                    {listHours}    
                </List>           
            </Horario>
        </>
    );
}