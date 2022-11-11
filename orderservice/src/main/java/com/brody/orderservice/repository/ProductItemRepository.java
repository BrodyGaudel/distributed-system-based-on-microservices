package com.brody.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brody.orderservice.entities.ProductItem;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductItemRepository extends JpaRepository<ProductItem, Long>{

}
