SELECT (*) 
FROM CD 
WHERE 'Bach' = (SELECT nome 
FROM Compositor c 
INNER JOIN Faixa_por_compositor fc ON (c.codigo = fc.codigo_compositor)
INNER JOIN Faixa f ON (fc.codigo_faixa = f.codigo) 
INNER JOIN  CD d ON (f.codigo_CD = d.codigo)
)