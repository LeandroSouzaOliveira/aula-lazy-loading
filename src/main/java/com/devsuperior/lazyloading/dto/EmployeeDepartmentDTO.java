package com.devsuperior.lazyloading.dto;

import com.devsuperior.lazyloading.entities.Employee;

import java.io.Serializable;

public class EmployeeDepartmentDTO implements Serializable {

    private Long id;
    private String name;
    private String email;
    private DepartmentDTO department;

    public EmployeeDepartmentDTO(Long id, String name, String email, DepartmentDTO department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
    }

    public EmployeeDepartmentDTO(Employee entity) {
        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        department = new DepartmentDTO(entity.getDepartment());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDTO department) {
        this.department = department;
    }
}
