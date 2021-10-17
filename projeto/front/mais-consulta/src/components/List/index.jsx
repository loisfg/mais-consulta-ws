import React from "react";
import {  P, Lista, ListItem, H3, H2, H1 } from "./styles";

const list = [
    {ubs: "UBS Vila Bartira", endereco: "Rua da saudade, 73", tel: "(11)98304-5357"},
    {ubs: "UBS Jardim da alegria", endereco: "Rua João Santos, 27", tel: "(11)98304-5357"},
    {ubs: "UBS Jardim da alegria", endereco: "Rua João Santos, 27", tel: "(11)98304-5357"},
    {ubs: "UBS Jardim da alegria", endereco: "Rua João Santos, 27", tel: "(11)98304-5357"}
];

const listItem = list.map((props) =>
    <ListItem>
        <H3>{props.ubs}</H3>
        <H2>{props.endereco}</H2>
        <H1>tel: {props.tel}</H1>
    </ListItem>
);
export const List  = ({props}) => {

    return(
        <>
            <P>Escolha a unidade desejada</P>
            <Lista>
            {listItem}
            </Lista>
        </>
    );
}