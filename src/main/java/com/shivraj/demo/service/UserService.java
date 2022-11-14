package com.shivraj.demo.service;

import com.shivraj.demo.entity.User;
import com.shivraj.demo.responce.UserDepartmentResponce;

import java.util.List;

public interface UserService {

    public List<User> getAllUser();
    public User getUserById(int userid);
    public User addOrUpdateUser(User user);
    public User deleteUser(int userid) throws Exception;

    public List<User> getUserBySalary(float salary);

    //this method calls from dao class
    public List<UserDepartmentResponce> getUserDepartment();

}
