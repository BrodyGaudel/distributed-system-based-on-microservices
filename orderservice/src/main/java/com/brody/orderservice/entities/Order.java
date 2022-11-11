package com.brody.orderservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.brody.orderservice.enums.OrderStatus;
import com.brody.orderservice.model.Customer;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    private OrderStatus status;
    private Long customerId;
    
    @Transient
    private Customer customer;
    
    @OneToMany(mappedBy = "order")
    private List<ProductItem> productItems;
    
	public Order(Long id, Date createdAt, OrderStatus status, Long customerId, Customer customer,
			List<ProductItem> productItems) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.status = status;
		this.customerId = customerId;
		this.customer = customer;
		this.productItems = productItems;
	}

	public Order(Date createdAt, OrderStatus status, Long customerId, Customer customer,
			List<ProductItem> productItems) {
		super();
		this.createdAt = createdAt;
		this.status = status;
		this.customerId = customerId;
		this.customer = customer;
		this.productItems = productItems;
	}

	public Order(Date createdAt, OrderStatus status, Long customerId, Customer customer) {
		super();
		this.createdAt = createdAt;
		this.status = status;
		this.customerId = customerId;
		this.customer = customer;
	}
	
	

	public Order() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<ProductItem> getProductItems() {
		return productItems;
	}

	public void setProductItems(List<ProductItem> productItems) {
		this.productItems = productItems;
	}
	
	public double getTotal(){
        double somme=0;
        for(ProductItem pi:productItems){
            somme+=pi.getAmount();
        }
        return somme;
    }

	@Override
	public String toString() {
		return "Order [id=" + id + ", createdAt=" + createdAt + ", status=" + status + ", customerId=" + customerId
				+ ", customer=" + customer + ", productItems=" + productItems + "]";
	}
	
	
    
    

}
