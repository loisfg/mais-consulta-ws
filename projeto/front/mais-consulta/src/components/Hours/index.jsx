import React from "react";
import { Horario, ItemListHour, List } from "./styles";

export const Hours = () => {
    const hours = ["9:00","9:15","9:30","9:45","10:00","10:15","10:30"];
    // const [isHour, setHour] =useState([])

    const listHours = hours.map((hora) =>
        <ItemListHour>{hora}</ItemListHour>
    );

    // useEffect(() => {
    //     const hours = [
    //         {select: false,hour: "9:00"},
    //         {select: false,hour: "9:10"},
    //         {select: false,hour: "9:20"}
    //     ];
    //     const listHours = hours.map((props) =>
    //         <ItemListHour>{props.hour}</ItemListHour>
    //     );        
    // });

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