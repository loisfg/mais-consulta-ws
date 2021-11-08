import styled from 'styled-components';
import OutlinedInput from '@mui/material/OutlinedInput';

export const Container = styled.div`
    display: flex;
    flex-direction: column;
    font-family: var(--rawline);
    font-weight: 500;
    font-size: 1.7rem;
    margin: 0 3rem 0 0;
`;

export const Field = styled(OutlinedInput)`
    height: 4rem;
    width: 11rem;
    margin: 1rem 0rem;
    > fieldset{
        border: var(--light-blue) 0.15rem solid !important;
    }
`;