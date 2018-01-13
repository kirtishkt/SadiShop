package dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Customer;

@Repository
public class CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void addCustomer(Customer cust) {
		
		 sessionFactory.getCurrentSession().save(cust);
	}

	@Transactional
	public Customer getCustomer(long cust_id) {
		// TODO Auto-generated method stub
		return (Customer) sessionFactory.getCurrentSession().get(Customer.class, cust_id);
		
	}
}
