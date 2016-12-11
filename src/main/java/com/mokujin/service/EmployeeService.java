package com.mokujin.service;

import com.mokujin.dao.employee.EmployeeDAO;
import com.mokujin.dao.employee.IEmployeeDAO;
import com.mokujin.dao.ingredient.IIngredientDAO;
import com.mokujin.models.dish.Dish;
import com.mokujin.models.employee.Employee;
import com.mokujin.models.ingredient.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Danil on 05.12.16.
 */
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

    public void get(Integer id) {
        if (validateId(id)) {
            employeeDAO.get(id);
        } else {
            throw new RuntimeException();
        }
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

    private boolean validateId(Integer id) {
        return id < employeeDAO.getAll().size() && id > 0;
    }

}
