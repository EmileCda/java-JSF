package fr.emile.jsfsix.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.emile.jsfsix.common.IConstant;
import fr.emile.jsfsix.entity.Address;
import fr.emile.jsfsix.entity.BankCard;
import fr.emile.jsfsix.entity.Order;
import fr.emile.jsfsix.entity.User;
import fr.emile.jsfsix.model.connection.DatabaseConnection;
import fr.emile.jsfsix.utils.Utils;

public class UserDao implements IUserDao, IConstant {

	public UserDao() {
	}

//-----------------------------------------------------------------------------

	@Override
	public User add(User user) throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DatabaseConnection.getConnection();
			String sqlRequest = "INSERT INTO user(firstname, lastname, date_of_birth, `is_deleted`)"+
			"VALUES(?,?,?,?)";
			preparedStatement = connection.prepareStatement(sqlRequest, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, user.getFirstname());
			preparedStatement.setString(2, user.getLastname());
			preparedStatement.setDate(3, Utils.toSqlDate(user.getDateOfBirth()));
			preparedStatement.setBoolean(4, user.isDeleted());

			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet != null && resultSet.next()) {
				user.setId(resultSet.getInt(1));
				return  user ;
			}
		} finally {
			this.closeStream(connection, preparedStatement, resultSet);
		}
		return user ;

	}
//-----------------------------------------------------------------------------

	@Override
	public List<User> get() throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<User> userList = null;
		try {
			connection = DatabaseConnection.getConnection();
			String sqlRequest = "SELECT `id`, `firstname`, `lastname`,"+
					"`date_of_birth`, `is_deleted` "+
					"FROM `user` WHERE 1";
			preparedStatement = connection.prepareStatement(sqlRequest);

			preparedStatement.execute();
			resultSet = preparedStatement.getResultSet();

			if (resultSet != null) {
				final IAddressDao myAddressDao = new AddressDao();
				final IBankCardDao myBankCardDao = new BankCardDao();
				final IOrderDao myOrderDao = new OrderDao();
				userList = new ArrayList<>();
				List<Address> addressList = new ArrayList<>();
				List<BankCard> bankCardList = new ArrayList<>();
				List<Order> orderList = new ArrayList<>();

				while (resultSet.next()) {
					User user = new User(resultSet.getInt("id"), resultSet.getString("firstname"),
							resultSet.getString("lastname"),
							Utils.toJavaDate(resultSet.getDate("date_of_birth")),
							resultSet.getBoolean("is_deleted")		);

					addressList = myAddressDao.get(user.getId());
					user.addAddress(addressList);
					bankCardList = myBankCardDao.get(user);
					user.addBankCard(bankCardList);

					orderList = myOrderDao.get(user);
					user.addOrder(orderList);

					userList.add(user);
				}
			}
		} finally {
			this.closeStream(connection, preparedStatement, resultSet);
		}
		return userList;
	}

//-----------------------------------------------------------------------------

	@Override
	public User get(int id) throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User user = null;
		try {
			connection = DatabaseConnection.getConnection();
			String sqlRequest = "SELECT `id`, `firstname`, `lastname`,"+
					"`date_of_birth`, `is_deleted` "+
					"FROM `user` WHERE id = ?";

			preparedStatement = connection.prepareStatement(sqlRequest);
			preparedStatement.setInt(1, id);
//			Utils.trace(prepareStatement.toString());

			preparedStatement.execute();
			resultSet = preparedStatement.getResultSet();

			if (resultSet != null && resultSet.next()) {
				user = new User(resultSet.getInt("id"), resultSet.getString("firstname"),
						resultSet.getString("lastname"),
						Utils.toJavaDate(resultSet.getDate("date_of_birth")),
						resultSet.getBoolean("is_deleted")		);


				List<Address> addressList = new ArrayList<>();
				List<BankCard> bankCardList = new ArrayList<>();
				List<Order> orderList = new ArrayList<>();
				final IAddressDao myAddressDao = new AddressDao();
				final IBankCardDao myBankCardDao = new BankCardDao();
				final IOrderDao myOrderDao = new OrderDao();

				addressList = myAddressDao.get(user.getId());
				user.addAddress(addressList);
				bankCardList = myBankCardDao.get(user);
				user.addBankCard(bankCardList);
				orderList = myOrderDao.get(user);
				user.addOrder(orderList);
			}
		} finally {
			this.closeStream(connection, preparedStatement, resultSet);
		}
		return user;
	}
//-----------------------------------------------------------------------------

	@Override
	public int Update(User user) throws Exception {
		Connection connection = null;
		int result = 0;
		PreparedStatement preparedStatement = null;
		try {
			connection = DatabaseConnection.getConnection();
			String sqlRequest = "UPDATE user SET "+
					"firstname = ?, lastname = ?, date_of_birth = ?,`is_deleted`=? "+
					"WHERE id = ?";

			preparedStatement = connection.prepareStatement(sqlRequest);
			preparedStatement.setString(1, user.getFirstname());
			preparedStatement.setString(2, user.getLastname());
			preparedStatement.setDate(3, Utils.toSqlDate(user.getDateOfBirth()));
			preparedStatement.setBoolean(4, user.isDeleted());
			preparedStatement.setInt(5, user.getId());

			result = preparedStatement.executeUpdate();

		} finally {

			this.closeStream(connection, preparedStatement);
		}
		return result;
	}

	//-----------------------------------------------------------------------------
		@Override
		public int delete(User user) throws Exception {
			return delete(user, true);
		}

		//-----------------------------------------------------------------------------
		@Override
		public int delete(User user,boolean isDeleted) throws Exception {
			return delete(user.getId(), isDeleted);
		}

//-----------------------------------------------------------------------------
		@Override
		public int delete(int id) throws Exception {
			return delete(id, true);
		}
//-----------------------------------------------------------------------------
			@Override
			public int delete(int id, boolean isDeleted) throws Exception {
				int result = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DatabaseConnection.getConnection();
			String sqlRequest = "UPDATE user SET "+
					"`is_deleted`= ? "+
					"WHERE id = ?";
			preparedStatement = connection.prepareStatement(sqlRequest);
			preparedStatement.setBoolean(1, isDeleted);
			preparedStatement.setInt(2, id);

			result = preparedStatement.executeUpdate();

		} finally {

			this.closeStream(connection, preparedStatement);
		}
		return result;

	}
//-----------------------------------------------------------------------------

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
