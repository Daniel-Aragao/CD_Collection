USE CD_Collection

INSERT INTO Periodo_Musical(descricao,data_inicial,data_final)
VALUES
('Idade m�dia',,),('Renascen�a',,),('Barroco',,),('Cl�ssico',,),('Rom�ntico',,),('Moderno',,)

INSERT INTO Compositor(nome, data_nascimento, data_morte, local_nascimento, codigo_periodo_musical)
VALUES
('',,,'',),('',,,'',),('',,,'',),('',,,'',),('',,,'',)

INSERT INTO Interprete(nome, tipo)
VALUES
('','Orquestra'), ('','Trio'), ('','Quarteto'), ('','Ensemble'),
('','Soprano'), ('','Tenor'), ('Linkin Park','Banda')

INSERT INTO Tipo_de_Composicao(descricao)
VALUES
('Sinfonia'), ('Sonata'), ('�pera'), ('Concerto'), ('Abertura'),
('Acorde'), ('�ria'), ('Ato'), ('C�mara'), ('Cantata'),
('Contraponto'), ('Coro'), ('Fantasia'), ('Fuga'),('Intermezzo'),
('Leitmotif'), ('Minueto'), ('Missa'), ('Movimento'), ('Noturno'),
('Orat�rio'), ('Orquestra'), ('Poema Sinf�nico'), ('Raps�dia'),
('Scherzo'), ('Su�te'), ('Toccata'), ('Varia��es')