package com.goutam.myecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goutam.myecommerce.entities.User;

// first Param defines the entirty model class
//second param defines the dataType of primary key of model entity

public interface UserDao extends JpaRepository<User, Long>{

}
