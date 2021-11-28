import styled from 'styled-components';

export const Container = styled.div`
    .title-group{
        display: flex;
        align-items: center;
        font-weight: 500;
        font-size: 1.3rem;
        padding: 1rem 0;
        > input {
            margin: 0 1rem 0 0;
        }
    }
    .styled-input{
        border: var(${({color}) => color}) 0.1rem solid;
        border-radius: 0.3rem;
        height: 3rem;
        background-color: var(--white);
        width: 100%;
        max-width: 40rem;
    }
`;