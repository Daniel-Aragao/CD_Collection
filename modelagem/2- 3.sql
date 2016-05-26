CREATE CLUSTERED
	INDEX idx_pr_cod_cd
		ON Faixa(codigo)
 
CREATE NONCLUSTERED
    INDEX idx_sec_tipo_comp
        ON Faixa(tipo_composicao)