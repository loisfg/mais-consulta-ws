import React from "react";
import { P, Lista, ListItem, H3, H2, H1 } from "./styles";

// const list = [
//     {ubs: "UBS Vila Bartira", endereco: "Rua da saudade, 73", tel: "(11)98304-5357"},
//     {ubs: "UBS Jardim da alegria", endereco: "Rua João Santos, 27", tel: "(11)98304-5357"},
//     {ubs: "UBS Jardim da alegria", endereco: "Rua João Santos, 27", tel: "(11)98304-5357"},
//     {ubs: "UBS Jardim da alegria", endereco: "Rua João Santos, 27", tel: "(11)98304-5357"}
// ];

// const listItem = list.map((props) =>
//     <ListItem onClick={() => {
//         alert(props + "selecionado")
//     }}>
//         <H3>{props.ubs}</H3>
//         <H2>{props.endereco}</H2>
//         <H1>tel: {props.tel}</H1>
//     </ListItem>
// );
export const List = ({ text }) => {

    const [listUbs, setListUbs] = useState([]);

    useEffect(() => {
      async function searchListUbs() {
        const resp = await api.get("")
        setListUbs(resp.data)
        console.log("log", resp.data);
      }
      searchListUbs();
    },[]);
  
    return (
        <>
            <P>{text}</P>
            <Lista>
                <ListItem onClick={() => {
                    alert(listUbs + "selecionado")
                }}>
                    <H3>{listUbs.ubs}</H3>
                    <H2>{listUbs.endereco}</H2>
                    <H1>tel: {listUbs.tel}</H1>
                </ListItem>
            </Lista>
        </>
    );
}