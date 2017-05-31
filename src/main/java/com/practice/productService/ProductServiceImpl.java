package com.practice.productService;

import com.practice.entity.Product;
import com.practice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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
        product.setInsertDate(new Timestamp(System.currentTimeMillis()));
        product.setLastUpdated(new Timestamp(System.currentTimeMillis()));

        productRepository.save(product);

        return product.getProductId();
    }

    @Override
    public Product getProductById(int id) {

        Product product = productRepository.getOne(id);

        return product;
    }

    @Override
    public Product updateProduct(int productId, String productName, String productDesc, String productSpec) {

        Product product = productRepository.getOne(productId);

        product.setName(productName);
        product.setDescription(productDesc);
        product.setSpecifications(productSpec);
        product.setLastUpdated(new Timestamp(System.currentTimeMillis()));
        return productRepository.save(product);
    }




}
