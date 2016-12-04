package com.mokujin.dao.employee;

import com.mokujin.models.employee.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mokujin on 29.11.16.
 */
public class IEmployeeDAO implements EmployeeDAO {

    List<Employee> employees = new ArrayList<>();

    @Override
    public List<Employee> getAll() {
        return employees;
    }

    @Override
    public Employee get(Integer id) {
        try {
            return employees.get(id);
        } catch (Exception e) {
            throw new RuntimeException("no id=" + id + " found");
        }

    }

    @Override
    public void add(Employee employee) {
        employees.add(employee);
        getAll().forEach(item -> System.out.println(item));
    }

    @Override
    public void delete(Integer id) {
        try {
            employees.remove(id);
        } catch (Exception e) {
            throw new RuntimeException("no id=" + id + " found");
        }

    }

    @Override
    public void edit(Employee employee) {
        try {
            employees.remove(employee.getId());
            employees.add(employee.getId(), employee);
        } catch (Exception e) {
            throw new RuntimeException("no object=" + employee + " found");
        }
    }

    /*SessionFactory sessionFactory;

    @Override
    public List<Employee> getAll() {
        return sessionFactory.getCurrentSession().createQuery("select * from Employee").list();
    }

    @Override
    public Employee get(Integer id) {
        return (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
    }

    @Override
    public void add(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }

    @Override
    public void delete(Integer id) {
        Employee employee = (Employee) sessionFactory.getCurrentSession().get(Employee.class, id);
        sessionFactory.getCurrentSession().delete(employee);
    }

    @Override
    public void edit(Employee employee) {
        Employee existingEmployee = (Employee) sessionFactory.getCurrentSession().get(Employee.class, employee.getId());

        existingEmployee.setName(employee.getName());

        sessionFactory.getCurrentSession().save(existingEmployee);
    }*/
}
