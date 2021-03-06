package com.mokujin.dao.employee;

import com.mokujin.model.employee.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class IEmployeeDAO implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Employee> getAll() {
        return sessionFactory.getCurrentSession().createQuery("select e from Employee e order by e.id").list();
    }

    @Override
    public Employee get(int id) {
        return sessionFactory.getCurrentSession().get(Employee.class, id);
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
        sessionFactory.getCurrentSession().update(employee);
    }
}
