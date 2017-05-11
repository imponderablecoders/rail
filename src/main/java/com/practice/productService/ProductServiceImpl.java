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

    @Override
    public int insertProduct(String productName, String productDesc, String productSpec,int productQnty, String imageUrl ) {
        Product product = new Product();
        product.setName(productName);
        product.setDescription(productDesc);
        product.setSpecifications(productSpec);
        product.setQuantity(productQnty);
        product.setImageUrl(imageUrl);

        productRepository.save(product);

        return product.getProductId();
    }


}
