package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import services.JDBC;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import entities.PhoneNumber;

public class PhoneNumberDAO {

	private JDBC jdbc;
	
	public boolean ajoutTelephone(PhoneNumber p, int idContact) {
		jdbc = new JDBC();

		try {
			Connection connection = (Connection) jdbc.getConnection();
			String sql = "INSERT INTO phonenumber(idContact,phoneKind,phoneNumber) VALUES(?,?,?)";
			PreparedStatement statement;

			statement = (PreparedStatement) connection.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);

			statement.setInt(1, idContact);
			statement.setString(2, p.getPhoneKind());
			statement.setString(3, p.getPhoneNumber());

			statement.executeUpdate();

			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public List<PhoneNumber> getPhoneNumberByIdContact(int idContact) {
		try {
			jdbc = new JDBC();
			int id;
			String phoneNumber, phoneKind;
			String sql = "SELECT * FROM phonenumber "
					+ "WHERE idContact = " + idContact;
			Statement stmt = jdbc.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();

			while (rs.next()) {
				id = rs.getInt("id");
				phoneNumber = rs.getString("phoneNumber");
				phoneKind = rs.getString("phoneKind");
				PhoneNumber pn = new PhoneNumber(id, idContact, phoneKind, phoneNumber);
				phoneNumbers.add(pn);
			}
					
			return phoneNumbers;
		} catch (SQLException e) {

		}
		return null;
	}
}
