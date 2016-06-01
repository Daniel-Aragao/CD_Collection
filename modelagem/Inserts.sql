USE CD_Collection

INSERT INTO Periodo_Musical(descricao,data_inicial,data_final)
VALUES
('Idade m�dia','0476-01-01','1500-01-01'),('Renascen�a','1300-01-01','1600-01-01'),
('Barroco','1500-01-01','1700-01-01'),('Romantico','1825-01-01','1870-01-01'),
('Classico','1705-01-01','1828-01-01'),('Moderno','1425-01-01','1789-01-01')

INSERT INTO Compositor(nome, data_nascimento, data_morte, local_nascimento, codigo_periodo_musical)
VALUES
('Greg�rio Magno','0540-09-03','0604-03-12','Roma',1),
('Josquin des Prez','1440-01-01','1521-01-01','Cond�-sur-lEscaut, Hainaut',2),
('Johann Sebastian Bach','1685-03-21','1750-06-28','Eisenach, Alemanha',3),
('Franz Schubert','1787-01-31','1828-11-19','Alsergrund, Viena, �ustria',4),
('Leopold Mozart','1719-01-01','1787-01-01','Augsburgo',5),
('Anton Webern ','1883-12-03','1945-09-15','Viena',6)
    
INSERT INTO Interprete(nome, tipo)
VALUES
('Orquestra Filarm�nica do Cear�','Orquestra'), ('Nirvana','Trio'), ('Coldplay','Quarteto'),
('Eminem','Cantor'),('Jasmine Thompson','Cantora'), ('Linkin Park','Banda'),('Skrillex','DJ'),
('Taylor Davis','Violinista'), ('Lindsey Stirling','Violinista')

INSERT INTO Tipo_de_Composicao(descricao)
VALUES
('Sinfonia'), ('Sonata'), ('�pera'), ('Concerto'), ('Abertura'),
('Acorde'), ('�ria'), ('Ato'), ('C�mara'), ('Cantata'),
('Contraponto'), ('Coro'), ('Fantasia'), ('Fuga'),('Intermezzo'),
('Leitmotif'), ('Minueto'), ('Missa'), ('Movimento'), ('Noturno'),
('Orat�rio'), ('Orquestra'), ('Poema Sinf�nico'), ('Raps�dia'),
('Scherzo'), ('Su�te'), ('Toccata'), ('Varia��es')


INSERT INTO Label (endereco, endereco_site, nome)
VALUES ('rua de teste do bairro testante', 'www.teste.com.br', 'teste S/A')