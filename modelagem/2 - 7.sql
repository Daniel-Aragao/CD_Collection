CREATE VIEW nome_grav_qtd_cdf(Nome_gravadora, Qtd_CDs) WITH SCHEMABINDING
AS

SELECT g.nome Nome_gravadora, COUNT_BIG (*) Qtd_CDs 
FROM dbo.Label g, dbo.CD 
WHERE CD.cod_label = g.codigo
GROUP BY g.nome



CREATE UNIQUE CLUSTERED INDEX I_nome_grav_qtd_cd ON nome_grav_qtd_cdf(Nome_gravadora)