import React, { useState, useEffect } from "react";
import api from "../../services/api";
import { P, Lista, ListItem, H3, H2, H1 } from "./styles";

export const List = ({ text }) => {

    const [listUbs, setListUbs] = useState([]);

    useEffect(() => {
        async function searchListUbs() {
            const resp = await api("maisconsulta").get("/search/ubs")
            setListUbs(resp.data)
            console.log("log", resp.data);
        }
        searchListUbs();
    }, []);

    return (
        <>
            <P>{text}</P>
            <Lista>
                {
                    listUbs.map((listUbs) => (
                        <ListItem>
                            <H3>{listUbs.nome}</H3>
                            <H2>{listUbs.endereco.logradouro + listUbs.endereco.rua + ", " + listUbs.endereco.numero}</H2>
                            <H1>tel: {listUbs.telefone}</H1>
                        </ListItem>
                    ))}
            </Lista>
        </>
    );
}