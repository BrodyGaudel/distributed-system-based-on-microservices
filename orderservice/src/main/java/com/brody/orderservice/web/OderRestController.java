package com.brody.orderservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.brody.orderservice.entities.Order;
import com.brody.orderservice.model.Customer;
import com.brody.orderservice.model.Product;
import com.brody.orderservice.repository.OrderRepository;
import com.brody.orderservice.repository.ProductItemRepository;
import com.brody.orderservice.service.CustomerRestClientService;
import com.brody.orderservice.service.InventoryRestClientService;

@RestController
public class OderRestController {
	
	private OrderRepository orderRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClientService customerRestClientService;
    private InventoryRestClientService inventoryRestClientService;

    public OderRestController(OrderRepository orderRepository, ProductItemRepository productItemRepository, CustomerRestClientService customerRestClientService, InventoryRestClientService inventoryRestClientService) {
        this.orderRepository = orderRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClientService = customerRestClientService;
        this.inventoryRestClientService = inventoryRestClientService;
    }

    @GetMapping("/fullOrder/{id}")
    public Order getOrder(@PathVariable Long id){
        Order order=orderRepository.findById(id).get();
        System.out.println("CUSTOMER ID: "+order.getCustomerId());
        Customer customer=customerRestClientService.customerById(order.getCustomerId());
        System.out.println("CUSTOMER : "+customer.toString());
        order.setCustomer(customer);
        order.getProductItems().forEach(pi->{
            Product product=inventoryRestClientService.productById(pi.getProductId());
            pi.setProduct(product);
        });
        return order;
    }

}
