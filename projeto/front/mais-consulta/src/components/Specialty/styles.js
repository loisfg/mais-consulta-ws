import styled from "styled-components";
import { TextField } from "@material-ui/core";

export const P = styled.p`
    color:#515151;
    font-weight: 600;
    margin-bottom: 8px;
    font-size: 16px;
    margin:0;
`
export const Especialidade = styled(TextField)`
    height: 2.5rem !important;
    width: 35rem !important;
    font-size: 16rem !important;
    text-align: initial;
    > div {
        font-size: 1.8rem;
    }
    margin-bottom: 2rem !important;
    input:disabled {
        border-bottom: 2px solid #19A795 !important;
        -webkit-text-fill-color: var(--grey) !important;
    }
`