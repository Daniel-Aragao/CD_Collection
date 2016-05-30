SELECT cd.* FROM CD cd

EXCEPT

SELECT cd.*  FROM CD cd
INNER JOIN
(

SELECT f.* FROM Faixa f
JOIN Tipo_de_Composicao tc ON tc.codigo = f.tipo_composicao
JOIN Faixa_por_compositor fc on fc.codigo_faixa = f.codigo
JOIN Compositor c on c.codigo = fc.codigo_compositor
JOIN Periodo_Musical p on p.codigo = c.codigo_periodo_musical
WHERE p.descricao != 'Barroco' OR tc.descricao != 'Concerto'

) result on result.codigo_CD = cd.codigo


-- criar cd com duas faixas onde todas são barroco(3) e concerto(4) 
-- e um cd com 3 onde uma não é barroco ou o concerto