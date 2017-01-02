package services;

import dao.PhoneNumberDAO;
import entities.PhoneNumber;

public class PhoneNumberService {
	
	public boolean ajoutTelephone(PhoneNumber p, int idContact)
	{
		return new PhoneNumberDAO().ajoutTelephone(p,idContact);
	}

}
