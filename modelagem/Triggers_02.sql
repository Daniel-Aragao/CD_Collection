CREATE TRIGGER Faixa_TR_periodo_barroco
	ON Faixa
	FOR INSERT, UPDATE
	AS
	
	IF (SELECT tipo_gravacão FROM Inserted) <> 'DDD'
	AND (SELECT descricao FROM Periodo_Musical INNER JOIN Compositor ON (codigo = codigo_periodo_musical) 
	INNER JOIN Faixa_por_compositor ON (codigo = codigo_compositor) INNER JOIN Inserted ON (codigo_faixa = codigo) = 'Barroco'
	BEGIN 
		RAISERROR ('Faixa do Periodo Barroco, necessita gravacao tipo DDD')
		ROLLBACK TRANSACTION
	END