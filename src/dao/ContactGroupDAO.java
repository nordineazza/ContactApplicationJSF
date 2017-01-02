package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import services.JDBC;
import entities.ContactGroup;

public class ContactGroupDAO {
	
	private JDBC jdbc;
	
	public boolean ajoutContactGroup(ContactGroup cg, int idContact) {

		jdbc = new JDBC();
		try {
			String sql;
			int groupId = this.isGroupName(cg);
			Connection connection = (Connection) jdbc.getConnection();

			// Si le nom du groupe n'existe pas, on le rajoute à la table
			// contactgroup
			if (groupId == -1) {
				sql = "INSERT INTO contactgroup (groupName) VALUES(?)";
				PreparedStatement statement = (PreparedStatement) connection
						.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, cg.getGroupName());
				statement.executeUpdate();

				// On récupère l'id du GroupContact (groupId) pour l'insérer
				// dans la table books
				ResultSet generatedKeys = statement.getGeneratedKeys();
				if (generatedKeys.next())
					cg.setGroupId(generatedKeys.getInt(1));

				sql = "INSERT INTO books (idGroup, idContact) VALUES(?,?)";
				statement = (PreparedStatement) connection.prepareStatement(
						sql, Statement.RETURN_GENERATED_KEYS);
				statement.setInt(1, cg.getGroupId());
				statement.setInt(2, idContact);
				statement.executeUpdate();
			} else {
				sql = "INSERT INTO books (idGroup, idContact) VALUES(?,?)";
				PreparedStatement statement = (PreparedStatement) connection
						.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				statement.setInt(1, groupId);
				statement.setInt(2, idContact);
				statement.executeUpdate();
			}

			return true;
		} catch (SQLException e) {
			return false;

		}

	}
	
	public int isGroupName(ContactGroup cg)
	{
		try {
			String sql;
			int groupId = 0;
			sql = "SELECT groupId FROM  contactgroup WHERE groupName LIKE '%"
					+ cg.getGroupName() + "%'";

			ResultSet groupIdRS;
			Statement stmt = jdbc.getConnection().createStatement();
			groupIdRS = stmt.executeQuery(sql);
			if (groupIdRS.next()) {
				groupId = groupIdRS.getInt(1);
				System.out.println(groupId);
			}
			System.out.println("2: " + groupId);
			return (groupId != 0) ? groupId : -1;
		}catch (SQLException e) {
			return -1;
		}
	}
	
	public ContactGroup getGroupNameByIdContact(int idContact) {
		try {
			jdbc = new JDBC();
			int groupId;
			String groupName;
			String sql = "SELECT * FROM contactgroup c "
					+ "INNER JOIN books b ON c.groupId = b.idGroup "
					+ "WHERE b.idContact = " + idContact;
			Statement stmt = jdbc.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ContactGroup cg = null;

			while (rs.next()) {
				groupId = rs.getInt("c.groupId");
				groupName = rs.getString("c.groupName");
				cg = new ContactGroup(groupId, groupName);
			}

			return cg;
		} catch (SQLException e) {

		}
		return null;
	}

}
