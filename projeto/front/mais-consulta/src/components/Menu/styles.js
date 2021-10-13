import styled from "styled-components";

export const DivMenu = styled.div`
  height: 100vh;
  background-color: #fff;
  width: 19vw;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: flex-start;
  border-right: 3px solid #B0B0B0;
  img {
    height: 35%;
    width: 180px;
    align-self: center;
    justify-self: center;
  }
`
export const DivTab = styled.div`
  height: 66%;
  width: 100%;
  display: flex;
  flex-direction: column;
`
export const LinkDivTab = styled.div`
  width: 100%;
  display: flex;
  flex-direction: row;
  justify-content:center;
  img {
    height: 3.5vh;
    width: 3.5vh;
  }
  &:hover {
    border-left: 5px solid #19A795;
  }
  
`
export const Tab = styled.button`
  font-size: 16px;
  border-style: none;
  background:white;
  height:100%;
  text-align: start;
  color: #515151;
  width: 70%;
  margin: 0 0 40px 0px;
  padding-left: 28px;
  font-weight: 600;
  cursor:pointer; 
  &:hover {
    color: #19A795;
  }
` 