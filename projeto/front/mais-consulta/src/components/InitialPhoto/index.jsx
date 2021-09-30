import React from "react";
import photo from "../../assets/initialPhoto.svg";
import { Img, Div } from "./styles.js";

const InitialPhoto = () => {
  return (
    <>
      <Div>
        <Img src={photo} draggable={false} alt={"imagem de medico"} />
      </Div>
    </>
  );
};

export default InitialPhoto;
