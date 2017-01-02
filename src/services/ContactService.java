package services;

import java.util.List;

import dao.ContactDAO;
import entities.Contact;

public class ContactService {
	
	/**
	 * Ajout d'un contact
	 * @param c instance de Contact
	 * @return boolean, true si l'insertion s'est bien d�roul�e, false sinon
	 */
	public boolean ajouterContact(Contact c){
		
		return new ContactDAO().ajouterContact(c);
	}

	/**
	 * Ajout d'un contact
	 * @param c instance de Contact
	 * @return int qui correspond � l'id du contact ins�r�
	 */
	public int ajouterContactPS(Contact c){
		
		return new ContactDAO().ajouterContactPS(c);
	}

	public List<Contact> listeContact() {

		return new ContactDAO().listeContact();
	}

	public boolean supprimerContact(int idContact) {

		return new ContactDAO().supprimerContact(idContact);
	}

	public Contact getContactById(int idContact) {

		return new ContactDAO().getContactById(idContact);
	}
}
