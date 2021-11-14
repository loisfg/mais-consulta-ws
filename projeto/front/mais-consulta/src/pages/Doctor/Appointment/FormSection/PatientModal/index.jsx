import React from 'react';
import { Container, CustomBox } from './styles';
import swal from 'sweetalert';
export default function PatientModal({title, name, cpf, susNumber, cellphone, cep, street, lastName, rg, telephone,
                                      city, state, neighbor }) {
    const handleAlert = (event) => swal("Dados atualizados!", "Os dados do paciente foram atualizados com sucesso.", "success");
    return (
        <Container>
            <CustomBox>
                <div className='title'>
                    <h1>{title}</h1>
                </div>
                <div className='form-group'>
                    <div className='left-side'>
                        <label>Nome</label> 
                        <input type="text" value={name} />
                        <label>CPF</label> 
                        <input type="text" value={cpf} />
                        <label>Número de carteira do SUS</label> 
                        <input type="text" value={susNumber} />
                        <label>Celular</label> 
                        <input type="text" value={cellphone} />
                        <label>CEP</label> 
                        <input type="text" value={cep} />
                        <label>Logradouro</label> 
                        <input type="text" value={street} />
                    </div>
                    <div className='right-side'>
                        <label>Sobrenome</label> 
                        <input type="text" value={lastName} />
                        <label>RG</label> 
                        <input type="text" value={rg} />
                        <label>Telefone residencial</label> 
                        <input type="text" value={telephone} />
                        <label>Cidade</label> 
                        <input type="text" value={city} />
                        <label>Estado</label> 
                        <input type="text" value={state} />
                        <label>Bairro</label> 
                        <input type="text" value={neighbor} />
                    </div>
                </div>
                <div className='btn-group'>
                    <button id='btn_cancel'>Cancelar</button>
                    <button id='btn_save' onClick={handleAlert}>Salvar</button>
                </div>
            </CustomBox>
        </Container>
    );
}