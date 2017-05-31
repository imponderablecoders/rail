package com.practice.productController;


import com.practice.entity.Product;
import com.practice.productService.ProductService;
import com.practice.productService.ProductServiceImpl;
import com.practice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping(value = "/abcd", method = RequestMethod.GET)
    void insert() {
        System.out.println("here----------");
        Product product = new Product();
        product.setName("BMW");
        product.setDescription("car ra");
        product.setSpecifications("it is Modable! ");
        product.setQuantity(10);
    /*Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    System.out.println(timestamp);*/
        product.setInsertDate(new Timestamp(System.currentTimeMillis()));
        product.setLastUpdated(new Timestamp(System.currentTimeMillis()));
        product.setImageUrl("https://tinyurl.com/ls9hbsd");

        System.out.println("here----------");
        productRepository.save(product);
        System.out.println("---------------" + product.getProductId());
        System.out.println("here----------");

    }

/*    @RequestMapping(value="/home",method= RequestMethod.GET)
void home(){

}*/

    @RequestMapping(value = "/addProduct", method = RequestMethod.GET)
    void addNewProduct() {

    }

    @RequestMapping(value = "/viewProducts", method = RequestMethod.GET)
    void viewProducts(Model model) {
        List<Product> productsList = productService.getAllProducts();
        System.out.println(productsList);
        for (Product x : productsList) {
            System.out.println(x.getName());
            System.out.println(x.getDescription());
            System.out.println(x.getSpecifications());
        }
        model.addAttribute("productList", productsList);
    }

    @RequestMapping(value = "/submitProduct", method = RequestMethod.POST)
    String submitNewProduct(Model model,HttpServletRequest request, @RequestParam("product_name") String productName,
                            @RequestParam("product_desc") String productDesc,
                            @RequestParam("num_of_spec") int numOfSpec) {


        System.out.println("---"+productName+"---"+productDesc+"---"+numOfSpec+"---");

        StringBuilder specBuilder =new StringBuilder();
        for(int i=1; i<=numOfSpec;i++){
           String key = request.getParameter("key"+i);
           String value = request.getParameter("value"+i);
           specBuilder.append(key);
           specBuilder.append("#$&");
           specBuilder.append(value);
           if(i < numOfSpec)
           specBuilder.append("!@#");
        }
        System.out.println(specBuilder.toString());

       // if(productService.checkIfProductNameExists(productName));

        int insertId = productService.insertProduct(productName,productDesc,specBuilder.toString(),0,"http://www.picserver.org/images/highway/phrases/product.jpg");

        System.out.println("insert-id"+insertId);

        Product product = productService.getProductById(insertId);

        /*String spec = product.getSpecifications();
        String[] indiSpec = spec.split("!@#");

*/
        model.addAttribute("submOrUpdt","sub");
        model.addAttribute("product",product);
        //model.addAttribute()

        return "productAdded";
    }


    @RequestMapping(value = "/editProduct/{productId}", method = RequestMethod.GET)
    String editProduct(@PathVariable int productId,Model model) {

        System.out.println("------product Id is here-------"+productId);

       Product product = productService.getProductById(productId);

       model.addAttribute("product",product);

       return "editProduct";

    }


    @RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
    String updateProduct(Model model,HttpServletRequest request, @RequestParam("product_name") String productName,
                            @RequestParam("product_desc") String productDesc,
                            @RequestParam("num_of_spec") int numOfSpec,@RequestParam("product_id") int productId) {

        if (productId == 0){
            System.out.println("erooooooooooooooooooooooooooooor!!!!!!!!!!!!!1");
        }

        StringBuilder specBuilder =new StringBuilder();
        for(int i=1; i<=numOfSpec;i++){
            String key = request.getParameter("key"+i);
            String value = request.getParameter("value"+i);
            specBuilder.append(key);
            specBuilder.append("#$&");
            specBuilder.append(value);
            if(i < numOfSpec)
                specBuilder.append("!@#");
        }

        Product product = productService.updateProduct(productId,productName,productDesc,specBuilder.toString());

        model.addAttribute("product",product);
        model.addAttribute("submOrUpdt","up");

        return "productAdded";
    }


}