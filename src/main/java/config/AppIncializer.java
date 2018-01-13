package config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.http.MediaType;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;

public class AppIncializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		 AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
	        appContext.register(HibernateConfiguration.class);
	         
	        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
	                "SpringDispatcher", new DispatcherServlet(appContext));
	        dispatcher.setLoadOnStartup(1);
	        dispatcher.addMapping("/control/*");
		
	}
	
	

}
