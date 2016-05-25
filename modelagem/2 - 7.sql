CREATE VIEW nome_grav_qtd_cds
as
SELECT g.nome Nome_gravadora, COUNT (*) Qtd_CDs 
FROM Label g, CD 
WHERE CD.cod_label = g.codigo
GROUP BY g.nome