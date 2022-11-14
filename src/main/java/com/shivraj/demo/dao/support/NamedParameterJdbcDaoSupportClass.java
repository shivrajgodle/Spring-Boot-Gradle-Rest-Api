package com.shivraj.demo.dao.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import javax.sql.DataSource;

public class NamedParameterJdbcDaoSupportClass extends NamedParameterJdbcDaoSupport {

    @Autowired
    public void setDataSource3(DataSource dataSource){
        setDataSource(dataSource);
    }
}
