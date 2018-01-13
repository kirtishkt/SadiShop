package config;
 
 
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import dao.OrderDao;
import dao.StockDao;
import model.Stock;
 
@Configuration
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan({ "config","model","dao","controllers"})
public class HibernateConfiguration extends WebMvcConfigurerAdapter{
 
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/resources/**").addResourceLocations("/css/");
		registry.addResourceHandler("/resources/**").addResourceLocations("/image/");
	}
	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
	
	

	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
	    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	    viewResolver.setPrefix("/WEB-INF/views/");
	    viewResolver.setSuffix(".jsp");
	    return viewResolver;
	}
	
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/shop");
	    dataSource.setUsername("root");
	    dataSource.setPassword("kt");
	 
	    return dataSource;
	}
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
	 
	    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	 
	    sessionBuilder.addAnnotatedClasses(Stock.class);
	    
	    
	    sessionBuilder.scanPackages("model");
	    sessionBuilder.scanPackages("config");
	    sessionBuilder.scanPackages("controllers");
	    sessionBuilder.scanPackages("dao");
	    
	    sessionBuilder.setProperty("hibernate.show_sql", "true");
	    sessionBuilder.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	    sessionBuilder.setProperty("hibernate.format_sql", "true");
	    sessionBuilder.setProperty("hibernate.hbm2ddl.auto", "create");

	    return sessionBuilder.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
	        SessionFactory sessionFactory) {
	    HibernateTransactionManager transactionManager = new HibernateTransactionManager(
	            sessionFactory);
	 
	    return transactionManager;
	}
	
	@Autowired
	@Bean(name = "stockDao")
	public StockDao getStockDao(SessionFactory sessionFactory) {
	    return new StockDao(sessionFactory);
	}
	@Autowired
	@Bean(name="orderDao")
	public OrderDao getOrderDao(SessionFactory sf) {
		return new OrderDao(sf);
	}
	
	
}