package com.practice.repository;

import com.practice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

/**
 * Created by Administrator on 05-05-2017.
 */
public interface UserRepository extends JpaRepository<User,Serializable> {



}
