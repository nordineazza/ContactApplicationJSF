package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import services.JDBC;
import entities.Contact;

public class ContactDAO {
	private JDBC jdbc;
	
	/**
	 * DAO d'ajout d'un contact dans la base de donnée
	 * @param c instance de Contact
	 * @return true si le contact a été correctement ajouté, false sinon
	*/
	public boolean ajouterContact(Contact c) {
		try {
			jdbc = new JDBC();
			String sql1 = "INSERT INTO contact(firstName, lastName, email) VALUES('"
					+ c.getFirstName()
					+ "','"
					+ c.getLastName()
					+ "','"
					+ c.getEmail() + "')";
			Statement stmt = jdbc.getConnection().createStatement();
			stmt.executeUpdate(sql1);

			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	/**
	 * DAO d'ajout d'un contact dans la base de donnée (en utilisant les requêtes préparées)
	 * @param c instance de Contact
	 * @return int qui correspond à l'id du contact inséré
	*/
	public int ajouterContactPS(Contact c) {
		try {
			jdbc = new JDBC();
			String sql = "INSERT INTO contact(firstName, lastName, email) VALUES(?,?,?)";
			Connection connection = (Connection) jdbc.getConnection();
			PreparedStatement statement = (PreparedStatement) connection
					.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, c.getFirstName());
			statement.setString(2, c.getLastName());
			statement.setString(3, c.getEmail());

			statement.executeUpdate();
			ResultSet generatedKeys = statement.getGeneratedKeys();
			if (generatedKeys.next())
				c.setId(generatedKeys.getInt(1));
			return c.getId();
		} catch (SQLException e) {
			return -1;
		}
	}

	public List<Contact> listeContact() {

		try {
			jdbc = new JDBC();
			int id;
			String lastName, firstName, email;
			String sql = "SELECT * FROM contact";
			Statement stmt = jdbc.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			List<Contact> mesContacts = new ArrayList<Contact>();

			while (rs.next()) {
				id = rs.getInt("id");
				lastName = rs.getString("lastName");
				firstName = rs.getString("firstName");
				email = rs.getString("email");
				Contact c = new Contact(id, firstName, lastName, email);
				mesContacts.add(c);
			}
			return mesContacts;
		} catch (SQLException e) {

		}
		return null;
	}

	public boolean supprimerContact(int idContact) {
		try {
			jdbc = new JDBC();
			String sql = "DELETE FROM contact WHERE id = " + idContact;
			Statement stmt = jdbc.getConnection().createStatement();
			stmt.executeUpdate(sql);
			System.out.println("supp OK");
			return true;
		} catch (SQLException e) {
			System.err.println("SQLException : " + e.getMessage());
			return false;
		}
	}

	public Contact getContactById(int idContact) {
		try {
			jdbc = new JDBC();
			AdressDAO adressDAO = new AdressDAO();
			PhoneNumberDAO phoneNumberDAO = new PhoneNumberDAO();
			ContactGroupDAO contactGroupDAO = new ContactGroupDAO();
			int id;
			String lastName, firstName, email;
			String sql = "SELECT * FROM contact c "
					+ "WHERE id = " + idContact;
			Statement stmt = jdbc.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			Contact c = null;

			while (rs.next()) {
				id = rs.getInt("id");
				lastName = rs.getString("lastName");
				firstName = rs.getString("firstName");
				email = rs.getString("email");
				c = new Contact(id, firstName, lastName, email);
			}
			c.setAdresses(adressDAO.getAdressByIdContact(idContact));
			c.setPhoneNumbers(phoneNumberDAO.getPhoneNumberByIdContact(idContact));
			c.setContactGroup(contactGroupDAO.getGroupNameByIdContact(idContact));
			
			return c;
		} catch (SQLException e) {

		}
		return null;
	}

}
