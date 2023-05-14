package fr.emile.jsffour.model.dao;

import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import fr.emile.jsffour.common.IConstant;
import fr.emile.jsffour.entity.Order;
import fr.emile.jsffour.entity.User;
import fr.emile.jsffour.model.connection.DatabaseConnection;
import fr.emile.jsffour.utils.Utils;

public class OrderDao implements IOrderDao, IConstant {

	public OrderDao() {
	}

//---------------------------------------------------------------------------------------------------------------------------------
	public Order add(Order order) throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = DatabaseConnection.getConnection();

			String request = "INSERT INTO `stuff_order` (`number`,"
			+"`create_date`,`cancellation_date`,`delivery_date`,`delivery_methode`,"
			+"`delivery_address_id`,`billing_address_id`,`user_id`,`bankcard_id`,`is_deleted`,`status`)"
			+"VALUES (?,?,?,?,?,?,?,?,?,?,?)";

			preparedStatement = connection.prepareStatement(request, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, order.getNumber());
			preparedStatement.setDate(2, Utils.toSqlDate(order.getCreateDate()));
			preparedStatement.setDate(3, Utils.toSqlDate(order.getCancellationDate()));
			preparedStatement.setDate(4, Utils.toSqlDate(order.getDeliveryDate()));
			preparedStatement.setString(5, order.getDeliveryMethod().getValue());
			preparedStatement.setInt(6, order.getDeliveryAddress().getId());
			preparedStatement.setInt(7, order.getBillingAddress().getId());
			preparedStatement.setInt(8, order.getUserId());
			preparedStatement.setInt(9, order.getBankCardUsed().getId());
			preparedStatement.setBoolean(10, order.isDeleted());
			preparedStatement.setString(11, order.getStatus().getValue());

			preparedStatement.executeUpdate();
			
			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet != null && resultSet.next()) {
				order.setId(resultSet.getInt(1));
				return order; 
			}
		} finally {
			this.closeStream(connection, preparedStatement, resultSet);
		}
		return order;
	}

//---------------------------------------------------------------------------------------------------------------------------------
	public Order get(int Id) throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Order  order = null;
		try {
			connection = DatabaseConnection.getConnection();
			String request = "SELECT id, number,create_date,delivery_date,cancellation_date,"
					+"delivery_methode,delivery_address_id,billing_address_id,user_id,bankcard_id,is_deleted,status "
					+"From stuff_order "
					+"WHERE id = ?";
			
			preparedStatement = connection.prepareStatement(request);
			preparedStatement.setInt(1, Id);
//			Utils.trace(preparedStatement.toString());
			preparedStatement.execute();
			resultSet = preparedStatement.getResultSet();

			if (resultSet != null && resultSet.next()) {
				final IAddressDao myAddressDao = new AddressDao();
				final IBankCardDao myBankCardDao = new BankCardDao();

				order = new Order(resultSet);
				order.setDeliveryAddress(myAddressDao.getById(resultSet.getInt("delivery_address_id")));
				order.setBillingAddress(myAddressDao.getById(resultSet.getInt("billing_address_id")));
				order.setBankCardUsed(myBankCardDao.get(resultSet.getInt("billing_address_id")));

			}
			
		} finally {
			this.closeStream(connection, preparedStatement, resultSet);
		}
		return order;
	}

//---------------------------------------------------------------------------------------------------------------------------------
	
	public List<Order> get(User user) throws Exception {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Order> orderList = null;
		try {
			connection = DatabaseConnection.getConnection();
			String request = "SELECT id, number,create_date,delivery_date,cancellation_date,"
					+"delivery_methode,delivery_address_id,billing_address_id,user_id,bankcard_id,is_deleted,status "
					+ "FROM stuff_order "
					+ "WHERE user_id = ? "
					+ "ORDER BY create_date DESC,bankcard_id ";
			preparedStatement = connection.prepareStatement(request);
			preparedStatement.setInt(1, user.getId());
//			Utils.trace(preparedStatement.toString());
			preparedStatement.execute();
			resultSet = preparedStatement.getResultSet();

			if (resultSet != null) {
				orderList = new ArrayList<Order>();
				final IAddressDao myAddressDao = new AddressDao();
				final IBankCardDao myBankCardDao = new BankCardDao();


				while (resultSet.next()) {
					System.out.println();
					Order order = new Order(resultSet);
					order.setDeliveryAddress(myAddressDao.getById(resultSet.getInt("delivery_address_id")));
					order.setBillingAddress(myAddressDao.getById(resultSet.getInt("billing_address_id")));
					order.setBankCardUsed(myBankCardDao.get(resultSet.getInt("billing_address_id")));

					orderList.add(order);
					
				}
			}
		} finally {
			this.closeStream(connection, preparedStatement, resultSet);
		}
//		Utils.trace(String.format("orderList.size :%d\n",orderList.size()));
		return orderList;
	}

//---------------------------------------------------------------------------------------------------------------------------------
	
	public List<Order> get() throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Order> orderList = null;
		try {
			connection = DatabaseConnection.getConnection();
			String request = "SELECT id, number,create_date,delivery_date,cancellation_date," + 
					"delivery_methode,delivery_address_id,billing_address_id,user_id,bankcard_id,is_deleted,status " +
					"FROM stuff_order " + 
					"ORDER BY user_id,create_date DESC, bankcard_id" ;
			
			preparedStatement = connection.prepareStatement(request);

//			Utils.trace(preparedStatement.toString());
			preparedStatement.execute();
			
			resultSet = preparedStatement.getResultSet();

			if (resultSet != null) {
				orderList = new ArrayList<Order>();
				final IAddressDao myAddressDao = new AddressDao();
				final IBankCardDao myBankCardDao = new BankCardDao();

				while (resultSet.next()) {
					Order order = new Order(resultSet);
					
					order.setDeliveryAddress(myAddressDao.getById(resultSet.getInt("delivery_address_id")));
					order.setBillingAddress(myAddressDao.getById(resultSet.getInt("billing_address_id")));
					order.setBankCardUsed(myBankCardDao.get(resultSet.getInt("billing_address_id")));
					
					orderList.add(order);
				}
			}
		} finally {
			this.closeStream(connection, preparedStatement, resultSet);
		}
		return orderList;
	}
//---------------------------------------------------------------------------------------------------------------------------------

	
	public int Update(Order order) throws Exception {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;

		try {

			connection = DatabaseConnection.getConnection();

			String request = "UPDATE `stuff_order` SET `number`=?," +
						"`create_date`=?,`cancellation_date`=?,`delivery_date`=?,"+
						"`delivery_methode`=?,`delivery_address_id`=?," +
						"`billing_address_id`=?,`user_id`=?,`bankcard_id`=?,`status`=?"+
						" WHERE `id`=?";
			
			preparedStatement = connection.prepareStatement(request);
			preparedStatement.setInt(1, order.getNumber());
			preparedStatement.setDate(2, Utils.toSqlDate(order.getCreateDate()));
			preparedStatement.setDate(3, Utils.toSqlDate(order.getCancellationDate()));
			preparedStatement.setDate(4, Utils.toSqlDate(order.getDeliveryDate()));
			
			
			preparedStatement.setString(5, order.getDeliveryMethod().getValue());
			preparedStatement.setInt(6, order.getDeliveryAddress().getId());
			preparedStatement.setInt(7, order.getBillingAddress().getId());
			preparedStatement.setInt(8, order.getUserId());
			preparedStatement.setInt(9, order.getBankCardUsed().getId());
			preparedStatement.setString(10, order.getStatus().getValue());
			preparedStatement.setInt(11, order.getId());
			
			result =preparedStatement.executeUpdate();
			System.out.printf("row inpacted : %d\n",result);

		} finally {
			this.closeStream(connection, preparedStatement);
		}
		return result;

	}
//---------------------------------------------------------------------------------------------------------------------------------

	public int delete (Order order) throws Exception {
		
		return this.delete(order, true);
		
	}
//---------------------------------------------------------------------------------------------------------------------------------

	public int delete(Order order, boolean delete) throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;

		try {

			connection = DatabaseConnection.getConnection();

			String request = "UPDATE `stuff_order` SET `is_deleted` = ?  WHERE `id` = ?;";
			preparedStatement = connection.prepareStatement(request,Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setBoolean(1, delete);
			preparedStatement.setInt(2, order.getId());
			result =preparedStatement.executeUpdate();
			System.out.printf("row inpacted : %d\n",result);

		} finally {
			this.closeStream(connection, preparedStatement);
		}

		return result;

	}
//---------------------------------------------------------------------------------------------------------------------------------

	public int delete(User user) throws Exception {

		
		return this.delete(user,true);
		
	}

//---------------------------------------------------------------------------------------------------------------------------------

	
	public int delete(User user, boolean delete) throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int result = 0;

		try {

			connection = DatabaseConnection.getConnection();

			String request = "UPDATE `stuff_order` SET `is_deleted` = ?  WHERE `user_id` = ?;";
			preparedStatement = connection.prepareStatement(request);

			preparedStatement.setBoolean(1, delete);
			preparedStatement.setInt(2, user.getId());
			result =preparedStatement.executeUpdate();

		} finally {
			this.closeStream(connection, preparedStatement, resultSet);
		}

		return result;

	}

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

// -----------------------------------------------------------------------------
	private void closeStream(Connection connection, PreparedStatement preparedStatement) throws Exception {

		closeStream(connection, preparedStatement, null);

	}

}
