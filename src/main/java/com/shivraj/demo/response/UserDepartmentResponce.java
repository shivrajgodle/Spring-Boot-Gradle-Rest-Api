package com.shivraj.demo.response;

public class UserDepartmentResponce {
    private String name;
    private String departmentName;

    public UserDepartmentResponce() {
        super();
    }

    public UserDepartmentResponce(String name, String departmentName) {
        this.name = name;
        this.departmentName = departmentName;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "UserDepartmentResponce{" +
                "name='" + name + '\'' +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
