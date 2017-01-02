package services;

import dao.ContactGroupDAO;
import entities.ContactGroup;

public class ContactGroupService {
	
	public boolean ajoutContactGroup(ContactGroup cg, int idContact){
		return new ContactGroupDAO().ajoutContactGroup(cg, idContact);
		
	}

}
