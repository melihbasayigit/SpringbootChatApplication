package com.melomanya.springdemo.repository;

import com.melomanya.springdemo.entity.User;
import org.springframework.data.repository.CrudRepository;

@Deprecated
public interface UserRepository extends CrudRepository<User, Integer> {

}
