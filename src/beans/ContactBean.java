package beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import services.AdresseService;
import services.ContactGroupService;
import services.ContactService;
import services.PhoneNumberService;
import entities.*;

@ManagedBean(name = "contactBean")
public class ContactBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Contact contact;
	private Adress adresse;
	private PhoneNumber phoneNumber;
	private ContactGroup contactGroup;
	//private AdresseBean adresseBean;

	/**
	 * Retourne un objet de ContactGroup, le cr�er s'il n'existe pas.
	 * @return ContactGroup
	 */
	public ContactGroup getContactGroup() {
		if (contactGroup == null)
			contactGroup = new ContactGroup();
		return contactGroup;
	}
	/**
	 * Setter
	 * @param contactGroup
	 */
	public void setContactGroup(ContactGroup contactGroup) {
		this.contactGroup = contactGroup;
	}
	/**
	 * Retourne un objet de PhoneNumber, le cr�er s'il n'existe pas.
	 * @return PhoneNumber
	 */
	public PhoneNumber getPhoneNumber() {
		if (phoneNumber == null)
			phoneNumber = new PhoneNumber();
		return phoneNumber;
	}
	/**
	 * Setter
	 * @param phoneNumber
	 */
	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * Retourne un objet de type Adress, le cr�er s'il n'existe pas.
	 * @return Adress
	 */
	public Adress getAdresse() {
		if (adresse == null)
			adresse = new Adress();
		return adresse;
	}
	/**
	 * Setter
	 * @param adresse
	 */
	public void setAdresse(Adress adresse) {
		this.adresse = adresse;
	}
	/**
	 * Retourne un objet de type Contact, le cr�er s'il n'existe pas.
	 * @return Contact
	 */
	public Contact getContact() {
		if (contact == null)
			contact = new Contact();
		return contact;
	}
	/**
	 * Setter
	 * @param contact
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	/**
	 * M�thode d'ajout d'un Contact via le formulaire d'ajout.
	 */
	public void ajouterContact() {
		//On passe par les diff�rents services afin d'appeler la DAO.
		ContactService contactService = new ContactService();
		PhoneNumberService phoneNumberService = new PhoneNumberService();
		ContactGroupService contactGroupService = new ContactGroupService();
		AdresseService adresseService = new AdresseService();
		int idContact = contactService.ajouterContactPS(contact); //La m�thode retourne -1 si l'insertion s'est mal d�roul�e.
		// Si l'insertion s'est bien d�roul� et qu'on a r�cup�r� l'idContact
		if (idContact != -1) {
			adresseService.ajoutAdress(adresse, idContact);
			phoneNumberService.ajoutTelephone(phoneNumber, idContact);
			contactGroupService.ajoutContactGroup(contactGroup, idContact);
		}
	}
	/**
	 * Retourne un Contact par son Identifiant en base de donn�e.
	 * @param idContact int qui correspond � l'id du Contact voulu.
	 * @return Contact
	 */
	public Contact getContactById(int idContact) {
		ContactService contactService = new ContactService();
		Contact c = contactService.getContactById(idContact);
		return c;
	}
	/**
	 * Supprime un contact via son identifiant en base de donn�e.
	 * @param idContact int qui correspond � l'id du Contact � supprimer.
	 */
	public void supprimerContact(int idContact) {
		System.out.println("test: " + idContact);
		//System.out.println("Essai 2: " + contact.getId());
		//ContactService contactService = new ContactService();
		//contactService.supprimerContact(idContact);
	}

	/**
	 * Retourne la liste enti�re de contact enregistr�e.
	 * @return List d'objet Contact
	 */
	public List<Contact> listeContact() {
		ContactService contactService = new ContactService();
		return contactService.listeContact();
	}

}
