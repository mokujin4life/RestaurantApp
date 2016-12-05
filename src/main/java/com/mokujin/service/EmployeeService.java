package com.mokujin.service;

import com.mokujin.dao.employee.EmployeeDAO;
import com.mokujin.dao.employee.IEmployeeDAO;
import com.mokujin.dao.ingredient.IIngredientDAO;
import com.mokujin.models.employee.Employee;
import com.mokujin.models.ingredient.Ingredient;

import java.util.List;

/**
 * Created by Danil on 05.12.16.
 */
public class EmployeeService {
    EmployeeDAO employeeDAO = new IEmployeeDAO();

    public void add(Employee employee) {
        employeeDAO.add(employee);
    }

    public void get(Integer id) {
        if (id < employeeDAO.getAll().size()) {
            employeeDAO.get(id);
        } else {
            throw new RuntimeException();
        }
    }

    public List<Employee> getAll() {
        return employeeDAO.getAll();
    }

    public void delete(Employee employee) {
        employeeDAO.delete(employee);
    }

    public void edit(Employee employee){
        employeeDAO.edit(employee);
    }

}
