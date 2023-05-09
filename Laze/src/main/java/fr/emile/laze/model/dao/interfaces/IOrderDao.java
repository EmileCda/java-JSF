package fr.emile.laze.model.dao.interfaces;

import java.util.List;

import fr.emile.laze.entity.Order;
import fr.emile.laze.entity.User;

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
