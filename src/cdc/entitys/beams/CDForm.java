package cdc.entitys.beams;

import java.io.IOException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import cdc.Infra.RepositorioCD;
import cdc.entitys.CD;

@ManagedBean(name="CDForm")
@RequestScoped

public class CDForm {
	private CD cdSearch;
	private ArrayList<CD> lista;
	
	
	public CDForm (){
		cdSearch = new CD(); 
		lista = new ArrayList<CD>();
	}

	public String search(){
		if(!cdSearch.getDescricao().isEmpty()){
			lista = new RepositorioCD().get(cdSearch.getDescricao());			
		}
		
		return "index";
	}
	
	public String edit(CD cd){
		
		return null;
	}
	
	public String remove(CD cd){
		
		return null;
	}

	public CD getCdSearch() {
		return cdSearch;
	}	


	public void setCdSearch(CD cdSearch) {
		this.cdSearch = cdSearch;
	}

	public ArrayList<CD> getLista() {
		return lista;
	}

	public void setLista(ArrayList<CD> lista) {
		this.lista = lista;
	}
	
	
}
