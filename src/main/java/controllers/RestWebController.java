package controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dao.CustomerDao;
import dao.OrderDao;
import dao.StockDao;
import model.Customer;
import model.Order;
import model.Stock;

@RestController
public class RestWebController {

	@Autowired
	StockDao dao;
	
	@Autowired
	CustomerDao cdao;
	
	@Autowired
	OrderDao odao;
	
	@RequestMapping(value="/stock/{designno}",produces= {"application/json","application/xml"})
	public @ResponseBody Stock getStock(@PathVariable String designno) {
		
		Stock s = dao.getStock(designno);
		return s;
	}
	
	@RequestMapping(value="/stocks",produces= {"application/json","application/xml"})
	public  ResponseEntity<List<Stock>> getAllStock() {
		
		List<Stock> s = dao.getAllStock();
		return new ResponseEntity<List<Stock>>(s,HttpStatus.OK);
	}
	
	@RequestMapping(value="/bill/{id}" ,produces= {"application/json","application/xml"})
	public @ResponseBody Order billgenerater(@PathVariable long id) {
		Order order = odao.getOrder(id);
		return order;
		
	}
	
	@RequestMapping(value="/customer" ,method=RequestMethod.POST,produces= {"application/json","application/xml"},consumes={"application/json","application/xml"})
	public ResponseEntity<Void> addCustomer(@RequestBody Customer customer){
		cdao.addCustomer(customer);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	
}
