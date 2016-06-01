CREATE TRIGGER CD_Data_Preco
	ON CD
	FOR INSERT
	AS
	
	DECLARE @preco DECIMAL(10,2), @media DECIMAL(10,2) 
		
SELECT @media = AVG(cds.preco_compra)
FROM 
(SELECT cd.* FROM CD cd EXCEPT SELECT cd.* FROM CD cd JOIN Faixa f ON f.codigo_CD = cd.codigo WHERE f.tipo_gravacao <> 'DDD') cds

SELECT @preco = i.preco_compra FROM inserted i

IF (@media * 3) < @preco 

	BEGIN

	RAISERROR ('Pre�o muito alto',10,1)

	ROLLBACK TRANSACTION

	END		