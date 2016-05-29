package cdc.entitys;

public class Faixa {
	private int codigo;
	private int numero;
	private String tipo_gravacao;// CHAR(3)
	private String descricao; //VARCHAR(200)
	private int codigo_CD;
	private int codigo_compositor;
	private int codigo_interprete;
	private int tipo_composicao;
	
	public Faixa(int codigo, int numero, String tipo_gravacao, String descricao, int codigo_CD, int codigo_compositor,
			int codigo_interprete, int tipo_composicao) {
		this.codigo = codigo;
		this.numero = numero;
		this.tipo_gravacao = tipo_gravacao;
		this.descricao = descricao;
		this.codigo_CD = codigo_CD;
		this.codigo_compositor = codigo_compositor;
		this.codigo_interprete = codigo_interprete;
		this.tipo_composicao = tipo_composicao;
	}
	
	public Faixa(int numero, String tipo_gravacao, String descricao, 
			int codigo_compositor, int codigo_interprete, int tipo_composicao) {		
		this.numero = numero;
		this.tipo_gravacao = tipo_gravacao;
		this.descricao = descricao;
		this.codigo_compositor = codigo_compositor;
		this.codigo_interprete = codigo_interprete;
		this.tipo_composicao = tipo_composicao;
	}
	@Override
	public String toString(){
		return getDescricao();
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getTipo_gravacao() {
		return tipo_gravacao;
	}
	public void setTipo_gravacao(String tipo_gravacao) {
		this.tipo_gravacao = tipo_gravacao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getCodigo_CD() {
		return codigo_CD;
	}
	public void setCodigo_CD(int codigo_CD) {
		this.codigo_CD = codigo_CD;
	}
	public int getCodigo_compositor() {
		return codigo_compositor;
	}
	public void setCodigo_compositor(int codigo_compositor) {
		this.codigo_compositor = codigo_compositor;
	}
	public int getTipo_composicao() {
		return tipo_composicao;
	}
	public void setTipo_composicao(int tipo_composicao) {
		this.tipo_composicao = tipo_composicao;
	}

	public int getCodigo_interprete() {
		return codigo_interprete;
	}

	public void setCodigo_interprete(int codigo_interprete) {
		this.codigo_interprete = codigo_interprete;
	}
}
