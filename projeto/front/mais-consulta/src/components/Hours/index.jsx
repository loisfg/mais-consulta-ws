import React, { useEffect, useState } from "react";
import { Horario, ItemListHour, List } from "./styles";
import api from "../../services/api";

export const Hours = (props) => {
    
    const [listHours, setListHours] = useState(0,0,0);
    
    useEffect(() => {
        async function searchHours() {
            const resp = await api("maisconsulta").get("/agendamento/pegar/horas")
            const aux = resp.data.map(hour => ({hour, selected: false}))
            setListHours(aux)
        }
        searchHours();
    }, []);

    const format = (hora) =>{
        
       if(hora){
        const hourArray = hora.split(":")
        return (
            `${hourArray[0]}:${hourArray[1]}`
        )
       }
    }

    const setSelected = (index) =>{
        const auxiliar = listHours.map((data,i)=>{
           data.selected = i==index ? true : false
           return data
        })
        setListHours(auxiliar)
    }

    return (
        <>
            <Horario>
                <p>Horários disponíveis</p>
                <List>
                    {
                        listHours && listHours.map((data,index) =>
                        
                        <ItemListHour isActive={data.selected} onClick={(e) => {
                            props.setHoraSelecionada(data.hour)
                            setSelected(index)
                            
                        }}>{format(data.hour)}</ItemListHour>
                        )
                    }
                </List>
            </Horario>
        </>
    );
}