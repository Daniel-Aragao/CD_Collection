CREATE DATABASE CD_Collection
ON PRIMARY(
	NAME = 'DMCollection',
	FILENAME = 'C:\BancosDeDados\CD_Collection\CDC_Prm.mdf',
	SIZE=5MB,
	MAXSIZE=10MB,
	FILEGROWTH=1MB	
),
FILEGROUP DMC_FG2
	(
	NAME = 'DMC_FG2_Dat1',
	FILENAME = 'C:\BancosDeDados\CD_Collection\CDC_FG2_Dat1.ndf',
	SIZE = 5MB,
	MAXSIZE=10MB,
	FILEGROWTH=1MB),
	(
	NAME='DMC_FG2_Dat2',
	FILENAME = 'C:\BancosDeDados\CD_Collection\CDC_FG2_Dat2.ndf',
	SIZE = 5MB,
	MAXSIZE=10MB,
	FILEGROWTH=1MB),
FILEGROUP DMC_FG3
	(
	NAME = 'DMC_FG3_Dat1',
	FILENAME = 'C:\BancosDeDados\CD_Collection\CDC_FG3_Dat1.ndf',
	SIZE = 5MB,
	MAXSIZE=10MB,
	FILEGROWTH=1MB)

ALTER DATABASE CD_Collection 
  MODIFY FILEGROUP DMC_FG3 DEFAULT;

USE CD_Collection

CREATE TABLE Label(
	codigo INT NOT NULL PRIMARY KEY IDENTITY,
	endereco VARCHAR(200) NOT NULL,
	endereco_site VARCHAR(100) NOT NULL,
	nome VARCHAR(50) NOT NULL
)

CREATE TABLE Telefone(
	codigo INT NOT NULL PRIMARY KEY IDENTITY,
	numero BIGINT NOT NULL,
	codigo_label INT NOT NULL FOREIGN KEY REFERENCES Label 
)

CREATE TABLE CD(
	codigo INT NOT NULL PRIMARY KEY IDENTITY,
	cod_label INT NOT NULL FOREIGN KEY REFERENCES Label,
	data_gravacao DATETIME NOT NULL, 
	-- a data de gravacao deve ser posterior a 01.01.2000
	data_compra DATETIME NOT NULL,
	descricao VARCHAR(200) NOT NULL,
	preco_compra DECIMAL(10,2) NOT NULL, 
	-- e o preco deve ser menor ou igual que 3x a media do preco de compra de 
	-- cds com todas as faixas com tipo de gravação ddd

	CONSTRAINT data_gravacao_minima CHECK (YEAR(data_gravacao) > 1999)
)

CREATE TABLE Periodo_Musical(
	codigo INT NOT NULL PRIMARY KEY IDENTITY,
	descricao varchar(50) NOT NULL,
	data_inicial DATETIME NOT NULL,
	data_final DATETIME NOT NULL
)


CREATE TABLE Compositor(
	codigo INT NOT NULL PRIMARY KEY IDENTITY,
	nome VARCHAR(50) NOT NULL,
	data_nascimento DATE NOT NULL,
	data_morte DATE,
	local_nascimento VARCHAR(200) NOT NULL,
	codigo_periodo_musical INT NOT NULL FOREIGN KEY REFERENCES Periodo_Musical
)


CREATE TABLE Interprete(
	codigo INT NOT NULL PRIMARY KEY IDENTITY,
	nome VARCHAR(50) NOT NULL,
	tipo VARCHAR(50) NOT NULL
)


CREATE TABLE Tipo_de_Composicao(
	codigo INT NOT NULL PRIMARY KEY IDENTITY,
	descricao VARCHAR(50) NOT NULL
)

CREATE TABLE Faixa(
	codigo INT NOT NULL PRIMARY KEY NONCLUSTERED IDENTITY,
	numero INT NOT NULL,
	tipo_gravacao CHAR(3) NOT NULL,
	descricao VARCHAR(200) NOT NULL,
	codigo_CD INT NOT NULL FOREIGN KEY REFERENCES CD,
	codigo_compositor INT NOT NULL FOREIGN KEY REFERENCES Compositor,
	tipo_composicao INT NOT NULL FOREIGN KEY REFERENCES Tipo_de_Composicao
)

CREATE TABLE Faixa_por_compositor(
	codigo INT NOT NULL PRIMARY KEY IDENTITY,
	codigo_faixa INT NOT NULL FOREIGN KEY REFERENCES Faixa,
	codigo_compositor INT NOT NULL FOREIGN KEY REFERENCES Compositor
)

CREATE TABLE Faixa_por_interprete(
	codigo INT NOT NULL PRIMARY KEY IDENTITY,
	codigo_faixa INT NOT NULL FOREIGN KEY REFERENCES Faixa,
	codigo_interprete INT NOT NULL FOREIGN KEY REFERENCES Interprete
)