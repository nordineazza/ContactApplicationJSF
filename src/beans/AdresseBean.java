package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import services.AdresseService;
import entities.Adress;

@ManagedBean(name="adresseBean")
public class AdresseBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Adress adresse;
	
	public Adress getAdresse() {
		if(adresse == null)
			adresse = new Adress();
		return adresse;
	}

	public void setAdresse(Adress adresse) {
		this.adresse = adresse;
	}
	
	public String ajouterAdresse(int idContact) {
		
		AdresseService adresseService = new AdresseService();
		System.out.println(adresse.toString());
		//adresseService.ajoutAdress(adresse, idContact);
		return ("contact?id=" + idContact);
	}

}
