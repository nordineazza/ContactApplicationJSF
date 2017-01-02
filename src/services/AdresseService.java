package services;

import dao.AdressDAO;
import entities.Adress;

public class AdresseService {
	/**
	 * M�thode d'ajout d'une adresse
	 * @param a instance d'une Adress
	 * @param idContact int id du dernier contact ajout�e
	 * @return boolean, true si l'ajout s'est bien effectu�e, false sinon
	 */
	public boolean ajoutAdress(Adress a, int idContact){
		return new AdressDAO().ajoutAdresse(a, idContact);
		
	}

}
