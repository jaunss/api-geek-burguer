package com.joaogcm.api.geek.burguer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joaogcm.api.geek.burguer.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}