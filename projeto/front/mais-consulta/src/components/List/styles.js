import styled from "styled-components";

export const P = styled.p`
    color:#515151;
    font-weight: 600;
    font-size: 16px;
    margin-top: 0;
    margin-bottom:8px;
`
export const Lista = styled.div`
    height: 100%;
    width: 100%;
    display: block;
    flex-direction: column;
    justify-content: flex-start;
    overflow-y: auto;
    scroll-behavior: smooth;
    align-items: center;
    ::-webkit-scrollbar {
      width: 8px;
}

/* Track */
::-webkit-scrollbar-track {
  background: #f1f1f1; 
}
 
/* Handle */
::-webkit-scrollbar-thumb {
  background: #19A795; 
  border-radius: 50px;
}

/* Handle on hover */
::-webkit-scrollbar-thumb:hover {
  background: #179989; 
}
`
export const ListItem = styled.div`
    width: 90%;
    height: 16vh;
    border-bottom: 2px solid #19A795;
    display: flex;
    flex-direction: row;
    justify-content: space-evenly;
    align-items: flex-start;
    margin: 0px 0px 0px 0px;
    cursor: pointer;
    /* background-color:${({isActive}) => isActive  ? "#19A795" : "#fff"}; */
   
`
export const IconItem = styled.div`
  width: 20%;
  height:100%;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
`

export const ListItemConteudo = styled.div`
    width: 80%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
    align-items: flex-start;
    cursor: pointer;
`

export const H3 = styled.div`
    color: #19A795;
    font-size: 18px;
    font-weight: bold;
    font-family: Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
`
export const H2 = styled.div`
    color: #515151;
    font-size: 16px;
    font-weight: 700;
    font-family: Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;

`
export const H1 = styled.div`
    color: #515151;
    font-size: 16px;
    font-weight: lighter;
    font-family: Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;

`