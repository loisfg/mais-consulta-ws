import styled from 'styled-components';
import { TextField } from "@material-ui/core";

export const Container = styled.section`
    height: 100%;
    width: 70%;
    display: flex;
    align-items: center;
    justify-content: center;
    margin: 0px 3rem;
    .box {
        width: 150rem;
        overflow-y: auto;
        > h2 {
            color: var(--grey);
            margin: 1rem 0;
        }
        .panel{
            height: 100%;
            width: 90%;
            display: flex;
            justify-content: space-between;
            border: 1.5px solid #19A795;
            border-radius: 5px;
            flex-flow: row wrap;
            .ipt_group{
                display: flex;
                flex-direction: column;
                width: 40%;
                padding: 1rem;
                .side_ipt_group{
                    display: flex;
                    #ipt_logradouro{
                        height: 3rem;
                        width: 30rem;
                        margin: 1.2rem 0;
                        border-radius: 0.4rem;
                        border-color: none;
                        border: 0.1rem solid var(--green-standard);
                    }
                    #ipt_numero{
                        height: 3rem;
                        width: 10rem;
                        margin: 1.2rem 0;
                        border-radius: 0.4rem;
                        border-color: none;
                        border: 0.1rem solid var(--green-standard);
                    }
                    #ipt_bairro{
                        height: 3rem;
                        width: 12rem;
                        margin: 1.2rem 0;
                        border-radius: 0.4rem;
                        border-color: none;
                        border: 0.1rem solid var(--green-standard);
                    }
                div{
                    display: flex;
                    flex-direction: column;
                    margin: 0 1rem 0 0;
                }
            }
                label{
                    font-size: 1.5rem;
                }
                .ipt_data{
                    height: 3rem;
                    width: 23rem;
                    margin: 1.2rem 0;
                    border-radius: 0.4rem;
                    border-color: none;
                    border: 0.1rem solid var(--green-standard);
                }
            }
        }
    }
`;


export const H2 = styled.div`
color: black;
opacity: 70%;
font-size: 12px;
font-weight: 600;
font-family: Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;

`
export const PanelTwo = styled.div`
height: 100%;
width: 90%;
display: flex;
border: 1.5px solid #19A795;
border-radius: 5px;


`
export const H3 = styled.div`
color: black;
opacity: 70%;
font-size: 16px;
font-weight: 600;
font-family: Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
padding: 23px 0 0 0 ;

`
