package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Entity
@Embeddable
@Table(name = "stock")
@XmlRootElement
@JsonPropertyOrder
public class Stock {

	@Id
	@Column(name = "designno")
	private String designNo;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "price")
	private int price;

	public Stock() {
	}

	public String getDesignNo() {
		return designNo;
	}

	public void setDesignNo(String designNo) {
		this.designNo = designNo;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	public Stock(String designNo, int quantity, int price) {
		super();
		this.designNo = designNo;
		this.quantity = quantity;
		this.price = price;
	}

	public Stock(String designNo, int quantity) {
		super();
		this.designNo = designNo;
		this.quantity = quantity;

	}

}
