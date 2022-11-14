package com.shivraj.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userid;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private String age;

    @Column(name = "salary")
    private Float salary;

    @Column(name = "city")
    private String city;

    @Column(name = "department_id")
    private int departmentId;

    public User() {
        super();
    }

    public User(int userid, String name, String age, Float salary, String city, int departmentId) {
        this.userid = userid;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.city = city;
        this.departmentId = departmentId;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", salary=" + salary +
                ", city='" + city + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}
