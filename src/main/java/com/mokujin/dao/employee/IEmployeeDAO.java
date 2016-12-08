package com.mokujin.dao.employee;

import com.mokujin.models.employee.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class IEmployeeDAO implements EmployeeDAO {

    /*List<Employee> employees = new ArrayList<>();

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
        getAll().forEach(System.out::println);
    }

    @Override
    public void delete(Integer id) {
        try {
            for (Employee employee : employees) {
                if (employee.getId() == id) {
                    employees.remove(employee);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("no object with id=" + id + " found");
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
    }*/

    @Autowired
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> getAll() {
        return sessionFactory.getCurrentSession().createQuery("select * from Employee").list();
    }

    @Override
    public Employee get(Integer id) {
        return  sessionFactory.getCurrentSession().get(Employee.class, id);
    }

    @Override
    public void add(Employee employee) {
        sessionFactory.getCurrentSession().save(employee);
    }

    @Override
    public void delete(Integer id) {
        Employee employee = sessionFactory.getCurrentSession().get(Employee.class, id);
        sessionFactory.getCurrentSession().delete(employee);
    }

    @Override
    public void edit(Employee employee) {
        Employee existingEmployee = sessionFactory.getCurrentSession().get(Employee.class, employee.getId());

        existingEmployee.setName(employee.getName());

        sessionFactory.getCurrentSession().save(existingEmployee);
    }
}
