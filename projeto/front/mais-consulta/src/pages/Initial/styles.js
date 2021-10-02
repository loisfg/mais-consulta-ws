import styled from "styled-components";
import photo from "../../assets/initialPhoto.jpg";

export const Page = styled.section`
  display: flex;
  height: 100vh;
  width: 100vw;
`;

export const Logo = styled.div`
display: flex;
justify-content: flex-end;
align-items: center;
height: 300px;
`;

export const RightSide = styled.div`
  height: 100%;
  width: 50%;
  opacity: 87%;
  background: url(${photo}) center no-repeat;
  background-size: cover;
`;

export const LeftSide = styled.div`
  height: 100%;
  width: 50%;
  background-size: cover;
`;
