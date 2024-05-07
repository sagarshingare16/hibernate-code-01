package org.example.mapping.ManyToMany;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;


public class LaunchApp {
    public static void main(String[] args) {

        Configuration configuration = new Configuration();

        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;

        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();

        Courses course1 = new Courses();
        course1.setCourseId(1);
        course1.setCourseName("Java");
        course1.setCoursePrice(1999);

        Courses course2 = new Courses();
        course2.setCourseId(2);
        course2.setCourseName("Hibernate");
        course2.setCoursePrice(499);

        Courses course3 = new Courses();
        course3.setCourseId(3);
        course3.setCourseName("SpringBoot");
        course3.setCoursePrice(999);

        Set<Courses> coursesSet1 = new HashSet<>();
        coursesSet1.add(course1);
        coursesSet1.add(course2);
        coursesSet1.add(course3);

        Set<Courses> coursesSet2 = new HashSet<>();
        coursesSet2.add(course1);
        coursesSet2.add(course2);

        Students student1 = new Students();
        student1.setStudentId(101);
        student1.setStudentName("Navin");
        student1.setStudentCity("Mumbai");
        student1.setCoursesSet(coursesSet1);

        Students student2 = new Students();
        student2.setStudentId(103);
        student2.setStudentName("Ramesh");
        student2.setStudentCity("Pune");
        student2.setCoursesSet(coursesSet2);

        try{
            transaction = session.beginTransaction();
            session.persist(student1);
            session.persist(student2);
            flag = true;
        }catch (HibernateException e){
            System.out.println("Something went wrong");
        }finally {
            if(flag){
                transaction.commit();
            }else {
                assert transaction != null;
                transaction.rollback();
            }
            sessionFactory.close();
        }







    }
}
