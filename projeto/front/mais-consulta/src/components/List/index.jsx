import React, { useState, useEffect } from "react";
import api from "../../services/api";
import { P, Lista, ListItem, H3, H2, H1 } from "./styles";

export const List = ({ text, setListUbs:ubsSelecionada }) => {

    const [listUbs, setListUbs] = useState([]);

    useEffect(() => {
        async function searchListUbs() {
            const resp = await api("maisconsulta").get("/search/ubs")
            setListUbs(resp.data)
        }
        searchListUbs();
    }, []);

    return (
        <>
            <P>{text}</P>
            <Lista>
                {
                     listUbs.map((ubs) => {
                        console.log(listUbs)
                        return(
                        
                        <ListItem key={ubs.idUbs}
                        onClick={(e)=>{
                            ubsSelecionada(ubs.idUbs)
                        }}>
                            <H3>{ubs.nome}</H3>
                            <H2>{ubs.endereco.logradouro + ubs.endereco.rua + ", " + ubs.endereco.numero}</H2>
                            <H1>tel: {ubs.telefone}</H1>
                        
                        </ListItem>
                    )
                    })}
            </Lista>
        </>
    );
}