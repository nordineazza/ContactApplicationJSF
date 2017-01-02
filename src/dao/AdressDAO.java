package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import services.JDBC;
import entities.Adress;

public class AdressDAO {
	
	private JDBC jdbc;
	
	/**
	 * Méthode d'ajout d'une adresse dans la BD
	 * @param a instance de la classe Adress
	 * @param idContact int identifiant d'un contact
	 * @return boolean, true si l'insertion s'est bien déroulée, false sinon
	 */
	public boolean ajoutAdresse(Adress a, int idContact) {
		try {
			jdbc = new JDBC();
			String sql;
			Statement stmt = jdbc.getConnection().createStatement();

			sql = "INSERT INTO address(idContact, street, city, zip, country) VALUES("
					+ idContact
					+ ",'"
					+ a.getStreet()
					+ "','"
					+ a.getCity()
					+ "','" + a.getZip() + "','" + a.getCountry() + "')";
			stmt.executeUpdate(sql);
			return true;
			
		} catch (SQLException e) {
			return false;
		}
	}
	
	public List<Adress> getAdressByIdContact(int idContact) {
		try {
			jdbc = new JDBC();
			int id;
			String street, city, zip, country;
			String sql = "SELECT * FROM address "
					+ "WHERE idContact = " + idContact;
			Statement stmt = jdbc.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			List<Adress> adresses = new ArrayList<Adress>();

			while (rs.next()) {
				id = rs.getInt("id");
				street = rs.getString("street");
				city = rs.getString("city");
				zip = rs.getString("zip");
				country = rs.getString("country");
				Adress a = new Adress(id, idContact, street, city, zip, country);
				adresses.add(a);
			}
					
			return adresses;
		} catch (SQLException e) {

		}
		return null;
	}
}
