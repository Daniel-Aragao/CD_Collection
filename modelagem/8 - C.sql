SELECT DISTINCT cd.* FROM CD cd 
JOIN Faixa f ON f.codigo_CD = cd.codigo
JOIN Faixa_por_compositor fc ON fc.codigo_faixa = f.codigo
JOIN Compositor c ON c.codigo = fc.codigo_compositor
WHERE c.nome = 'Josquin des Prez'