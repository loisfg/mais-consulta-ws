import React, { useState, useEffect } from "react";
import api from "../../services/api";
import { P, Lista, ListItem, H3, H2, H1, ListItemConteudo, IconItem } from "./styles";
import "./styles"
import Icon from "./Icon";
import iconSet from "./selection.json";
import { iconList } from "icomoon-react";

export const List = ({ text, setListUbs:ubsSelecionada }) => {

    const [listUbs, setListUbs] = useState([]);

    useEffect(() => {
        async function searchListUbs() {
            const resp = await api("maisconsulta").get("/search/ubs")
            // setListUbs(resp.data)
            const aux = resp.data.map(list => ({list, selected: false}))
            setListUbs(aux)
        }
        searchListUbs();
    }, []);

    const setSelected = (index) =>{
        const auxiliar = listUbs.map((data,i)=>{
           data.selected = i==index ? true : false
           return data
        })
        setListUbs(auxiliar)
    }

    return (
        <>
            <P>{text}</P>
            <Lista>
                {
                     listUbs.map((ubs, index) => {
                        console.log(listUbs)
                        return(
                        
                        <ListItem isActive={ubs.selected} key={ubs.idUbs}
                        onClick={(e)=>{
                            ubsSelecionada(ubs.list.idUbs)
                            setSelected(index)
                        }}>
                            <ListItemConteudo>
                                <H3>{ubs.list.nome}</H3>
                                <H2>{ubs.list.endereco.logradouro + ubs.list.endereco.rua + ", " + ubs.list.endereco.numero}</H2>
                                <H1>tel: {ubs.list.telefone}</H1>
                            </ListItemConteudo>
                            <IconItem>
                                <Icon
                                    color = {ubs.selected ? "#19A795" : "#E9E5E5"}
                                    size =  "2rem"
                                    icon="check"
                                />
                            </IconItem>
                        </ListItem>
                    )
                    })}
            </Lista>
        </>
    );
}