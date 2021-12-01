import styled from 'styled-components';

export const Container = styled.div`
    height: 100vh;
    width: 100%;
    display: flex;
    flex-direction: column;
    font-family: 'Rawline';
    .container_profile_pic{
        display: flex;
        align-items: flex-end;
        justify-content: end;
        height: 10%;
        width: 100%;
        padding: 0 3rem 0 0;
    }
    .form_group{
        width: 100%;
        margin-bottom: 5rem;
        display: flex;
        flex-direction: column;
        .textfield{
            width: 100%;
            padding: 0 0 0 3rem;
            display: flex;
            flex-direction: column;
            h1{
                color: var(--grey);
                font-size: 2.7rem;
                font-weight: 600;
                margin: 0 0 0.7rem 0;
            }
        }
    }
    .patient_group{
        display: flex;
        width: 100%;
        overflow-y: au  to;
        flex-wrap: wrap;
    }
`;
