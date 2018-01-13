package model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="customer")
@XmlRootElement
public class Customer {
	
	@Id
	@GeneratedValue
	@Column(name="cust_id")
	private long id;
	
	@Column(name="cust_name")
	private String name;
	
	@Column(name="address")
	private String Address;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name="order",joinColumns=@JoinColumn(name="order_id"))
	@CollectionTable(name="customer_orders")
	@ElementCollection
	private Collection<Order> orders = new ArrayList<>();
	
	public Customer() {}
	
	
	
	public Collection<Order> getOrders() {
		return orders;
	}



	public void setOrders(Collection<Order> orders) {
		this.orders = orders;
	}



	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
