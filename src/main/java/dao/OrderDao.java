package dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Customer;
import model.Order;

@Repository
public class OrderDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public OrderDao() {}
	
	public OrderDao(SessionFactory sf) {

		this.sessionFactory =sf;
	}

	@Transactional
	public void addOrder(Order order)
	{
		Customer customer = order.getCustomer();
		// sessionFactory.getCurrentSession().save(customer);
		sessionFactory.getCurrentSession().save(order);
	}

	@Transactional
	public Order getOrder(long order_id) {
		return (Order) sessionFactory.getCurrentSession().get(Order.class, order_id);
		
	}
	
	
}
