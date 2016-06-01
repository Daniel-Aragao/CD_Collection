SELECT l.nome FROM Label l
JOIN (SELECT l.codigo, COUNT(c.cod_label) total FROM Label l 
		JOIN (SELECT DISTINCT cd.codigo, cd.cod_label FROM CD cd
				JOIN Faixa f ON f.codigo_CD = cd.codigo
				JOIN Faixa_por_compositor fc ON fc.codigo_faixa = f.codigo
				JOIN Compositor c ON c.codigo = fc.codigo_compositor
				WHERE c.nome = 'Josquin des Prez') c ON c.cod_label = l.codigo
		GROUP BY l.codigo) t ON t.codigo = l.codigo
WHERE t.total = (SELECT MAX(t.total) FROM(
					SELECT l.nome, COUNT(c.cod_label) total FROM Label l 
					JOIN (SELECT DISTINCT cd.codigo, cd.cod_label FROM CD cd
							JOIN Faixa f ON f.codigo_CD = cd.codigo
							JOIN Faixa_por_compositor fc ON fc.codigo_faixa = f.codigo
							JOIN Compositor c ON c.codigo = fc.codigo_compositor
							WHERE c.nome = 'Josquin des Prez') c ON c.cod_label = l.codigo
					GROUP BY l.nome) t)
