import styled from "styled-components";
import logo from '../../assets/logo.svg';

export const DivMenu = styled.div`
  height: 100vh;
  background-color: #fff;
  width: 20vw;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: flex-start;
  img {
    height: 150px;
    width: 150px;
    align-self: center;
    justify-self: flex-start;
  }
`
export const DivTab = styled.div`
  height: 60%;
  display: flex;
  flex-direction: column;
`
export const Tab = styled.button`
  font-size: 13px;
  border-style: none;
  background-color: #fff;
  text-align: start;
  color: #19A795;
  margin: 0 0 35px 27px;
  font-weight: 600;
`