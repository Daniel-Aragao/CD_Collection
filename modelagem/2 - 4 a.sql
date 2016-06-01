CREATE TRIGGER Faixa_TR_periodo_barroco
	ON Faixa
	FOR INSERT, UPDATE
	AS
	
	IF (SELECT tipo_gravacão FROM Inserted) <> 'DDD'
	AND (SELECT descricao FROM Periodo_Musical 
	INNER JOIN Compositor ON (Periodo_Musical.codigo = Compositor.codigo_periodo_musical) 
	INNER JOIN Faixa_por_compositor ON (Compositor.codigo = Faixa_por_compositor.codigo_compositor) 
	INNER JOIN Inserted ON (Faixa_por_compositor.codigo_faixa = Inserted.codigo)) = 'Barroco'
	BEGIN 
		RAISERROR ('Faixa do Periodo Barroco, necessita gravacao tipo DDD',10,1)
		ROLLBACK TRANSACTION
	END