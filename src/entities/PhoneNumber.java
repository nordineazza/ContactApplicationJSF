package entities;

public class PhoneNumber {
	
	private int id;
	private int idContact;
	private String phoneKind;
	private String phoneNumber;
		
	public PhoneNumber(int id, int idContact, String phoneKind,
			String phoneNumber) {
		super();
		this.id = id;
		this.idContact = idContact;
		this.phoneKind = phoneKind;
		this.phoneNumber = phoneNumber;
	}
	
	public PhoneNumber() {

	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdContact() {
		return idContact;
	}
	public void setIdContact(int idContact) {
		this.idContact = idContact;
	}
	public String getPhoneKind() {
		return phoneKind;
	}
	public void setPhoneKind(String phoneKind) {
		this.phoneKind = phoneKind;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "PhoneNumber [id=" + id + ", idContact=" + idContact
				+ ", phoneKind=" + phoneKind + ", phoneNumber=" + phoneNumber
				+ "]";
	}
	
	

}
