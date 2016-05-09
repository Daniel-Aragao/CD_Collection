USE CD_Collection

INSERT INTO Periodo_Musical(descricao,data_inicial,data_final)
VALUES
('Idade média',,),('Renascença',,),('Barroco',,),('Clássico',,),('Romântico',,),('Moderno',,)

INSERT INTO Compositor(nome, data_nascimento, data_morte, local_nascimento, codigo_periodo_musical)
VALUES
('',,,'',),('',,,'',),('',,,'',),('',,,'',),('',,,'',)

INSERT INTO Interprete(nome, tipo)
VALUES
('Orquestra Filarmônica do Ceará','Orquestra'), ('Nirvana','Trio'), ('Coldplay','Quarteto'),
('Eminem','Cantor'),('Jasmine Thompson','Cantora'), ('Linkin Park','Banda'),('Skrillex','DJ'),
('Taylor Davis','Violinista'), ('Lindsey Stirling','Violinista')

INSERT INTO Tipo_de_Composicao(descricao)
VALUES
('Sinfonia'), ('Sonata'), ('Ópera'), ('Concerto'), ('Abertura'),
('Acorde'), ('Ária'), ('Ato'), ('Câmara'), ('Cantata'),
('Contraponto'), ('Coro'), ('Fantasia'), ('Fuga'),('Intermezzo'),
('Leitmotif'), ('Minueto'), ('Missa'), ('Movimento'), ('Noturno'),
('Oratório'), ('Orquestra'), ('Poema Sinfônico'), ('Rapsódia'),
('Scherzo'), ('Suíte'), ('Toccata'), ('Variações')