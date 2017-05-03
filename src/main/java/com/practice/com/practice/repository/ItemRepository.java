package com.practice.com.practice.repository;

import com.practice.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by Administrator on 03-05-2017.
 */
public interface ItemRepository extends JpaRepository<Item,Serializable> {



}
