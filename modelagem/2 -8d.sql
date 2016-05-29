SELECT c.nome Nome FROM Compositor c
INNER JOIN 

(SELECT fc.codigo_compositor, COUNT(fc.codigo_faixa) total FROM Faixa_por_compositor fc
GROUP BY fc.codigo_compositor) t ON t.codigo_compositor = c.codigo

WHERE t.total = 
(SELECT max(t.total) FROM (SELECT fc.codigo_compositor, COUNT(fc.codigo_faixa) total FROM Faixa_por_compositor fc
GROUP BY fc.codigo_compositor) t)