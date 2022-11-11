package com.brody.orderservice;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.brody.orderservice.entities.Order;
import com.brody.orderservice.entities.ProductItem;
import com.brody.orderservice.enums.OrderStatus;
import com.brody.orderservice.model.Customer;
import com.brody.orderservice.model.Product;
import com.brody.orderservice.repository.OrderRepository;
import com.brody.orderservice.repository.ProductItemRepository;
import com.brody.orderservice.service.CustomerRestClientService;
import com.brody.orderservice.service.InventoryRestClientService;

@EnableFeignClients
@SpringBootApplication
public class OrderserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderserviceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(
			OrderRepository orderRepository,
			ProductItemRepository productItemRepository,
			CustomerRestClientService customerRestClientService,
			InventoryRestClientService inventoryRestClientService){
		return args -> {
			List<Customer> customers=customerRestClientService.allCustomers().getContent().stream().toList();
			List<Product> products=inventoryRestClientService.allProducts().getContent().stream().toList();
			Long customerId=1L;
			Random random=new Random();
			Customer customer =customerRestClientService.customerById(customerId);
			
			
			
			for (int i = 0; i <20 ; i++) {
				Order order= new Order();
				
				order.setStatus(Math.random()>0.5?OrderStatus.PENDING:OrderStatus.CREATED);
				order.setCreatedAt(new Date());
				order.setCustomerId(customers.get(random.nextInt(customers.size())).getId());	
				Order savedOrder = orderRepository.save(order);
				for (int j = 0; j < products.size() ; j++) {
					if(Math.random()>0.70){
						ProductItem productItem= new ProductItem();
						productItem.setOrder(savedOrder);
						productItem.setProductId(products.get(j).getId());
						productItem.setPrice(products.get(j).getPrice());
						productItem.setQuantity(1+random.nextInt(10));	
						productItem.setDiscount(Math.random());
		
						productItemRepository.save(productItem);
					}

				}
			}
		};
	}

}
