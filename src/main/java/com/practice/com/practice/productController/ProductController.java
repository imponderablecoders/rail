package com.practice.com.practice.productController;

import com.practice.com.practice.repository.ProductRepository;
import com.practice.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Timestamp;


/**
 * Created by Administrator on 28-04-2017.
 */

@Controller
public class ProductController {


   @Autowired
    ProductRepository productRepository;

@RequestMapping(value="/abcd",method= RequestMethod.GET)
void insert(){
    System.out.println("here----------");
    Product product = new Product();
    product.setName("w2wdpulsar435");
    product.setDescription("bike ra");
    product.setSpecifications("amazng ra");
    product.setQuantity(10);
    /*Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    System.out.println(timestamp);*/
    product.setInsertDate(new Timestamp(System.currentTimeMillis()));
    System.out.println("here----------");
    productRepository.save(product);
System.out.println("here----------");

}

    @RequestMapping(value="/home",method= RequestMethod.GET)
void home(){

}

}