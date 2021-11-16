import React, {useState} from 'react';
import { Container } from './styles';

export const DateInput = ({titleLabel}) => {
    const [isChecked, setIsChecked] = useState(true);
    const handleEnableTextfield = (e) => setIsChecked(e.target.checked === true ? false : true );
    return (
        <Container>
            <div className='title-group'>
                <input onChange={handleEnableTextfield} type="checkbox"/>
                <p>{titleLabel}</p>
            </div>
            <div className='ipt-group'>
                <div>
                    <label>Data inicial</label>
                    <input className='styled-input' disabled={isChecked} type="date" />
                </div>
                <div>
                    <label>Data final</label>
                    <input className='styled-input' disabled={isChecked} type="date" />
                </div>
            </div>
        </Container>
    );
}