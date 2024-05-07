package org.example.crud;

import org.example.crud.entity.Student;
import org.example.utility.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class GetStudent {
    public static void main(String[] args) {
        Session session = null;
        try {
            session = HibernateUtil.getSession();

            Student student = fetchStudent(session,302);
            System.out.print("Student information :" +student);

        }catch (HibernateException e){
            System.out.print("student details fetch successfully");
            e.printStackTrace();

        }catch (Exception e){
            System.out.print("Something went wrong!");
            e.printStackTrace();

        }finally {
            assert session != null;
            HibernateUtil.closeSession(session);
            System.out.println("Session close successfully");
        }

    }
    public static Student fetchStudent(Session session, int studentId){
        Student studentInfo;
        System.out.println("Fetch student using get() method..");
        studentInfo = session.get(Student.class,studentId);

        /*System.out.println("Fetch student using getReference() methods..");
        studentInfo = session.getReference(Student.class,studentId);*/

        return studentInfo;
    }
}
