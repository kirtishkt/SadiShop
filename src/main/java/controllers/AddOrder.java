package controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import dao.CustomerDao;
import dao.OrderDao;
import dao.StockDao;
import model.Customer;
import model.Order;
import model.Quantity;
import model.Stock;

@Controller
public class AddOrder {

	@Autowired
	OrderDao dao;
	
	@Autowired
	CustomerDao cdao;
	
	@Autowired
	StockDao sdao;
	
	@RequestMapping(path="/addOrder",method=RequestMethod.POST )
	public ModelAndView addOrder(@RequestParam("item") String[] items,@RequestParam("quantity") String[] quantity, @RequestParam("customer") long cust_id) {
	
		boolean success = true;
		ModelAndView mv = new ModelAndView();
		ArrayList<Double> p = new ArrayList<>();
		
		HashMap<String, Quantity> map = new HashMap<>();
		for(int i=0;i<items.length;i++)
		{
			if(!(items[i].equals("") & !(quantity[i].equals("") ))){
				System.out.println("Item: "+items[i]+",Quantity: "+quantity[i]);
				map.put(items[i], new Quantity(Integer.parseInt(quantity[i])));
			}
		}
		Customer c = cdao.getCustomer(cust_id);
		
		int q =0;
		String itm = null;
		
		for (Entry<String, Quantity> entry : map.entrySet()) {
		
			Stock stock = sdao.getStock(entry.getKey());
			p.add((double) (stock.getPrice() * entry.getValue().getQuantity()));
			if(entry.getValue().getQuantity() > stock.getQuantity()) {
				success = false;
				itm = stock.getDesignNo();
				q = stock.getQuantity();
			}
		}
		
		
		
		if(success) {
			for (Entry<String, Quantity> entry : map.entrySet()) {
				Stock stock = sdao.getStock(entry.getKey());
				stock.setQuantity(stock.getQuantity() - entry.getValue().getQuantity());
				sdao.addStock(stock);
			}
			
			dao.addOrder(new Order( map, new Date(), c ));
			mv.setViewName("success");
		//	mv.addObject("msg", p.toString());
			
		}else {
			mv.setViewName("error");
			mv.addObject("errormsg", "Item Stock not enough for your requirment \n Available Stock for item: "+itm+" is "+q);
		}
		
		return mv;
	}
	@RequestMapping(path="/getBill",method=RequestMethod.POST )
	public ModelAndView generateBill(@RequestParam("order_id") long order_id ) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("billdetails");
		ArrayList<Stock> stock = new ArrayList<>();
		Order order = dao.getOrder(order_id);
		
		 Map<String, Quantity> items = order.getItems();
		mv.addObject("items", items);
		

		Iterator<String> iterator = order.getItems().keySet().iterator();
		while(iterator.hasNext()) {
			stock.add(sdao.getStock(iterator.next()));
		}
		
		mv.addObject("stock",stock );
		
		
		return mv;
		
	}
}
