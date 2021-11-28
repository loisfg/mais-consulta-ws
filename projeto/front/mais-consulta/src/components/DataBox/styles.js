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
        > h2 {
            color: var(--grey);
            margin: 1rem 0;
        }
        .panel{
            height: 100%;
            width: 90%;
            display: flex;
            justify-content: space-between;
            border: 1.5px solid var(--green-standard);
            border-radius: 5px;
            flex-flow: row wrap;
            .ipt_group{
                display: flex;
                flex-direction: column;
                width: 40%;
                padding: 1rem;
                .side_ipt_group{
                    display: flex;
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
                > div{
                    display: flex;
                    flex-direction: column;
                    margin: 0 1rem 0 0;
                }
            }
                label{
                    font-size: 1.3rem;
                }
                .ipt_data{
                    height: 3rem;
                    width: 100%;
                    max-width: 40rem;
                    margin: 1.2rem 0;
                    border-radius: 0.4rem;
                    border: 0.1rem solid var(--green-standard);
                    outline: none;
                }
            }
            .side_ipt_group{
                display: flex;
                > div {
                    display: flex;
                    flex-direction: column;
                    margin: 1rem 1rem;
                }
            }
            .ipt_checkable_group{
                margin: 1rem 1rem;
                flex-wrap: wrap;
                display: flex;
                align-items: center;
                justify-content: space-around;
                > input {
                    background-color: var(--green-standard);
                }
            }
            .checkbox_select_group{
                display: flex;
                margin: 1rem 1rem;
                width: 100%;
                justify-content: space-evenly;
            }
        }
    }
`;
