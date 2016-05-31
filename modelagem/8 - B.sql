SELECT nome 
FROM Label 
WHERE MAX (SELECT COUNT(c.codigo) 
FROM Label l, CD d INNER JOIN Faixa f ON (d.codigo = f.codigo_CD) INNER JOIN Compositor c ON(f.codigo_compositor = c.codigo) 
WHERE d.cod_label = l.codigo AND c.nome = 'Dvorack')