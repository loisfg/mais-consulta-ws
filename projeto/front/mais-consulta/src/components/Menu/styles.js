import styled from "styled-components";
import logo from '../../assets/logo.svg';

export const DivMenu = styled.div`
  height: 100vh;
  background-color: #fff;
  width: 22vw;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: flex-start;
  img {
    height: 180px;
    width: 180px;
    align-self: center;
    justify-self: flex-start;
  }
`
export const DivTab = styled.div`
  height: 60%;
  display: flex;
  flex-direction: column;
`
export const LinkDivTab = styled.div`
  width: 100%;
  display: flex;
  flex-direction: row;
  justify-content:center;
  img {
    height: 3vh;
    width: 3vh;
  }
  &:hover {
    border-left: 5px solid #19A795;
  }
`
export const Tab = styled.button`
  font-size: 17px;
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