import React from 'react';
import { Container, CustomBox } from './styles';
import swal from 'sweetalert';
import exit from '../../../../../assets/exit.svg'

export const PatientModal = ({Controller, control, onClose }) => {
    const handleAlert = (event) => swal("Dados atualizados!", "Os dados do paciente foram atualizados com sucesso.", "success");
    return (
        <Container>
            <CustomBox>
                <div className='title'>
                    <h1>Dados Cadastrais</h1>
                    <img src={exit} onClick={onClose} alt="" />
                </div>
                <div className='form-group'>
                    <div className='left-side'>
                        <label>Nome</label> 
                        <Controller name='dadosPessoais.nome' control={control} render={({field}) => <input {...field} type="text"/>}/>
                        <label>CPF</label>
                        <Controller name='dadosPessoais.cpf' control={control} render={({field}) => <input {...field} type="text"/>}/>
                        <label>Número de carteira do SUS</label> 
                        <Controller name='dadosPessoais.numeroSus' control={control} render={({field}) => <input {...field} type="text"/>}/>
                        <label>Celular</label> 
                        <Controller name='dadosPessoais.celular' control={control} render={({field}) => <input {...field} type="text"/>}/>
                        <label>CEP</label>
                        <Controller name='dadosPessoais.cep' control={control} render={({field}) => <input {...field} type="text"/>}/>
                        <label>Logradouro</label>
                        <Controller name='dadosPessoais.logradouro' control={control} render={({field}) => <input {...field} type="text"/>}/>
                    </div>
                    <div className='right-side'>
                        <label>RG</label> 
                        <Controller name='dadosPessoais.rg' control={control} render={({field}) => <input {...field} type="text"/>}/>
                        <label>Telefone residencial</label> 
                        <Controller name='dadosPessoais.telefone' control={control} render={({field}) => <input {...field} type="text"/>}/>
                        <label>Cidade</label> 
                        <Controller name='dadosPessoais.cidade' control={control} render={({field}) => <input {...field} type="text"/>}/>
                        <label>Estado</label> 
                        <Controller name='dadosPessoais.estado' control={control} render={({field}) => <input {...field} type="text"/>}/>
                        <label>Bairro</label> 
                        <Controller name='dadosPessoais.bairro' control={control} render={({field}) => <input {...field} type="text"/>}/>
                    </div>
                </div>
                <div className='btn-group'>
                    <button id='btn_cancel'type={"button"} onClick={onClose}>Cancelar</button>
                    <button id='btn_save' onClick={handleAlert}>Salvar</button>
                </div>
            </CustomBox>
        </Container>
    );
}