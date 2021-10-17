import React from 'react';
import { P, Especialidade } from "./styles";

export const Specialty = ({ nameSpecialty }) => {
    return (
        <>
            <P>Especialidade</P>
            <Especialidade>
                {nameSpecialty}
            </Especialidade>
        </>
    );
}