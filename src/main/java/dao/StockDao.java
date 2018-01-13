package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import model.Stock;

@Repository
public class StockDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public StockDao() {}
	
	public StockDao(SessionFactory sf) {
		this.sessionFactory =sf;
	}
	
	@Transactional
	public Stock getStock(String designno) {
		
		Stock s = (Stock) sessionFactory.getCurrentSession().get(Stock.class, designno);
		return s;
	}
	
	@Transactional
	public void addStock(Stock stock) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(stock);
		
	}

	@Transactional
	public List<Stock> getAllStock() {
		
		 
		List<Stock> list = 	sessionFactory.getCurrentSession().createCriteria(Stock.class).list();
		System.out.println("Length of list is: "+list.size());
		return list;
	}
}
