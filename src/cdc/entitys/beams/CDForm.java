package cdc.entitys.beams;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import cdc.entitys.CD;

@ManagedBean(name="CDForm")
@RequestScoped

public class CDForm {
	private CD cdSearch;
	
	
	public CDForm (){
		cdSearch = new CD();
	}

//	public ArrayList search()
	

	public CD getCdSearch() {
		return cdSearch;
	}


	public void setCdSearch(CD cdSearch) {
		this.cdSearch = cdSearch;
	}
	
	
}
