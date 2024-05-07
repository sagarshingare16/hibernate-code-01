package org.example.crud;

import org.example.crud.entity.Student;
import org.example.utility.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UpdateStudent {
    public static void main(String[] args) {
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;

        try{
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            updateStudent(session,302);
            flag = true;

        }catch (HibernateException e){
            System.out.println("Unable to update/save/delete student..");
            e.printStackTrace();

        }catch (Exception e){
            System.out.println("Something went wrong..");
            e.printStackTrace();

        }finally {
            if(flag){
                transaction.commit();
            }else {
                assert transaction != null;
                transaction.rollback();
            }

            HibernateUtil.closeSession(session);
            System.out.println("Session closed successfully..");
        }

    }
    public static void updateStudent(Session session, int studentId){
        Student student = session.getReference(Student.class,studentId);
        student.setStudentStandard("11-A");
        session.persist(student);
        System.out.println("Student updated successfully..");
    }
}
