SELECT l.nome FROM Label l
JOIN 
(SELECT l.codigo, AVG(cd.preco_compra) as media  FROM Label l
JOIN CD cd ON cd.cod_label = l.codigo
GROUP BY l.codigo) m ON m.codigo = l.codigo

WHERE m.media = 

(SELECT max(m.media) FROM 
(SELECT l.codigo, AVG(cd.preco_compra) as media  FROM Label l
JOIN CD cd ON cd.cod_label = l.codigo
GROUP BY l.codigo) m)
