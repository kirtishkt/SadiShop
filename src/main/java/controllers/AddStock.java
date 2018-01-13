package controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.StockDao;
import model.Stock;

@Controller
public class AddStock{

	@Autowired
	StockDao dao;

	
	@RequestMapping(path="/addStock",method=RequestMethod.POST )
	public String addStock(@ModelAttribute("stock") Stock stock,@RequestParam("designno") String designNo) {
	
		stock.setDesignNo(designNo);
		
		Stock s = dao.getStock(designNo);
		if(s != null) {
			stock.setQuantity(s.getQuantity() + stock.getQuantity());
		}
		dao.addStock(stock);
		
		return "success";
	}
	@RequestMapping(path="/updateStock",method=RequestMethod.POST)
	public String updateStock(@ModelAttribute("stock") Stock stock,@RequestParam("designno") String designno) {
		stock.setDesignNo(designno);
		dao.addStock(stock);
		return "success";
	}
	
}