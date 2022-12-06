package com.shivraj.demo.dao.impl;

import com.shivraj.demo.dao.UserDao;
import com.shivraj.demo.dao.support.NamedParameterJdbcDaoSupportClass;
import com.shivraj.demo.response.UserDepartmentResponce;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends NamedParameterJdbcDaoSupportClass implements UserDao {

    @Override
    public List<UserDepartmentResponce> getUserDepartment() {
        List<UserDepartmentResponce> users = null;
        try{
            String query = "select name,department_name as Dept_name from test.user join test.department on user.department_id = department.department_id";
            users = getNamedParameterJdbcTemplate().getJdbcOperations().query(query , new BeanPropertyRowMapper<UserDepartmentResponce>(UserDepartmentResponce.class));
        }catch (Exception ex){
            ex.getStackTrace();
        }
        return users;
    }
}
