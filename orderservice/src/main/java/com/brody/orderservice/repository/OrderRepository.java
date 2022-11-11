package com.brody.orderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brody.orderservice.entities.Order;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order, Long>  {
	
	 @RestResource(path = "/byCustomerId")
	  List<Order> findByCustomerId(@Param("customerId") Long customerId);

}
