package com.practice.productService;

import com.practice.entity.Product;
import com.practice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 05-05-2017.
 */

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;


    public List<Product> getAllProducts() {

        List<Product>  productList =  productRepository.findAll();

        return productList;
    }
}
