import React from "react";
import { RightSide, LeftSide, Page } from "./styles"
import Login from "../../components/FormLogin"

const Initial = () => {
  return (
    <Page>
      <LeftSide>
        <Login></Login>
      </LeftSide>
      <RightSide></RightSide>
    </Page>
  );
};

export default Initial;
