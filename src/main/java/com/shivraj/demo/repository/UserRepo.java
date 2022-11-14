package com.shivraj.demo.repository;

import com.shivraj.demo.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User,Integer> {

    @Query(value = "select * from test.user where salary > :salary" , nativeQuery = true)
    public List<User> getUserBySalary(@Param("salary") float salary);
}
