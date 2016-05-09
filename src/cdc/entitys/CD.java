package cdc.entitys;

import java.sql.Timestamp;

public class CD {
	private int codigo;
	private int cod_label;
	private Timestamp data_gravacao;
	private Timestamp data_compra;
	private String descricao;
	private Double preco_compra;
	
	public CD(){
		
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCod_label() {
		return cod_label;
	}
	public void setCod_label(int cod_label) {
		this.cod_label = cod_label;
	}
	public Timestamp getData_gravacao() {
		return data_gravacao;
	}
	public void setData_gravacao(Timestamp data_gravacao) {
		this.data_gravacao = data_gravacao;
	}
	public Timestamp getData_compra() {
		return data_compra;
	}
	public void setData_compra(Timestamp data_compra) {
		this.data_compra = data_compra;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getPreco_compra() {
		return preco_compra;
	}
	public void setPreco_compra(Double preco_compra) {
		this.preco_compra = preco_compra;
	}
}
