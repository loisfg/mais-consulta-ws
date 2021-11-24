import styled from 'styled-components';
import OutlinedInput from '@mui/material/OutlinedInput';

export const Container = styled.div`
    display: flex;
    flex-direction: column;
    .title-group{
        padding: 1rem 1rem 0 0; 
        display: flex;
        align-items: center;
        > p {
            font-size: 1.4rem;
            margin: 0 1rem;
        }
    }
`;
export const Field = styled(OutlinedInput)`
    height: 4rem;
    width: 11rem;
    margin: 1rem 0rem;
    > fieldset{
        border: var(--light-blue) 0.15rem solid !important;
    }
`;