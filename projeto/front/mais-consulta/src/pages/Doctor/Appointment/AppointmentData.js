export const data = 
{ 
    dadosPessoais: {
        idPaciente: 0,
        nome: '',
        idade: 0,
        endereco: '',
        bairro: '',
        rg: '',
        numeroSus: 0,
        cpf: '',
        telefone:'',
        cidade: '',
        estado: '',
        celular:'',
        cep: ''
    },
    prontuario: {
      peso: 0,
      altura: 0,
      doencasCronicas: [''],
      remediosControlados: [''],
      alergias: [''],
      dsts: [],
      deficiencia: [],
      isFumante: false,
      isVirgem: false,
      doencasHereditarias: [],
      tipoSanguineo: {
          value: 0,
          label: 'Selecione seu tipo sanguineo'
      },
      atividadesProibidas: []
    },
    diagnostico: {
      queixa: '',
      terminologia: '',
      medicamentos: '',
      orientacoesMedicas: '',
      atestado: ''
    }
}

