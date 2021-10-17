import styled from "styled-components";
import { Link } from 'react-router-dom'

export const Container = styled.div`
  height: 100vh;
  width: 23rem;
  display: flex;
  position: fixed;
  flex-direction: column;
  background-color: var(--white-standard);
  border-right: 3px solid var( --light-grey);
`
export const SpaceLogo = styled.div`
  height: 20vh;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 0 2rem; 
  img{ 
    width: 100%;
    min-width: 15rem;
  }
  `

export const ListOfTabs = styled.ul`
  height: 80vh;
  display: flex;
  flex-direction: column;
  justify-content: center;
  `
export const Tab = styled.li`
  cursor:pointer; 
  padding: 0 0.1rem;
  height: 5rem;
  width: 100%;
  margin-bottom: 4rem;
  display: flex;
  justify-content: space-around;
  align-content: space-between;
  a {
    width: 100%;
    display: flex;
    align-items: center;
    text-decoration: none;
    img {
      width: 3rem;
      margin-left: 2rem;
    }
    &:hover {
      border-left: 5px solid var(--green-standard);
    }
  }
  
`

export const Redirect = styled(Link)`
  border-left: ${({isActive}) => isActive ? '5px solid var(--green-standard)' : 'none'};
`

export const Text = styled.span`
  font-size: 1.6rem;
  color: ${({isActive}) => isActive ? 'var(--green-standard)' : 'var(--grey)' };
  font-weight: 600;
  padding-left: 2rem;
`