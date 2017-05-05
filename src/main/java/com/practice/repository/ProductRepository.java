package com.practice.repository;

import com.practice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by Administrator on 03-05-2017.
 */
public interface ProductRepository extends JpaRepository<Product,Serializable> {



}
