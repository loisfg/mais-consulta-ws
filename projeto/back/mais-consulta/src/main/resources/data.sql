--paciente
INSERT INTO usuario (id_usuario, cpf, email, password, role)
    VALUES (null, '55245903083', 'email@email.com', '123', 'PACIENTE');

INSERT INTO usuario (id_usuario, cpf, email, password, role)
    VALUES (null, '36014447806', 'email@medico.com', '123', 'MEDICO');

INSERT INTO endereco (id_endereco, bairro, cep, cidade, complemento, estado, logradouro, numero, rua)
    VALUES (null, 'Jardim', '071449100', 'São Paulo', '', 'SP', '', '319', 'Loudes Lopes');

INSERT INTO paciente (id_paciente, dt_nascimento, nome, numero_carteira_sus, sexo, telefone, endereco_id, usuario_id)
    VALUES (null, '1998-03-31', 'Beatrix Campos', '31231231230', 'Feminino', '(11)4920-3132',
    (SELECT id_endereco FROM endereco WHERE bairro = 'Jardim' AND numero = '319' LIMIT 1),
    (SELECT id_usuario FROM usuario WHERE cpf = '55245903083'));

--ubs
INSERT INTO endereco (id_endereco, bairro, cep, cidade, complemento, estado, logradouro, numero, rua)
    VALUES (null, 'Palmares', '312312334', 'São Paulo', '', 'SP', '', '999', 'Juvenal Lopes');

INSERT INTO alergia VALUES (null, 'pulga'),(null, 'piolho'),(null, 'formiga');

INSERT INTO ubs (id_ubs, endereco_id, nome, telefone)
    VALUES (null, (SELECT id_endereco FROM endereco WHERE bairro = 'Palmares' and numero = '999' LIMIT 1), 'Ubs Palmares', '(11)4920-4040');

-- medico
INSERT INTO especialidade (id_especialidade, descricao)
    VALUES (null, 'Clinico');

INSERT INTO medico (id_medico, nome, especialidade_id, ubs_id, usuario_id)
   VALUES(null, 'Luis Fernando Rocha',
   (SELECT id_especialidade FROM especialidade WHERE descricao = 'Clinico'),
   (SELECT id_ubs FROM ubs WHERE nome = 'Ubs Palmares'),
   (SELECT id_usuario FROM usuario WHERE cpf = '36014447806'));
