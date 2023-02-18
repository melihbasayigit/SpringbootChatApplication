package com.melomanya.springdemo.controller;

import com.melomanya.springdemo.entity.User;
import com.melomanya.springdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/api")
@Deprecated
public class UserController {
    @Autowired
    private UserRepository repository;

    @PostMapping(path = "/add")
    public @ResponseBody String newUser(@RequestParam String name, @RequestParam String email) {
        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        repository.save(newUser);
        return newUser.toString();
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return repository.findAll();
    }




}
