SELECT (*) 
FROM CD 
WHERE (SELECT nome 
FROM Compositor c INNER JOIN Faixa f ON (c.codigo = f.codigo_compositor) INNER JOIN CD d ON(f.codigo_CD = d.codigo)) = 'Bach'