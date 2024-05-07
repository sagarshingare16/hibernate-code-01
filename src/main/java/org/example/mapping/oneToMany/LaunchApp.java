package org.example.mapping.oneToMany;

import org.example.utility.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class LaunchApp {
    public static void main(String[] args) {

        Session session = null;
        Transaction transaction = null;
        boolean flag = false;

        try{
            Department department = getDepartment();
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
           // session.persist(employees);
            session.persist(department);      //because department should already exit to save employee.
            flag = true;

        }catch (HibernateException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (flag){
                transaction.commit();
            }else {
                if(transaction != null) {
                    transaction.rollback();
                }
            }
            assert session != null;
            HibernateUtil.closeSession(session);
        }

    }

    private static Department getDepartment() {
        Department department = new Department();
        department.setDepartmentId(1);
        department.setDepartmentName("Engineering");

        Employee employee1 = new Employee();
        employee1.setEmployeeId(101);
        employee1.setEmployeeName("Navin");
        employee1.setEmployeeAddress("Mumbai");
        employee1.setDepartment(department);

        Employee employee2 = new Employee();
        employee2.setEmployeeId(102);
        employee2.setEmployeeName("Kiran");
        employee2.setEmployeeAddress("Delhi");
        employee2.setDepartment(department);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);

        department.setEmployees(employees);
        return department;
    }

}
