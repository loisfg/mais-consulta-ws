import styled from 'styled-components';

export const Container = styled.div`
    width: 16vw;
    .title-group{
        display: flex;
        align-items: center;
        font-weight: 500;
        padding: 1rem 0;
        > input {
            margin: 0 1rem 0 0;
        }
    }
    .styled-input{
        border: var(--light-blue) 0.1rem solid;
        border-radius: 0.3rem;
        height: 3rem;
        width: 30rem;
        background-color: var(--white);
    }
`;