--SELECT *  FROM CD cd
--INNER JOIN
--(

--SELECT f.codigo, f.codigo_CD, f.descricao, f.numero, f.tipo_composicao, f.tipo_composicao, f.tipo_gravacao FROM Faixa f
--JOIN Tipo_de_Composicao tc ON tc.codigo = f.tipo_composicao
--JOIN Faixa_por_compositor fc on fc.codigo_faixa = f.codigo
--JOIN Compositor c on c.codigo = fc.codigo_compositor
--JOIN Periodo_Musical p on p.codigo = c.codigo_periodo_musical
--WHERE p.descricao = 'Barroco' AND tc.descricao = 'Concerto'

--) result on result.codigo_CD = cd.codigo
