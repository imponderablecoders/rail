package com.practice.itemController;

import com.practice.entity.Item;
import com.practice.entity.Product;
import com.practice.itemService.ItemService;
import com.practice.productService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Administrator on 31-05-2017.
 */



@Controller
public class ItemController {


    @Autowired
    ProductService productService;
    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/addItem", method = RequestMethod.GET)
    String addItem(Model model){

        List<Product> productsList = productService.getAllProducts();
        model.addAttribute("productList", productsList);
        return "addItem";
    }



    @RequestMapping(value = "/submitItem", method = RequestMethod.POST)
    String submitItem(Model model, @RequestParam("product_id") int productId,
                    @RequestParam("item_unique_id") String itemUniqueId,
                    @RequestParam("item_ordered_on") String itemOrderedOndate,
                    @RequestParam("item_ordered_from") String itemOrderedfrom,
                    @RequestParam("item_contract_del_date") String contractDeliveryDate,
                    @RequestParam("item_actual_del_date") String actualDeliveryDate,
                    @RequestParam("item_added_by") String itemAddedBy
                    ){
        System.out.println("----------+++++++++++++++++++-----------");
        System.out.println("productId"+productId);
        System.out.println("itemUniqueId"+itemUniqueId);
        System.out.println("itemOrderedOndate"+itemOrderedOndate);
        System.out.println("itemOrderedfrom"+itemOrderedfrom);
        System.out.println("contractDeliveryDate"+contractDeliveryDate);
        System.out.println("actualDeliveryDate"+actualDeliveryDate);
        System.out.println("itemAddedBy"+itemAddedBy);

        Item item = itemService.insertItem(productId,itemUniqueId,itemOrderedOndate,
                itemOrderedfrom,contractDeliveryDate,actualDeliveryDate,
                itemAddedBy);
        System.out.println("yay!!!!!!!!!!!!!!!!!!");

        model.addAttribute("item",item);
        model.addAttribute("itemBelongsTo",item.getProduct().getName());
        model.addAttribute("added","yes");

        return "itemDetails";
    }

}
