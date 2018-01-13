package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name="quantity")
public class Quantity {

	@Id
	@GeneratedValue
	private long id;
	
	private Integer quantity;
	
	public Quantity() {}

	public Quantity(Integer quantity) {
		// TODO Auto-generated constructor stub
		this.quantity =  quantity;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
