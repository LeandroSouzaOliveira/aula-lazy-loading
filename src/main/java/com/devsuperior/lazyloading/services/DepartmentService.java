package com.devsuperior.lazyloading.services;

import com.devsuperior.lazyloading.dto.DepartmentDTO;
import com.devsuperior.lazyloading.dto.EmployeeMinDTO;
import com.devsuperior.lazyloading.entities.Department;
import com.devsuperior.lazyloading.entities.Employee;
import com.devsuperior.lazyloading.respositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    @Transactional(readOnly = true)
    public DepartmentDTO findById(Long id) {
        Optional<Department> result = repository.findById(id);
        return new DepartmentDTO(result.get());
    }

    @Transactional(readOnly = true)
    public List<EmployeeMinDTO> findEmployeesByDepartment(Long id) {
        Optional<Department> result = repository.findById(id);
        List<Employee> list = result.get().getEmployees();
        return list.stream().map(x -> new EmployeeMinDTO(x)).toList();
    }
}