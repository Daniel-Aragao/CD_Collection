INSERT INTO Faixa (codigo,numero,tipo_gravacao /* (ADD/DDD) */,descricao,codigo_CD ,codigo_compositor,tipo_composicao)

VALUES (42 /* codigo */,1 /* numero */,'DDD'/* tipo_gravacao */,'Hedwigs Theme'/* descricao */,
'5972'/* codigo_CD */,'281932'/* codigo_compositor */,'3175' /* tipo_composicao */ ),

VALUES (43 /* codigo */,2 /* numero */,'DDD'/* tipo_gravacao */,'Harry Potter'/* descricao */,
'5972'/* codigo_CD */,'281932'/* codigo_compositor */,'3175' /* tipo_composicao */ ),

VALUES (44 /* codigo */,3 /* numero */,'DDD'/* tipo_gravacao */,'Rony Weasley'/* descricao */,
'5972'/* codigo_CD */,'281932'/* codigo_compositor */,'3175' /* tipo_composicao */ ),

VALUES (45 /* codigo */,4 /* numero */,'DDD'/* tipo_gravacao */,'Hermione Granger'/* descricao */,
'5972'/* codigo_CD */,'281932'/* codigo_compositor */,'3175' /* tipo_composicao */ ),

VALUES (46 /* codigo */,5 /* numero */,'DDD'/* tipo_gravacao */,'Rubeus Hagrid'/* descricao */,
'5972'/* codigo_CD */,'281932'/* codigo_compositor */,'3175' /* tipo_composicao */ ),

VALUES (47 /* codigo */,6 /* numero */,'DDD'/* tipo_gravacao */,'Albus Dumbledore'/* descricao */,
'5972'/* codigo_CD */,'281932'/* codigo_compositor */,'3175' /* tipo_composicao */ ),

VALUES (48 /* codigo */,7 /* numero */,'DDD'/* tipo_gravacao */,'Severus Snape'/* descricao */,
'5972'/* codigo_CD */,'281932'/* codigo_compositor */,'3175' /* tipo_composicao */ ),

VALUES (49 /* codigo */,8 /* numero */,'DDD'/* tipo_gravacao */,'Dobby'/* descricao */,
'5972'/* codigo_CD */,'281932'/* codigo_compositor */,'3175' /* tipo_composicao */ ),

VALUES (50 /* codigo */,9 /* numero */,'DDD'/* tipo_gravacao */,'Fawkes'/* descricao */,
'5972'/* codigo_CD */,'281932'/* codigo_compositor */,'3175' /* tipo_composicao */ ),

VALUES (52 /* codigo */,10 /* numero */,'DDD'/* tipo_gravacao */,'Sirius Black'/* descricao */,
'5972'/* codigo_CD */,'281932'/* codigo_compositor */,'3175' /* tipo_composicao */ ),

VALUES (53 /* codigo */,11 /* numero */,'DDD'/* tipo_gravacao */,'Minerva McGonagall'/* descricao */,
'5972'/* codigo_CD */,'281932'/* codigo_compositor */,'3175' /* tipo_composicao */ ),

VALUES (5972 /* codigo */,12 /* numero */,'DDD'/* tipo_gravacao */,'Godric Gryffindor'/* descricao */,
'5972'/* codigo_CD */,'281932'/* codigo_compositor */,'3175' /* tipo_composicao */ ),

VALUES (55 /* codigo */,13 /* numero */,'DDD'/* tipo_gravacao */,'Salazar Slytherin'/* descricao */,
'5972'/* codigo_CD */,'281932'/* codigo_compositor */,'3175' /* tipo_composicao */ ),

VALUES (56 /* codigo */,14 /* numero */,'DDD'/* tipo_gravacao */,'Helga Hufflepuff'/* descricao */,
'5972'/* codigo_CD */,'281932'/* codigo_compositor */,'3175' /* tipo_composicao */ ),

VALUES (57 /* codigo */,281932 /* numero */,'DDD'/* tipo_gravacao */,'Rowena Ravenclaw'/* descricao */,
'5972'/* codigo_CD */,'281932'/* codigo_compositor */,'3175' /* tipo_composicao */ ),

VALUES (58 /* codigo */,16 /* numero */,'DDD'/* tipo_gravacao */,'Mischief Managed'/* descricao */,
'5972'/* codigo_CD */,'281932'/* codigo_compositor */,'3175' /* tipo_composicao */ ),

VALUES (123 /* codigo */,7 /* numero */,'DDD'/* tipo_gravacao */,'Party Rock Anthem'/* descricao */,
'5318008'/* codigo_CD */,'931975'/* codigo_compositor */,'0514' /* tipo_composicao */ )
____________________________________________________________________________________________________________________

CREATE TRIGGER Faixa_TR_numero_de_faixas
	ON Faixa
	FOR INSERT, UPDATE
	AS
	
	IF (SELECT SUM(codigo) FROM Faixa INNER JOIN inserted ON Faixa.codigo_CD = inserted.codigo_CD) >= 16

	BEGIN 
		RAISERROR ('Limite de faixas para este CD atingido')
		ROLLBACK TRANSACTION
	END