package com.lbuglio.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lbuglio.cursomc.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
