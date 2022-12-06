package com.shivraj.demo.dao;

import com.shivraj.demo.response.UserDepartmentResponce;

import java.util.List;

public interface UserDao {

    public List<UserDepartmentResponce> getUserDepartment();
}
