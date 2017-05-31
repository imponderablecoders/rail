package com.practice.productService;

import com.practice.entity.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 05-05-2017.
 */

public interface ProductService {

    List<Product> getAllProducts();

    int insertProduct(String productName, String productDesc, String productSpec,int productQnty, String imageUrl );

    Product getProductById(int id);

    Product updateProduct(int productId ,String productName, String productDesc, String productSpec);


}
