import React from "react";
import { Mapa } from './styles'

export const Maps = () => {
    return (
        <Mapa>
            <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d14631.223224096546!2d-46.4551959!3d-23.539486!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0x8466a56349d5dd62!2sUBS%20Itaquera!5e0!3m2!1spt-BR!2sbr!4v1634497152085!5m2!1spt-BR!2sbr" style={{border:0}} allowfullscreen="" loading="lazy"></iframe>
        </Mapa>
    );
}
// allowfullscreen="" loading="lazy"