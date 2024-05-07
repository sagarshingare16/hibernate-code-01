package org.example.crud;

import org.example.crud.entity.Student;
import org.example.utility.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DeleteStudent {
    public static void main(String[] args) {
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;

        try{
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            deleteStudent(session,302);
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
    public static void deleteStudent(Session session, int studentId){
        Student student = session.get(Student.class,studentId);
        session.remove(student);
        System.out.println("Record deleted successfully"+student);
    }
}
