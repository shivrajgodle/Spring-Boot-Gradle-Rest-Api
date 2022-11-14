package com.shivraj.demo.controller;

import com.shivraj.demo.entity.User;
import com.shivraj.demo.responce.UserDepartmentResponce;
import com.shivraj.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/allusers")
    public ResponseEntity<List<User>> getAllUser(){

        List<User> users = null;
        try {
           users = userService.getAllUser();
        }catch (Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<List<User>>(users , HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<User> getAllUser(@PathVariable("id") int userid){

        User users = null;
        try {
            users =  userService.getUserById(userid);
        }catch (Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<User>(users , HttpStatus.OK);
    }

    @PostMapping("/addOrUpdate")
    public ResponseEntity<User> addOrUpdate(@RequestBody User user){

        User users = null;
        try {
            users =  userService.addOrUpdateUser(user);
        }catch (Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<User>(users , HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") int userid){

        User users = null;
        try {
            users =  userService.deleteUser(userid);
        }catch (Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<User>(users , HttpStatus.OK);
    }

    @GetMapping("/getUserBySalary/{salary}")
    public ResponseEntity<List<User>> getUserBySalary(@PathVariable("salary") float salary){

        List<User> users = null;
        try {
            users = userService.getUserBySalary(salary);
        }catch (Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<List<User>>(users , HttpStatus.OK);
    }

    @GetMapping("/alluserDepartment")
    public ResponseEntity<List<UserDepartmentResponce>> getAllUserDepartment(){

        List<UserDepartmentResponce> users = null;
        try {
            users = userService.getUserDepartment();
        }catch (Exception ex){
            ex.getMessage();
        }
        return new ResponseEntity<List<UserDepartmentResponce>>(users , HttpStatus.OK);
    }

}
