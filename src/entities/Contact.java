package entities;

import java.util.ArrayList;
import java.util.List;

public class Contact {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private List<Adress> adresses;
	private List<PhoneNumber> phoneNumbers;
	private ContactGroup contactGroup;

	public Contact(int id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public Contact() {
		adresses = new ArrayList<Adress>();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void addAdress(Adress a){
		adresses.add(a);
	}
	public List<Adress> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adress> list) {
		this.adresses = list;
	}

	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public ContactGroup getContactGroup() {
		return contactGroup;
	}

	public void setContactGroup(ContactGroup contactGroup) {
		this.contactGroup = contactGroup;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", adresses=" + adresses
				+ ", phoneNumbers=" + phoneNumbers + ", contactGroup="
				+ contactGroup + "]";
	}

}
