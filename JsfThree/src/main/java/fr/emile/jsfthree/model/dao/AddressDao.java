package fr.emile.jsfthree.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.emile.jsfthree.entity.Address;
import fr.emile.jsfthree.entity.User;
import fr.emile.jsfthree.common.IConstant;
import fr.emile.jsfthree.model.connection.DatabaseConnection;

public class AddressDao implements IAddressDao, IConstant {

	public AddressDao() {
	}
//-----------------------------------------------------------------------------	

	public Address add(Address address) throws Exception {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DatabaseConnection.getConnection();
			String sqlRequest = "INSERT INTO address(" + "number, street, city,zip_code,user_id,is_valid)"
					+ "VALUES(?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sqlRequest, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, address.getNumber());
			preparedStatement.setString(2, address.getStreet());
			preparedStatement.setString(3, address.getCity());
			preparedStatement.setString(4, address.getZipCode());
			preparedStatement.setInt(5, address.getIdUser());
			preparedStatement.setBoolean(6, address.isValide());

			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet != null && resultSet.next()) {
				address.setId(resultSet.getInt(1));
				return address;
			}
		} finally {
			this.closeStream(connection, preparedStatement, resultSet);
		}
		return address;
	}

	// -----------------------------------------------------------------------------
	public List<Address> get() throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Address> addressList = null;
		try {
			connection = DatabaseConnection.getConnection();
			String sqlRequest = "SELECT `id`, `number`, `street`,"+ 
					"`city`, `zip_code`, `user_id`, `is_valid`, `is_delete` " + 
					"FROM `address` WHERE 1";
			preparedStatement = connection.prepareStatement(sqlRequest);

			preparedStatement.execute();
			resultSet = preparedStatement.getResultSet();

			if (resultSet != null) {
				addressList = new ArrayList<Address>();
				while (resultSet.next()) {
					Address address = new Address(resultSet);

					addressList.add(address);
				}
			}
		} finally {
			this.closeStream(connection, preparedStatement, resultSet);
		}
		return addressList;
	}

// -----------------------------------------------------------------------------
	public List<Address> get(User user) throws Exception {

		return this.get(user.getId());

	}

	// -----------------------------------------------------------------------------
	public List<Address> get(int userId) throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Address> addressList = null;
		try {
			connection = DatabaseConnection.getConnection();
			String sqlRequest = "SELECT `id`, `number`, `street`,"
					+ "`city`, `zip_code`, `user_id`, `is_valid`, `is_deleted` " + "FROM address WHERE user_id=? ";

			preparedStatement = connection.prepareStatement(sqlRequest);
			preparedStatement.setInt(1, userId);

			preparedStatement.execute();
			resultSet = preparedStatement.getResultSet();

			
		} finally {

			if (resultSet != null) {
				addressList = new ArrayList<Address>();
				while (resultSet.next()) {
					Address address = new Address(resultSet);

					addressList.add(address);
				}
			}
			this.closeStream(connection, preparedStatement, resultSet);
		}
		return addressList;
	}

	// -----------------------------------------------------------------------------
	public Address getById(int id) throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Address address = null;
		try {
			connection = DatabaseConnection.getConnection();
			String sqlRequest = "SELECT `id`, `number`, `street`," + 
					"`city`, `zip_code`, `user_id`, `is_valid`, `is_deleted` "+
					 "FROM address WHERE id=? ";

			preparedStatement = connection.prepareStatement(sqlRequest);
			preparedStatement.setInt(1, id);
//			Utils.trace(preparedStatement.toString());
			preparedStatement.execute();
			resultSet = preparedStatement.getResultSet();

			if (resultSet != null && resultSet.next()) {
				address = new Address(resultSet);

			}
		} finally {

			this.closeStream(connection, preparedStatement, resultSet);
		}
		return address;
	}

// -----------------------------------------------------------------------------
	public int Update(Address address) throws Exception {
		Connection connection = null;
		int result = 0;

		PreparedStatement preparedStatement = null;
		try {
			connection = DatabaseConnection.getConnection();
			String sqlRequest = "UPDATE address SET" + "number = ?, street = ?, city = ?, "
					+ "zip_code= ?, user_id = ?,is_valid = ?" + "WHERE id = ?";
			preparedStatement = connection.prepareStatement(sqlRequest);

			preparedStatement.setString(1, address.getNumber());
			preparedStatement.setString(2, address.getStreet());
			preparedStatement.setString(3, address.getCity());
			preparedStatement.setString(4, address.getZipCode());
			preparedStatement.setInt(5, address.getIdUser());
			preparedStatement.setBoolean(6, address.isValide());
			preparedStatement.setInt(7, address.getId());

			result = preparedStatement.executeUpdate();
		} finally {
			this.closeStream(connection, preparedStatement);
		}
		return result;
	}

// -----------------------------------------------------------------------------
	public int delete(int id) throws Exception {
		Connection connection = null;
		int result = 0;
		PreparedStatement preparedStatement = null;
		try {
			connection = DatabaseConnection.getConnection();
			String sqlRequest = "DELETE FROM address WHERE id = ?";
			preparedStatement = connection.prepareStatement(sqlRequest);
			preparedStatement.setInt(1, id);

			result = preparedStatement.executeUpdate();

		} finally {

			this.closeStream(connection, preparedStatement);
		}
		return result;

	}

	// -----------------------------------------------------------------------------

	// ---------------processing methode ---------------------
	private void closeStream(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet)
			throws Exception {

		if (resultSet != null && !resultSet.isClosed()) {
			resultSet.close();
		}
		if (preparedStatement != null && !preparedStatement.isClosed()) {
			preparedStatement.close();
		}
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}

	}

//-----------------------------------------------------------------------------
	private void closeStream(Connection connection, PreparedStatement preparedStatement) throws Exception {

		closeStream(connection, preparedStatement, null);

	}

}
