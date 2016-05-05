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
	FILENAME = 'C:\BancosDeDados\CD_Collection\CDC_FG1_Dat1.ndf',
	SIZE = 5MB,
	MAXSIZE=10MB,
	FILEGROWTH=1MB),
	(
	NAME='DMC_FG2_Dat2',
	FILENAME = 'C:\BancoDeDados\CD_Collection\CDC_FG1_Dat2.ndf',
	SIZE = 5MB,
	MAXSIZE=10MB,
	FILEGROWTH=1MB),
FILEGROUP DMC_FG3
	(
	NAME = 'DMC_FG3_Dat1',
	FILENAME = 'C:\BancosDeDados\CD_Collection\CDC_FG1_Dat1.ndf',
	SIZE = 5MB,
	MAXSIZE=10MB,
	FILEGROWTH=1MB)

ALTER DATABASE CD_Collection
MODIFY FILEGROUP DMC_FG2 DEFAULT



	
ALTER DATABASE CD_Collection 
  MODIFY FILEGROUP DMC_FG3 DEFAULT;

--cd e gravadoras(labels)

CREATE TABLE Label(
	codigo INT NOT NULL PRIMARY KEY NONCLUSTERED IDENTITY,
	endereco VARCHAR(200) NOT NULL,
	endereco_site VARCHAR(100) NOT NULL,
	nome VARCHAR(50) NOT NULL
)

CREATE TABLE Telefone(
	Id INT NOT NULL PRIMARY KEY IDENTITY,
	numero BIGINT NOT NULL,
	codigo_label INT NOT NULL FOREIGN KEY REFERENCES Label(codigo) 
)

CREATE TABLE CD(
	codigo INT NOT NULL PRIMARY KEY IDENTITY,
	cod_label INT NOT NULL FOREIGN KEY REFERENCES Label(codigo),
	data_gravacao DATETIME NOT NULL, -- deve ser posterior a 01.01.2000
	data_compra DATETIME NOT NULL,
	descricao VARCHAR(200) NOT NULL,
	preco_compra DECIMAL(10,2) NOT NULL, -- e o preco deve ser menor que 3x a media do preco de compra de cds com todas as faixas com tipo de gravação ddd

	CONSTRAINT data_gravacao_minima CHECK (YEAR(data_gravacao) > 1999)
)

CREATE TABLE Periodo_Musical(
	codigo INT NOT NULL PRIMARY KEY IDENTITY,
	descricao varchar(50) NOT NULL,
	data_inicial DATETIME NOT NULL,
	data_final DATETIME NOT NULL
)
INSERT INTO Periodo_Musical(descricao,data_inicial,data_final)
VALUES
('Idade média',,),('Renascença',,),('Barroco',,),('Clássico',,),('Romântico',,),('Moderno',,)

CREATE TABLE Compositor(
	codigo INT NOT NULL PRIMARY KEY IDENTITY,
	nome VARCHAR(50) NOT NULL,
	data_nascimento DATE NOT NULL,
	data_morte DATE,
	local_nascimento VARCHAR(200) NOT NULL,
	codigo_periodo_musical INT NOT NULL FOREIGN KEY REFERENCES Periodo_Musical
)
INSERT INTO Compositor(nome, data_nascimento, data_morte, local_nascimento, codigo_periodo_musical)
VALUES
('',,,'',),('',,,'',),('',,,'',),('',,,'',),('',,,'',)


CREATE TABLE Interprete(
	codigo INT NOT NULL PRIMARY KEY IDENTITY,
	nome VARCHAR(50) NOT NULL,
	tipo VARCHAR(50) NOT NULL
)
INSERT INTO Interprete(nome, tipo)
VALUES
('','Orquestra'), ('','Trio'), ('','Quarteto'), ('','Ensemble'),
('','Soprano'), ('','Tenor'), ('Linkin Park','Banda')

CREATE TABLE Tipo_de_Composicao(
	codigo INT NOT NULL PRIMARY KEY IDENTITY,
	descricao VARCHAR(50) NOT NULL
)

INSERT INTO Tipo_de_Composicao(descricao)
VALUES
('Sinfonia'), ('Sonata'), ('Ópera'), ('Concerto'), ('Abertura'),
('Acorde'), ('Ária'), ('Ato'), ('Câmara'), ('Cantata'),
('Contraponto'), ('Coro'), ('Fantasia'), ('Fuga'),('Intermezzo'),
('Leitmotif'), ('Minueto'), ('Missa'), ('Movimento'), ('Noturno'),
('Oratório'), ('Orquestra'), ('Poema Sinfônico'), ('Rapsódia'),
('Scherzo'), ('Suíte'), ('Toccata'), ('Variações')

CREATE TABLE Faixa(
	codigo INT NOT NULL PRIMARY KEY IDENTITY,
	numero INT NOT NULL,
	tipo_gravacao CHAR(3) NOT NULL,
	codigo_compositor INT NOT NULL FOREIGN KEY REFERENCES Compositor,
	descricao VARCHAR(200) NOT NULL,

)

perguntar se o codigo vai se autoincrementar somente com "primary key" ao lado da variável
ou ainda precisa colocar algum constraint a mais, como o identity

--USE CD_Collection