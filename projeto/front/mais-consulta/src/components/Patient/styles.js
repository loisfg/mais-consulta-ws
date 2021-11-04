import styled from 'styled-components';

export const Container = styled.div`
  height: 6rem;
  width: 70rem;
  border: ${({isNext}) => isNext? 'var(--white-standard)' : 'var(--light-blue)'} solid 1px;
  background-color: ${({isNext}) => isNext? 'var(--light-blue)' : 'var(--white-standard)'};
  margin: 1rem 0 1rem 0;
  padding: 0 2rem 0 2rem;
  display: flex;
  align-items: center;
  justify-content: space-between;
  border-radius: 5px;
  font-family: 'Rawline';
  font-weight: 500;
  cursor: pointer;
  color: ${({isNext}) => isNext? 'var(--white-standard)' : 'var(--light-blue)'};
  .name_age{
      display: flex;
      align-items: center;
      > label{
        margin: 0 0 0 1.5rem;
      }
  }
`;
