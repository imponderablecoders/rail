package com.practice.itemService;

import com.practice.entity.Item;
import com.practice.entity.Product;
import com.practice.repository.ItemRepository;
import com.practice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 05-05-2017.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ProductRepository productRepository;

    SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Item insertItem(int productId,String itemUniqueId,String itemOrderedOndate,
                          String itemOrderedfrom,String contractDeliveryDate,String actualDeliveryDate,
                          String itemAddedBy) {
        Date DateOrderedOn = null;
        Date DateCntrctDel = null;
        Date DateActualDel = null;
        try {
            DateOrderedOn = formatter.parse(itemOrderedOndate);
            DateCntrctDel = formatter.parse(contractDeliveryDate);
            DateActualDel = formatter.parse(actualDeliveryDate);
            System.out.println("here!!!!!ffg");
        } catch (ParseException e) {
            System.out.println("here!!!!!fff");
            e.printStackTrace();
        }
        Product product = productRepository.getOne(productId);
        int Proquantity = product.getQuantity();
        product.setQuantity(++Proquantity);

        Item item = new Item();

        item.setProduct(product);
        item.setUniqueId(itemUniqueId);
        item.setOrderedOn(DateOrderedOn);
        item.setOrderedFrom(itemOrderedfrom);
        item.setContractDelvDt(DateCntrctDel);
        item.setActualDelvDt(DateActualDel);
        item.setItemAddedBy(itemAddedBy);
        item.setInsertDate(new Timestamp(System.currentTimeMillis()));
        item.setLastUpdated(new Timestamp(System.currentTimeMillis()));


        itemRepository.save(item);
        productRepository.save(product);

        return item;
    }
}
