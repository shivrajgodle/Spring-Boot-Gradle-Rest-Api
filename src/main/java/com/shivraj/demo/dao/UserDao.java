package com.shivraj.demo.dao;

import com.shivraj.demo.responce.UserDepartmentResponce;

import java.util.List;

public interface UserDao {

    public List<UserDepartmentResponce> getUserDepartment();
}
