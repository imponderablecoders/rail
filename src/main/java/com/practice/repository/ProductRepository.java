package com.practice.repository;

import com.practice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 03-05-2017.
 */
public interface ProductRepository extends JpaRepository<Product,Serializable> {

    List<Product> findByName(String name);

}
