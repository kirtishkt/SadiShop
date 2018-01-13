package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="orders")
@XmlRootElement
public class Order{

	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue
	@Column(name="order_id")
	private long order_id;
	
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="designno",joinColumns=@JoinColumn(name="designno"))
	@CollectionTable(name="order_item")
	@ElementCollection
	@MapKeyColumn(name= "designno")
	private Map<String,Quantity> items = new HashMap<String,Quantity>();
	
	
	@Column(name="date")
	@Temporal(value = TemporalType.DATE)
	private Date date;
	
	@ManyToOne(optional=false)
	private Customer customer;
	
	public Order() {}

	

	public Map<String, Quantity> getItems() {
		return items;
	}



	public void setItems(Map<String, Quantity> items) {
		this.items = items;
	}



	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}




	public Order(long order_id, Map<String, Quantity> items, Date date, Customer customer) {
		super();
		this.order_id = order_id;
		this.items = items;
		this.date = date;
		this.customer = customer;
	}




	public Order(HashMap<String, Quantity> map, Date date2, Customer c) {
		// TODO Auto-generated constructor stub
		this.items = map;
		this.date = date2;
		this.customer = c;
	}
	

}
