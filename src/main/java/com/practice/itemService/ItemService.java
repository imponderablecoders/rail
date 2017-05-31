package com.practice.itemService;

import com.practice.entity.Item;

/**
 * Created by Administrator on 05-05-2017.
 */
public interface ItemService {

    Item insertItem(int productId, String itemUniqueId, String itemOrderedOndate,
                    String itemOrderedfrom, String contractDeliveryDate, String actualDeliveryDate,
                    String itemAddedBy);
}
