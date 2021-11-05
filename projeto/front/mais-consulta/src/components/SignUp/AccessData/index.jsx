import React, { useState } from 'react';
import { Input } from '../../'
import Check from '../../../assets/check.svg';
import { Stepper, IconButton } from '../../'


export const AccessData = ({ formData, setFormData, required }) => {

    const [values, setValues] = React.useState({
        amount: "",
        password: "",
        weight: "",
        weightRange: "",
        showPassword: false
    });

    const [passwd1, setPasswd1] = useState();
    const [passwd2, setPasswd2] = useState();

    const validatePassword = () => {
        if (passwd1 === passwd2) {
            setFormData({ ...formData, password: passwd1 })
            console.log("senhas correspondem");
        } else {
            console.log("senhas nao correspondem");
        }
    }

    return (
        <>
            <Input
                required={required}
                size='big'
                label="CPF"
                onChange={e => setFormData({ ...formData, cpf: e.target.value.replace(".", "").replace(".", "").replace("-", ""), ...formData.paciente })}
                defaultValue={formData.cpf}
                helperText="000.000.000-00"
            />
            <Input
                id="standard-adornment-password"
                label='Senha'
                required={required}
                type={values.showPassword ? "text" : "password"}
                onChange={e => setPasswd1(e.target.value)}
                defaultValue={formData.password}
            />
            <Input
                id="standard-adornment-password"
                label='Confirmar senha'
                required={required}
                type={values.showPassword ? "text" : "password"}
                onChange={e => {
                    // setPasswd2(e.target.value)
                    // validatePassword()
                    setFormData({ ...formData, password: e.target.value, ...formData.paciente })
                }}
                defaultValue={formData.password}
            />
        </>
    );
}