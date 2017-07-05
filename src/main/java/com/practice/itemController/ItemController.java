package com.practice.itemController;

import com.practice.entity.Item;
import com.practice.entity.Product;
import com.practice.itemService.ItemService;
import com.practice.productService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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


        Item item = itemService.insertItem(productId,itemUniqueId,itemOrderedOndate,
                itemOrderedfrom,contractDeliveryDate,actualDeliveryDate,
                itemAddedBy);
        /*System.out.println("yay!!!!!!!!!!!!!!!!!!");*/

        model.addAttribute("item",item);
        model.addAttribute("itemBelongsTo",item.getProduct().getName());
        model.addAttribute("added","yes");

        return "itemDetails";
    }


    @RequestMapping(value = "/delItem/{itemId}", method = RequestMethod.POST)
    String delItem(@PathVariable int itemId, Model model) {

        itemService.deleteItem(itemId);

        List<Product> productsList = productService.getAllProducts();
        model.addAttribute("productList", productsList);
        model.addAttribute("itemDeleted", "yes");
        return "addItem";
    }


    @RequestMapping(value = "/editItem/{itemId}", method = RequestMethod.POST)
    String editItem(@PathVariable int itemId, Model model) {

        Item item = itemService.getOneItem(itemId);


        model.addAttribute("product_name",item.getProduct().getName());
        model.addAttribute("product_id",item.getProduct().getProductId());
        model.addAttribute("item", item);

        System.out.println(item.getActualDelvDt()+"|||"+item.getContractDelvDt()+"|||"+item.getOrderedOn());


        return "editItem";
    }

    @RequestMapping(value = "/editItem", method = RequestMethod.POST)
    String updateItem(Model model,
                      @RequestParam("itemId") int itemId,
                      @RequestParam("product_id") int productId,
                      @RequestParam("item_unique_id") String itemUniqueId,
                      @RequestParam("item_ordered_on") String itemOrderedOndate,
                      @RequestParam("item_ordered_from") String itemOrderedfrom,
                      @RequestParam("item_contract_del_date") String contractDeliveryDate,
                      @RequestParam("item_actual_del_date") String actualDeliveryDate,
                      @RequestParam("item_added_by") String itemAddedBy
    ){

        System.out.println("itemId---"+itemId);

        Item item = itemService.updateItem(itemId,productId,itemUniqueId,itemOrderedOndate,
                itemOrderedfrom,contractDeliveryDate,actualDeliveryDate,
                itemAddedBy);

        model.addAttribute("item",item);
        model.addAttribute("itemBelongsTo",item.getProduct().getName());
        model.addAttribute("edited","yes");

        return "itemDetails";
    }


    @RequestMapping(value = "/allItems", method = RequestMethod.GET)
    String allItems(Model model){



        return "allItems";
    }

}
