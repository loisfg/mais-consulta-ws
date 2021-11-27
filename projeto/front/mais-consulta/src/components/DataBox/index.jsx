import React, { useState } from "react";
import { Container } from "./styles";
import { SmallInput } from '../../pages/Doctor/Appointment/FormSection/SmallInput'
export const DataBox = () => {
  const username = localStorage.getItem("nome")

  const [textos, setTextos] = useState([
    {title: 'Sim'},
    {title: 'nao'},

  ]);
  return (
    <Container>
      <div className='box'>
        <h2>Dados Cadastrais</h2>
        <div className='panel'>
            <div className='ipt_group'>
              <label>Nome</label>
              <input className='ipt_data' type="text" />
            </div>
            <div className='ipt_group'>
              <label>CPF</label>
              <input className='ipt_data' type="text" />
            </div>
            <div className='ipt_group'>
              <label>Número de carteira do SUS</label>
              <input className='ipt_data' type="text" />
            </div>
            <div className='ipt_group'>
              <label>Celular</label>
              <input className='ipt_data' type="tel" />
            </div>
            <div className='ipt_group'>
              <label>CEP</label>
              <input className='ipt_data' type="text" />
            </div>
            <div className='ipt_group'>
              <label>RG</label>
              <input className='ipt_data' type="text" />
            </div>
            <div className='ipt_group'>
              <label>Estado</label>
              <input className='ipt_data' type="text" />
            </div>
            <div className='ipt_group'>
              <label>Telefone Residencial</label>
              <input className='ipt_data' type="text" />
            </div>
            <div className='ipt_group'>
              <label>Cidade</label>
              <input className='ipt_data' type="text" />
            </div>
            <div className='ipt_group'>
              <label>RG</label>
              <input className='ipt_data' type="text" />
            </div>
            <div className='ipt_group'>
              <div className='side_ipt_group'>
                <div>
                  <label>Logradouro</label>
                  <input id='ipt_logradouro' type="text" />
                </div>
                </div>
            </div>
            <div className='ipt_group'>
              <div className='side_ipt_group'>
                <div>
                  <label>Número</label>
                  <input id='ipt_numero' type="text" />
                </div>
                <div>
                  <label>Bairro</label>
                  <input id='ipt_bairro' type="text" />
                </div>
              </div>
            </div>
            
        </div>
        <h2>Prontuário do Médico</h2>
        <div className="panel">
          <div>
              <label>Peso</label>
              <SmallInput measure="kg"/>
            <div>
              <label>Altura</label>
              <SmallInput measure="cm"/>
            </div>
          </div>
        </div>
      </div>
    </Container>
  );
};
