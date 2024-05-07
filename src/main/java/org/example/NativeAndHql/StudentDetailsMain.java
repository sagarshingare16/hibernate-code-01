package org.example.NativeAndHql;

import jakarta.persistence.Query;
import org.example.utility.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Random;

public class StudentDetailsMain {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure().addAnnotatedClass(StudentDetails.class);
        SessionFactory sessionFactory=  configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        StudentDetails studentDetails = new StudentDetails();
        for(int i=1;i<=50;i++){
           studentDetails.setStudentRollNumber(i);
           studentDetails.setStudentName("name"+i);
           studentDetails.setStudentStandard("10-A");
           studentDetails.setStudentMarks(new Random().nextDouble(100));

           session.persist(studentDetails);
        }

        /*Query query = session.createQuery("from Student where marks>50 " , String.class);
        List<StudentDetails> studentList = query.getResultList();
        for(StudentDetails student : studentList){
            System.out.println(student);
        }*/

        /*Query query = session.createQuery("select rollNumber,name " +
                "from Student where rollNumber=7 " , String.class);
        StudentDetails[] studentRecord = (StudentDetails[]) query.getSingleResult();
        System.out.println(studentRecord[0]+":"+studentRecord[1]);*/


        session.getTransaction().commit();
        session.close();



    }
}
