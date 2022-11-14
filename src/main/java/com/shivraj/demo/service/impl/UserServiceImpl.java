package com.shivraj.demo.service.impl;

import com.shivraj.demo.dao.UserDao;
import com.shivraj.demo.entity.User;
import com.shivraj.demo.repository.UserRepo;
import com.shivraj.demo.responce.UserDepartmentResponce;
import com.shivraj.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAllUser() {
        return (List<User>) userRepo.findAll();
    }

    @Override
    public User getUserById(int userid) {
        return userRepo.findById(userid).orElse(null);
    }

    @Override
    public User addOrUpdateUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User deleteUser(int userid) throws Exception {
        User deletedUser = null;
        try{
            deletedUser = userRepo.findById(userid).orElse(null);

            if(deletedUser == null){
                throw new Exception("User Not Available");
            }
            else {
                userRepo.deleteById(userid);
            }
        }
        catch(Exception ex){
            throw ex;
        }
        return deletedUser;
    }

    @Override
    public List<User> getUserBySalary(float salary) {
        return userRepo.getUserBySalary(salary);
    }

    @Override
    public List<UserDepartmentResponce> getUserDepartment() {
        return userDao.getUserDepartment();
    }
}
