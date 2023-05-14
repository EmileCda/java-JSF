package fr.emile.jsfsix.model.dao;

import java.util.List;

import fr.emile.jsfsix.entity.Order;
import fr.emile.jsfsix.entity.User;

public interface IOrderDao {
	Order add(Order order) throws Exception;
	Order get(int id) throws Exception;
	List<Order> get(User user) throws Exception;
	List<Order> get() throws Exception;
	int Update(Order  order) throws Exception;

	int delete (Order order,boolean cancel)throws Exception;
	int delete(User user,boolean cancel) throws Exception ;

	int delete (Order order)throws Exception;
	int delete(User user) throws Exception ;

}
