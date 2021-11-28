import { style } from "@material-ui/system";
import styled from "styled-components";
import LocalizationProvider from '@mui/lab/LocalizationProvider';
import DatePicker from '@mui/lab/DatePicker';

export const Page = styled.div`
height: 100vh;
`
export const DivUsuario = styled.div`
height: 11%;
width: 100%;
background-color: #fff;
display: flex;
justify-content: flex-end;
padding: 15px 35px 0 0;
`;

export const DivComboBox = styled.div`
height: 80%;
width: 100%;
display: flex;
flex-direction: column;
align-items: center;
justify-content: center;
`

export const P = styled.p`
color:#515151;
font-size: 16px;
margin-top:8px;
`
export const Filter = styled.div`
height:4vh;
width:28%;
display: flex;
flex-direction: column;
`

export const LeftSide = styled.div`
width: 92%;
height: 15%;
display: flex;
flex-direction: column;
`
export const BoxButtons = styled.div`
width:100%;
height:80%;
display: flex;
flex-direction: row;
justify-content: space-between;
align-items: flex-start;
`

export const ButtonsSelect = styled.div`
height: 100%;
width: 50%;
display:flex;
align-items: center;
justify-content: space-between;
flex-direction: row;
`
export const ButtonsExport = styled.div`
height: 100%;
width: 28%;
display:flex;
align-items: center;
justify-content: space-between;
flex-direction: row;
`

export const RightSide = styled.div`
width: 100%;
height: 84%;
display: flex;
justify-content: center;
align-items: center;
`

export const Container = styled.div`
width: 100%;
height: 90%;
display: flex;
justify-content: center;
align-items: center;
padding-top: 10px;
`

export const H3 = styled.h3`
font-size: 13px;
color: #19A795;
`