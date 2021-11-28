import React, { useState } from "react";
import api from "../../../services/api"
import { Page } from "./styles";
import { DivUsuario, Content, BoxLeft, BoxRight, BoxAux } from "./styles";
import {
  UserProfilePic,
  Message,
  List,
  Calendar,
  Hours,
  Button,
} from "../../../components";
import swal from 'sweetalert';
import Select from 'react-select';

export const Schedules = ({ usuario }) => {


  const specialties = [
    {value: 'Acupuntura', label: 'Acupuntura'},
    {value: 'Alergia e Imunologia', label: 'Alergia e Imunologia'},
    {value: 'Anestesiologia', label: 'Anestesiologia'},
    {value: 'Angiologia', label: 'Angiologia'},
    {value: 'Cancerologia', label: 'Cancerologia'},
    {value: 'Cardiologia', label: 'Cardiologia'},
    {value: 'Cirurgia Cardiovascular', label: 'Cirurgia Cardiovascular'},
    {value: 'Cirurgia da Mão', label: 'Cirurgia da Mão'},
    {value: 'Cirurgia de Cabeça e Pescoço', label: 'Cirurgia de Cabeça e Pescoço'},
    {value: 'Cirurgia do Aparelho Digestivo', label: 'Cirurgia do Aparelho Digestivo'},
    {value: 'Cirurgia Geral', label: 'Cirurgia Geral'},
    {value: 'Cirurgia Pediátrica', label: 'Cirurgia Pediátrica'},
    {value: 'Cirurgia Plástica', label: 'Cirurgia Plástica'},
    {value: 'Cirurgia Torácica', label: 'Cirurgia Torácica'},
    {value: 'Cirurgia Vascular', label: 'Cirurgia Vascular'},
    {value: 'Clínica Médica', label: 'Clínica Médica'},
    {value: 'Coloproctologia', label: 'Coloproctologia'},
    {value: 'Dermatologia', label: 'Dermatologia'},
    {value: 'Endocrinologia e Metabologia', label: 'Endocrinologia e Metabologia'},
    {value: 'Endoscopia', label: 'Endoscopia'},
    {value: 'Gastroenterologia', label: 'Gastroenterologia'},
    {value: 'Genética Médica', label: 'Genética Médica'},
    {value: 'Geriatria', label: 'Geriatria'},
    {value: 'Ginecologia e Obstetrícia', label: 'Ginecologia e Obstetrícia'},
    {value: 'Hematologia e Hemoterapia', label: 'Hematologia e Hemoterapia'},
    {value: 'Homeopatia', label: 'Homeopatia'},
    {value: 'Infectologia', label: 'Infectologia'},
    {value: 'Mastologia', label: 'Mastologia'},
    {value: 'Medicina de Família e Comunidade', label: 'Medicina de Família e Comunidade'},
    {value: 'Medicina do Trabalho', label: 'Medicina do Trabalho'},
    {value: 'Medicina de Tráfego', label: 'Medicina de Tráfego'},
    {value: 'Medicina Esportiva', label: 'Medicina Esportiva'},
    {value: 'Medicina Física e Reabilitação', label: 'Medicina Física e Reabilitação'},
    {value: 'Medicina Intensiva', label: 'Medicina Intensiva'},
    {value: 'Medicina Legal e Perícia Médica', label: 'Medicina Legal e Perícia Médica'},
    {value: 'Medicina Nuclear', label: 'Medicina Nuclear'},
    {value: 'Medicina Preventiva e Social', label: 'Medicina Preventiva e Social'},
    {value: 'Nefrologia', label: 'Nefrologia'},
    {value: 'Neurocirurgia', label: 'Neurocirurgia'},
    {value: 'Neurologia', label: 'Neurologia'},
    {value: 'Nutrologia', label: 'Nutrologia'},
    {value: 'Oftalmologia', label: 'Oftalmologia'},
    {value: 'Ortopedia e Traumatologia', label: 'Ortopedia e Traumatologia'},
    {value: 'Otorrinolaringologia', label: 'Otorrinolaringologia'},
    {value: 'Patologia', label: 'Patologia'},
    {value: 'Patologia Clínica/Medicina Laboratorial', label: 'Patologia Clínica/Medicina Laboratorial'},
    {value: 'Pediatria', label: 'Pediatria'},
    {value: 'Pneumologia', label: 'Pneumologia'},
    {value: 'Psiquiatria', label: 'Psiquiatria'},
    {value: 'Radiologia e Diagnóstico por Imagem', label: 'Radiologia e Diagnóstico por Imagem'},
    {value: 'Radioterapia', label: 'Radioterapia'},
    {value: 'Reumatologia', label: 'Reumatologia'},
    {value: 'Urologia', label: 'Urologia'},
    {value: 'Áreas de Atuação reconhecidas', label: 'Áreas de Atuação reconhecidas'},
    {value: 'Administração em Saúde', label: 'Administração em Saúde'},
    {value: 'Alergia e Imunologia Pediátrica', label: 'Alergia e Imunologia Pediátrica'},
    {value: 'Angiorradiologia e Cirurgia Endovascular', label: 'Angiorradiologia e Cirurgia Endovascular'},
    {value: 'Atendimento ao queimado', label: 'Atendimento ao queimado'},
    {value: 'Cardiologia Pediátrica', label: 'Cardiologia Pediátrica'},
    {value: 'Cirurgia Crânio-Maxilo-Facial', label: 'Cirurgia Crânio-Maxilo-Facial'},
    {value: 'Cirurgia do Trauma', label: 'Cirurgia do Trauma'},
    {value: 'Cirurgia Videolaparoscópica', label: 'Cirurgia Videolaparoscópica'},
    {value: 'Citopatologia', label: 'Citopatologia'},
    {value: 'Densitometria Óssea', label: 'Densitometria Óssea'},
    {value: 'Dor', label: 'Dor'},
    {value: 'Ecocardiografia', label: 'Ecocardiografia'},
    {value: 'Ecografia Vascular com Doppler', label: 'Ecografia Vascular com Doppler'},
    {value: 'Eletrofisiologia Clínica Invasiva', label: 'Eletrofisiologia Clínica Invasiva'},
    {value: 'Endocrinologia Pediátrica', label: 'Endocrinologia Pediátrica'},
    {value: 'Endoscopia Digestiva', label: 'Endoscopia Digestiva'},
    {value: 'Endoscopia Ginecológica', label: 'Endoscopia Ginecológica'},
    {value: 'Endoscopia Respiratória', label: 'Endoscopia Respiratória'},
    {value: 'Ergometria', label: 'Ergometria'},
    {value: 'Foniatria', label: 'Foniatria'},
    {value: 'Gastroenterologia Pediátrica', label: 'Gastroenterologia Pediátrica'},
    {value: 'Hansenologia', label: 'Hansenologia'},
    {value: 'Hematologia e Hemoterapia Pediátrica', label: 'Hematologia e Hemoterapia Pediátrica'},
    {value: 'Hemodinâmica e Cardiologia Intervencionista', label: 'Hemodinâmica e Cardiologia Intervencionista'},
    {value: 'Hepatologia', label: 'Hepatologia'},
    {value: 'Infectologia Hospitalar', label: 'Infectologia Hospitalar'},
    {value: 'Infectologia Pediátrica', label: 'Infectologia Pediátrica'},
    {value: 'Mamografia', label: 'Mamografia'},
    {value: 'Medicina de Urgência', label: 'Medicina de Urgência'},
    {value: 'Medicina do Adolescente', label: 'Medicina do Adolescente'},
    {value: 'Medicina do Sono', label: 'Medicina do Sono'},
    {value: 'Medicina Fetal', label: 'Medicina Fetal'},
    {value: 'Medicina Intensiva Pediátrica', label: 'Medicina Intensiva Pediátrica'},
    {value: 'Medicina Paliativa', label: 'Medicina Paliativa'},
    {value: 'Medicina Tropical', label: 'Medicina Tropical'},
    {value: 'Nefrologia Pediátrica', label: 'Nefrologia Pediátrica'},
    {value: 'Neonatologia', label: 'Neonatologia'},
    {value: 'Neurofisiologia Clínica', label: 'Neurofisiologia Clínica'},
    {value: 'Neurologia Pediátrica', label: 'Neurologia Pediátrica'},
    {value: 'Neurorradiologia', label: 'Neurorradiologia'},
    {value: 'Nutrição Parenteral e Enteral', label: 'Nutrição Parenteral e Enteral'},
    {value: 'Nutrição Parenteral e Enteral Pediátrica', label: 'Nutrição Parenteral e Enteral Pediátrica'},
    {value: 'Nutrologia Pediátrica', label: 'Nutrologia Pediátrica'},
    {value: 'Pneumologia Pediátrica', label: 'Pneumologia Pediátrica'},
    {value: 'Psicogeriatria', label: 'Psicogeriatria'},
    {value: 'Psicoterapia', label: 'Psicoterapia'},
    {value: 'Psiquiatria da Infância e Adolescência', label: 'Psiquiatria da Infância e Adolescência'},
    {value: 'Psiquiatria Forense', label: 'Psiquiatria Forense'},
    {value: 'Radiologia Intervencionista e Angiorradiologia', label: 'Radiologia Intervencionista e Angiorradiologia'},
    {value: 'Reumatologia Pediátrica', label: 'Reumatologia Pediátrica'},
    {value: 'Sexologia', label: 'Sexologia'},
    {value: 'Transplante de Medula Óssea', label: 'Transplante de Medula Óssea'},
    {value: 'Ultrassonografia em Ginecologia e Obstetrícia', label: 'Ultrassonografia em Ginecologia e Obstetrícia'},
    
]

  const [listUbs, setListUbs] = useState([]);
  const [daySelected, setdaySelected] = useState([0]);
  const [horaSelecionada, setHoraSelecionada] = useState();

  const userId = localStorage.getItem("id"); 
 
   async function cadastrar(e) {
    e.preventDefault();
    
    const data = {
      descricao: "Dermatologia",
      dtAtendimento: daySelected,
      hrAtendimento: horaSelecionada,
      idEspecialidade : 1,
      idPaciente: userId,
      idUbs: listUbs
    }
    await api("http://7ac4-189-78-204-97.ngrok.io/mais-consulta")
    .post("/agendamento/agendar/exame", data)

  }
  const typeOfUser = localStorage.getItem("role");
  return (
    <Page>
      <DivUsuario>
        <UserProfilePic />
      </DivUsuario>
      <Content>
        <BoxLeft>
          <Message textOne="Novo agendamento de consulta" textTwo="" />
          <Select options={specialties} />
          <BoxAux>
            <List text="Escolha a unidade desejada" setListUbs={setListUbs}/>
          </BoxAux>
        </BoxLeft>
        <BoxRight>
          <Calendar setdaySelected={setdaySelected}/>
          <Hours setHoraSelecionada={setHoraSelecionada} />
          <button text="Agendar atendimento" onClick={()=>{
            swal({
              text: "Deseja finalizar seu agendamento?",
              buttons: true,
              closeOnClickOutside: false,
              buttons: {
                cancel: 'Cancelar',
                confirm: {
                  text: 'Confirmar',
                  className: 'confirmar',
                  onClick: {cadastrar}
                },

              },
            })
              .then((agendar) => {
                if (agendar) {
                  swal("Deseja baixar o documento de confirmação do agendamento?", {
                    icon: "success",
                  });
                 

                } else {
                  swal("Agendamento cancelado", {
                    icon: "error",
                  });

                }
              });
          }}
          >clica</button>
          {/* <Button type="submit" text="Agendar atendimento" /> */}
        </BoxRight>
      </Content>
    </Page>
  );
};

