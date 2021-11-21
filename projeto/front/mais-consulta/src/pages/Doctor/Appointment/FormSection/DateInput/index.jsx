import React, {useState} from 'react';
import { Container, Field } from './styles';
import InputAdornment from '@mui/material/InputAdornment';

export const DateInput = ({titleLabel, ...rest}) => {
    const [isChecked, setIsChecked] = useState(true);
    const handleEnableTextfield = (e) => setIsChecked(e.target.checked === true ? false : true );
    return (
        <Container>
            <div className='title-group'>
                <input onChange={handleEnableTextfield} type="checkbox"/>
                <p>{titleLabel}</p>
            </div>
            <Field
                id="filled-adornment-weight"
                endAdornment={<InputAdornment position="end">dias</InputAdornment>}
                aria-describedby="filled-weight-helper-text"
                {...rest}
            />
        </Container>
    );
}