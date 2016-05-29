SELECT *  FROM CD
INNER JOIN
(
SELECT * FROM Faixa f
JOIN Tipo_de_Composicao tc ON tc.codigo = f.tipo_composicao
)