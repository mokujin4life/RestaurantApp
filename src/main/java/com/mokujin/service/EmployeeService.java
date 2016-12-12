package com.mokujin.service;

import com.mokujin.dao.employee.EmployeeDAO;
import com.mokujin.model.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    EmployeeDAO employeeDAO;

    public void add(Employee employee) {
        boolean employeeValidation = validateObject(employee);
        if (employeeValidation) {
            employeeDAO.add(employee);
        }
    }

    public Employee get(int id) {
        return employeeDAO.get(id);
    }

    public List<Employee> getAll() {
        return employeeDAO.getAll();
    }

    public void delete(Integer id) {
        employeeDAO.delete(id);
    }

    public void edit(Employee employee) {
        employeeDAO.edit(employee);
    }

    private boolean validateObject(Employee employee) {
        return employee != null;
    }

}
