package com.brody.orderservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.brody.orderservice.model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class ProductItem {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    @Transient
    private Product product;
    private double price;
    private int quantity;
    private double discount;
    
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Order order;
    
    

    public ProductItem(Long id, Long productId, Product product, double price, int quantity, double discount,
			Order order) {
		this.id = id;
		this.productId = productId;
		this.product = product;
		this.price = price;
		this.quantity = quantity;
		this.discount = discount;
		this.order = order;
	}
    
 
	public ProductItem() {
		super();
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getProductId() {
		return productId;
	}


	public void setProductId(Long productId) {
		this.productId = productId;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getDiscount() {
		return discount;
	}


	public void setDiscount(double discount) {
		this.discount = discount;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


	public double getAmount(){
        return price*quantity*(1-discount);
    }


	@Override
	public String toString() {
		return "ProductItem [id=" + id + ", productId=" + productId + ", product=" + product + ", price=" + price
				+ ", quantity=" + quantity + ", discount=" + discount + ", order=" + order + "]";
	}
	
	
    

}
