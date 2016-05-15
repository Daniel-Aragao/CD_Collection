CREATE TRIGGER CD_TR_periodo_barroco
	ON CD
	FOR INSERT, UPDATE
	AS
	
	IF (SELECT tipo_gravacão FROM Inserted INNER JOIN CD WHERE Inserted.codigo_CD = CD.codigo) <> 'DDD'
	AND (SELECT data_gravacao FROM CD INNER JOIN Inserted WHERE Inserted.codigo_CD = CD.codigo)
	BETWEEN ´01/01/1600´ AND ´01/01/1700´

	BEGIN 
		RAISERROR ('Faixa do Periodo Barroco, necessaria gravacao tipo DDD')
		ROLLBACK TRANSACTION
	END