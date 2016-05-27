package cdc.entitys;

import java.util.ArrayList;
import java.util.Calendar;

public class CD {
	private int codigo;
	private int cod_label;
	private Calendar data_gravacao;
	private Calendar data_compra;
	private String descricao;
	private Double preco_compra;
	
	private ArrayList<Faixa> faixas;
		
	public CD(int codigo, int cod_label, Calendar data_gravacao, Calendar data_compra, String descricao,
			Double preco_compra) {
		this.codigo = codigo;
		this.cod_label = cod_label;
		this.data_gravacao = data_gravacao;
		this.data_compra = data_compra;
		this.descricao = descricao;
		this.preco_compra = preco_compra;
		faixas = new ArrayList<Faixa>();
	}
	
	public CD(int cod_label, Calendar data_gravacao, Calendar data_compra, String descricao,
			Double preco_compra) {
		this.cod_label = cod_label;
		this.data_gravacao = data_gravacao;
		this.data_compra = data_compra;
		this.descricao = descricao;
		this.preco_compra = preco_compra;
		faixas = new ArrayList<Faixa>();
	}

	public CD(){
		this.descricao = ""; 
		faixas = new ArrayList<Faixa>();
	}
	@Override
	public String toString(){
		return this.descricao;
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
	public Calendar getData_gravacao() {
		return data_gravacao;
	}
	public void setData_gravacao(Calendar data_gravacao) {
		this.data_gravacao = data_gravacao;
	}
	public Calendar getData_compra() {
		return data_compra;
	}
	public void setData_compra(Calendar data_compra) {
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

	public ArrayList<Faixa> getFaixas() {
		return faixas;
	}

	public void setFaixas(ArrayList<Faixa> faixas) {
		this.faixas = faixas;
	}
}
