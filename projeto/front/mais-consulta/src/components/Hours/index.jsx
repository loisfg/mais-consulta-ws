import React, { useEffect, useState } from "react";
import { Horario, ItemListHour, List } from "./styles";
import api from "../../services/api";

export const Hours = (props) => {
    // const hours = new Date().getHours();
    const [listHours, setListHours] = useState(0,0,0);
    const [horaSelecionada, setHoraSelecionada] = useState(0);

    useEffect(() => {
        async function searchHours() {
            const resp = await api("maisconsulta").get("/agendamento/pegar/horas")
            setListHours(resp.data)
        }
        searchHours();
    }, []);

    const format = (hora) =>{
        const hourArray = hora.split(":")
        return (
            `${hourArray[0]}:${hourArray[1]}`
        )
    }

    return (
        <>
            <Horario>
                <p>Horários disponíveis</p>
                <List>
                    {
                        listHours && listHours.map((hora) =>
                        <ItemListHour onClick={() => {
                            props.setHoraSelecionada(hora)
                        }}>{format(hora)}</ItemListHour>
                        )
                    }
                </List>
            </Horario>
        </>
    );
}