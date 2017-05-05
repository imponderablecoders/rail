package com.practice.productController;


import com.practice.entity.Product;
import com.practice.productService.ProductService;
import com.practice.productService.ProductServiceImpl;
import com.practice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Timestamp;
import java.util.List;


/**
 * Created by Administrator on 28-04-2017.
 */

@Controller
public class ProductController {


   @Autowired
   ProductRepository productRepository;
   @Autowired
   ProductService productService;

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

/*    @RequestMapping(value="/home",method= RequestMethod.GET)
void home(){

}*/

@RequestMapping(value = "/addProduct",method = RequestMethod.GET)
void addNewProduct(){

}

@RequestMapping(value = "/viewProducts", method = RequestMethod.GET)
void viewProducts(Model model){
  List<Product> productsList = productService.getAllProducts();
System.out.println(productsList);
for(Product x: productsList ){
    System.out.println(x.getName());
    System.out.println(x.getDescription());
    System.out.println(x.getSpecifications());

}
  model.addAttribute("productList",productsList);
}


}