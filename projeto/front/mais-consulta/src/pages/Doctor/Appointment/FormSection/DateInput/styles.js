import styled from 'styled-components';

export const Container = styled.div`
    height: 25vh;
    width: 25vw;
    .title-group{
        display: flex;
        align-items: center;
        padding: 1rem 0;
        > input {
            margin: 1rem 0 0 0;
            height: 1rem;
        }
        > p {
            margin: 1rem 0 0 0.5rem;
            font-size: 1.4rem;
        }
    }
    .styled-input{
        border: var(--light-blue) 0.1rem solid;
        border-radius: 0.3rem;
        height: 3rem;
        width: 30rem;
        background-color: var(--white);
    }
    .ipt-group{
        width: 100%;
        display: flex;
        margin: 0 1rem 0 0;
        input{
            height: 100%;
            width: 85%;
        }
    }
`;