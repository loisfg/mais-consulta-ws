--ALERGIA
CREATE TABLE Alergia
(
    id_alergia int IDENTITY (1, 1) NOT NULL,
    nome       varchar(255),
    CONSTRAINT pk_alergia PRIMARY KEY (id_alergia)
)
GO

--ATIVIDADE
CREATE TABLE Atividade
(
    id_atividade int IDENTITY (1, 1) NOT NULL,
    nome         varchar(255),
    CONSTRAINT pk_atividade PRIMARY KEY (id_atividade)
)
GO

--DEFICIENCIA
CREATE TABLE Deficiencia
(
    id_deficiencia int IDENTITY (1, 1) NOT NULL,
    nome           varchar(255),
    CONSTRAINT pk_deficiencia PRIMARY KEY (id_deficiencia)
)
GO

--DOENCA
CREATE TABLE Doenca
(
    id          int IDENTITY (1, 1) NOT NULL,
    nome        varchar(255),
    hereditaria bit,
    cronico     bit,
    dst         bit,
    CONSTRAINT pk_doenca PRIMARY KEY (id)
)
GO

-- MEDICO
CREATE TABLE Medico
(
    id_medico        int IDENTITY (1, 1) NOT NULL,
    nome             varchar(255),
    ubs_id           int                 NOT NULL,
    usuario_id       int                 NOT NULL,
    especialidade_id int                 NOT NULL,
    CONSTRAINT pk_medico PRIMARY KEY (id_medico)
)
GO

ALTER TABLE Medico
    ADD CONSTRAINT FK_MEDICO_ON_ESPECIALIDADE FOREIGN KEY (especialidade_id) REFERENCES especialidade (id_especialidade)
GO

ALTER TABLE Medico
    ADD CONSTRAINT FK_MEDICO_ON_UBS FOREIGN KEY (ubs_id) REFERENCES ubs (id_ubs)
GO

ALTER TABLE Medico
    ADD CONSTRAINT FK_MEDICO_ON_USUARIO FOREIGN KEY (usuario_id) REFERENCES usuario (id_usuario)
GO

-- NOTIFICACAO
CREATE TABLE Notification
(
    id_notification int IDENTITY (1, 1) NOT NULL,
    descricao       varchar(255),
    insert_dt       datetime,
    id_usuario      int,
    CONSTRAINT pk_notification PRIMARY KEY (id_notification)
)
GO

--PACIENTE
CREATE TABLE Paciente
(
    id_paciente         int IDENTITY (1, 1) NOT NULL,
    nome                varchar(255),
    dt_nascimento       date,
    telefone            varchar(255),
    sexo                varchar(255),
    numero_carteira_sus varchar(255),
    endereco_id         int,
    usuario_id          int                 NOT NULL,
    CONSTRAINT pk_paciente PRIMARY KEY (id_paciente)
)
GO

ALTER TABLE Paciente
    ADD CONSTRAINT FK_PACIENTE_ON_ENDERECO FOREIGN KEY (endereco_id) REFERENCES endereco (id_endereco)
GO

ALTER TABLE Paciente
    ADD CONSTRAINT FK_PACIENTE_ON_USUARIO FOREIGN KEY (usuario_id) REFERENCES usuario (id_usuario)
GO

-- REMEDIO
CREATE TABLE Remedio
(
    id         int IDENTITY (1, 1) NOT NULL,
    nome       varchar(255),
    controlado bit,
    CONSTRAINT pk_remedio PRIMARY KEY (id)
)
GO

-- PACIENTE HAS ALERGIA
CREATE TABLE PacienteHasAlergia
(
    paciente_id int NOT NULL,
    alergia_id  int NOT NULL,
    CONSTRAINT pk_pacientehasalergia PRIMARY KEY (paciente_id, alergia_id)
)
GO

ALTER TABLE PacienteHasAlergia
    ADD CONSTRAINT FK_PACIENTEHASALERGIA_ON_ALERGIA FOREIGN KEY (alergia_id) REFERENCES alergia (id_alergia)
GO

ALTER TABLE PacienteHasAlergia
    ADD CONSTRAINT FK_PACIENTEHASALERGIA_ON_PACIENTE FOREIGN KEY (paciente_id) REFERENCES paciente (id_paciente)
GO

-- PACIENTE HAS ATIVIDADE
CREATE TABLE PacienteHasAtividade
(
    paciente_id  int NOT NULL,
    atividade_id int NOT NULL,
    CONSTRAINT pk_pacientehasatividade PRIMARY KEY (paciente_id, atividade_id)
)
GO

ALTER TABLE PacienteHasAtividade
    ADD CONSTRAINT FK_PACIENTEHASATIVIDADE_ON_ATIVIDADE FOREIGN KEY (atividade_id) REFERENCES atividade (id_atividade)
GO

ALTER TABLE PacienteHasAtividade
    ADD CONSTRAINT FK_PACIENTEHASATIVIDADE_ON_PACIENTE FOREIGN KEY (paciente_id) REFERENCES paciente (id_paciente)
GO

--  PACIENTE HAS DEFICIENCIA
CREATE TABLE PacienteHasDeficiencia
(
    paciente_id    int NOT NULL,
    deficiencia_id int NOT NULL,
    CONSTRAINT pk_pacientehasdeficiencia PRIMARY KEY (paciente_id, deficiencia_id)
)
GO

ALTER TABLE PacienteHasDeficiencia
    ADD CONSTRAINT FK_PACIENTEHASDEFICIENCIA_ON_DEFICIENCIA FOREIGN KEY (deficiencia_id) REFERENCES deficiencia (id_deficiencia)
GO

ALTER TABLE PacienteHasDeficiencia
    ADD CONSTRAINT FK_PACIENTEHASDEFICIENCIA_ON_PACIENTE FOREIGN KEY (paciente_id) REFERENCES paciente (id_paciente)
GO

-- PACIENTE HAS DOENCAS
CREATE TABLE PacienteHasDoencas
(
    doenca_id   int NOT NULL,
    paciente_id int NOT NULL
)
GO

ALTER TABLE PacienteHasDoencas
    ADD CONSTRAINT FK_PACIENTEHASDOENCAS_ON_DOENCA FOREIGN KEY (doenca_id) REFERENCES doenca (id)
GO

ALTER TABLE PacienteHasDoencas
    ADD CONSTRAINT FK_PACIENTEHASDOENCAS_ON_PACIENTE FOREIGN KEY (paciente_id) REFERENCES paciente (id_paciente)
GO

-- PACIENTE HAS REMEDIOS
CREATE TABLE PacienteHasRemedios
(
    paciente_id int NOT NULL,
    remedio_id  int NOT NULL,
    CONSTRAINT pk_pacientehasremedios PRIMARY KEY (paciente_id, remedio_id)
)
GO

ALTER TABLE PacienteHasRemedios
    ADD CONSTRAINT FK_PACIENTEHASREMEDIOS_ON_PACIENTE FOREIGN KEY (paciente_id) REFERENCES paciente (id_paciente)
GO

ALTER TABLE PacienteHasRemedios
    ADD CONSTRAINT FK_PACIENTEHASREMEDIOS_ON_REMEDIO FOREIGN KEY (remedio_id) REFERENCES remedio (id)
GO

-- AGENDAMENTO
CREATE TABLE Agendamento
(
    id_agendamento   int IDENTITY (1, 1) NOT NULL,
    data_hr          datetime,
    dt_atendimento   date                NOT NULL,
    hr_atendimento   time                NOT NULL,
    status           varchar(255),
    especialidade_id int                 NOT NULL,
    paciente_id      int                 NOT NULL,
    medico_id        int                 NOT NULL,
    CONSTRAINT pk_agendamento PRIMARY KEY (id_agendamento)
)
GO

ALTER TABLE Agendamento
    ADD CONSTRAINT FK_AGENDAMENTO_ON_ESPECIALIDADE FOREIGN KEY (especialidade_id) REFERENCES especialidade (id_especialidade)
GO

ALTER TABLE Agendamento
    ADD CONSTRAINT FK_AGENDAMENTO_ON_MEDICO FOREIGN KEY (medico_id) REFERENCES medico (id_medico)
GO

ALTER TABLE Agendamento
    ADD CONSTRAINT FK_AGENDAMENTO_ON_PACIENTE FOREIGN KEY (paciente_id) REFERENCES paciente (id_paciente)
GO

-- CONSULTA
CREATE TABLE Consulta
(
    id_consulta    int IDENTITY (1, 1) NOT NULL,
    descricao      varchar(255),
    agendamento_id int                 NOT NULL,
    CONSTRAINT pk_consulta PRIMARY KEY (id_consulta)
)
GO

ALTER TABLE Consulta
    ADD CONSTRAINT FK_CONSULTA_ON_AGENDAMENTO FOREIGN KEY (agendamento_id) REFERENCES agendamento (id_agendamento)
GO

--EXAME
CREATE TABLE Exame
(
    id_exame       int IDENTITY (1, 1) NOT NULL,
    descricao      varchar(255),
    agendamento_id int                 NOT NULL,
    CONSTRAINT pk_exame PRIMARY KEY (id_exame)
)
GO

ALTER TABLE Exame
    ADD CONSTRAINT FK_EXAME_ON_AGENDAMENTO FOREIGN KEY (agendamento_id) REFERENCES agendamento (id_agendamento)
GO