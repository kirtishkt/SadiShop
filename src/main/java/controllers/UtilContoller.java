package controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;


import dao.StockDao;
import model.Customer;
import model.Order;
import model.Stock;

@Controller
public class UtilContoller {

	@Autowired
	StockDao dao;
	
	
	public static final String URI = "http://localhost:9092/SadiShop/";
	
	@RequestMapping(path="/",method=RequestMethod.GET)
	public String getHome() {
		return "index";
	}
	
	@RequestMapping(path= {"/control/mainpage","/mainpage"},method=RequestMethod.GET)
	public String goHome() {
		return "mainpage";
	}
	
	@RequestMapping(path= {"/addstock","/control/addstock"},method=RequestMethod.GET)
	public String addStock() {
		return "addstock";
	}
	
	@RequestMapping(path= {"/order","/control/order"},method=RequestMethod.GET)
	public String order() {
		return "order";
	}
	@RequestMapping(path= {"/addcustomer","/control/addcustomer"},method=RequestMethod.GET)
	public String addcustomer() {
		return "addcustomer";
	}
	
	@RequestMapping(path= {"/updateStock","/control/updateStock"},method=RequestMethod.GET)
	public String updateStock() {
		return "updateStock";
	}
	@RequestMapping(path= {"/bill","/control/bill"},method=RequestMethod.GET)
	public String bill() {
		return "bill";
	}
	
	@RequestMapping(path= {"/getStockService","/control/getStockService"},method=RequestMethod.GET)
	public String getStockService() {
		return "getStock";
	}
	
	@RequestMapping(path= {"/getOrder","/control/getOrder"},method=RequestMethod.GET)
	public String getOrder() {
		return "getorder";
	}
	@RequestMapping(path= {"/addcustomerself","/control/addcustomerself"},method=RequestMethod.GET)
	public String addCustomerSelf() {
		return "addcustomerself";
	}
	
	@RequestMapping(path= {"/getStock"}, method= {RequestMethod.POST})
	public ModelAndView getStock(@RequestParam("designno") String designno) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("stockdetails");
		String final_uri = URI + "control/stock/" + designno;
		
		RestTemplate rt = new RestTemplate();
		
		Stock stock = rt.getForObject(final_uri, Stock.class);
		mv.addObject("stock",stock);
		
		
		return mv;
	}
	@RequestMapping(path= {"/allStock","/control/allStock"}, method=RequestMethod.GET)
	public ModelAndView getAllStock() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("allstockdetails");
		String final_uri = URI + "control/stocks";
		
		RestTemplate rt = new RestTemplate();
		
		ResponseEntity<Stock[]> entity = rt.getForEntity(final_uri, Stock[].class);
		
		mv.addObject("stock",Arrays.asList(entity.getBody()));
		return mv;
	}
	@RequestMapping(path= {"/getOrder"}, method=RequestMethod.POST)
	public ModelAndView getOrder(@RequestParam("order_id") long order_id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("billservice");
		String final_uri = URI + "control/bill/" + order_id;
		
		RestTemplate rt = new RestTemplate();
		
		Order  order = rt.getForObject(final_uri, Order.class);
		mv.addObject("order",order);
		mv.addObject("items", order.getItems());
		
		ArrayList<Stock> stock = new ArrayList<>(); 
		
		Iterator<String> iterator = order.getItems().keySet().iterator();
		while(iterator.hasNext()) {
			
			String designno = iterator.next();
			String stock_uri = URI + "control/stock/" + designno;
			Stock s = rt.getForObject(stock_uri, Stock.class);
			stock.add(s);
		}
		
		mv.addObject("stock",stock );
		
		
		return mv;
	}
	@RequestMapping(path= {"/Customer"}, method=RequestMethod.POST)
	public String addCustService(@RequestParam("name") String name,@RequestParam("address") String address) {
		Customer cust = new Customer();
		cust.setName(name);
		cust.setAddress(address);
		String final_uri = URI + "control/customer";
		RestTemplate rt = new RestTemplate();
		rt.postForEntity(final_uri,cust,Customer.class);
		
		return "success";
	}
	
}
