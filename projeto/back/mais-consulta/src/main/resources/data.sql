--paciente
INSERT INTO usuario (id_usuario, cpf, email, password, role)
    VALUES (null, '44145999403', 'email@email.com', '123', 'PACIENTE');

INSERT INTO endereco (id_endereco, bairro, cep, cidade, complemento, estado, logradouro, numero)
    VALUES (null, 'Jardim', '071449100', 'São Paulo', '', 'SP', '', '319');

INSERT INTO paciente (id_paciente, dt_nascimento, nome, numero_carteira_sus, sexo, telefone, endereco_id, usuario_id)
    VALUES (null, '1998-03-31', 'Beatrix Campos', '31231231230', 'Feminino', '(11)4920-3132',
    (SELECT id_endereco FROM endereco WHERE bairro = 'Jardim' AND numero = '319' LIMIT 1),
    (SELECT id_usuario FROM usuario WHERE cpf = '44145999403'));

--ubs
INSERT INTO endereco (id_endereco, bairro, cep, cidade, complemento, estado, logradouro, numero)
    VALUES (null, 'Palmares', '312312334', 'São Paulo', '', 'SP', '', '999');

INSERT INTO ubs (id_ubs, endereco_id, nome)
    VALUES (null, (SELECT id_endereco FROM endereco WHERE bairro = 'Palmares' and numero = '999' LIMIT 1), 'Ubs Palmares');

INSERT INTO alergia VALUES (null, 'pulga'),(null, 'piolho'),(null, 'formiga')