package com.brody.customerservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.brody.customerservice.entity.Customer;
import com.brody.customerservice.repository.CustomerRepository;

@EnableDiscoveryClient
@SpringBootApplication
public class CustomerserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerserviceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args -> {
			customerRepository.save(new Customer(null,"Brody","brody@spring.io"));
			customerRepository.save(new Customer(null,"Gaudel","gaudel@spring.io"));
			customerRepository.save(new Customer(null,"Mounanga","mounanga@spring.io"));
			
			customerRepository.findAll().forEach(customer -> System.out.println(customer.toString()));
			
			
		};
	}
}
