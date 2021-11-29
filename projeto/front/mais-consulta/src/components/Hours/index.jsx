import React, { useEffect, useState } from "react";
import { Horario, ItemListHour, List } from "./styles";
import api from "../../services/api";

export const Hours = ({onClick, listHours}) => {
    //2021-12-31
    var dateSelect = new Date();
    var dd = String(dateSelect.getDate()).padStart(2, '0');
    var mm = String(dateSelect.getMonth() + 1).padStart(2, '0'); 
    var yyyy = dateSelect.getFullYear();
    
    dateSelect = yyyy + '-' + mm + '-' + dd;
    

    const format = (hora) =>{
       if(hora){
        const hourArray = hora.split(":")
        return (
            `${hourArray[0]}:${hourArray[1]}`
        )
       }
    }

    return (
        <>
            <Horario>
                <p>Horários disponíveis</p>
                <List>
                    {
                        listHours && listHours.map((data,index) =>
                        <ItemListHour isActive={data.selected} onClick={() => onClick(index)}>{format(data.hour)}</ItemListHour>
                        )
                    }
                </List>
            </Horario>
        </>
    );
}