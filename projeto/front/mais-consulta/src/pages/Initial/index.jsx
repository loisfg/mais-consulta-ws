import React, { useState } from "react";
import Login from "../../components/Login";
import SignUp from "../../components/SignUp";
import InitialPhoto from "../../components/InitialPhoto";

const Initial = () => {
  const [window, setWindow] = useState(0);

  return (
    <>
      <section className="container">
        <section className="form"></section>
        <h1>aaaaa</h1>
        <InitialPhoto />
      </section>
    </>
  );
};

export default Initial;
