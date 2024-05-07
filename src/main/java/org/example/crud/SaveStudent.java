package org.example.crud;

import org.example.crud.entity.Student;
import org.example.crud.entity.StudentAddress;
import org.example.crud.entity.StudentName;
import org.example.utility.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Scanner;

public class SaveStudent {
    public static void main(String[] args) {
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;

        try {
            session = HibernateUtil.getSession();
            transaction = session.beginTransaction();
            Student student = getStudent();
            session.persist(student);
            flag = true;

        }catch (HibernateException e){
            System.out.println("Unable to save data in database");
            e.printStackTrace();

        }catch (Exception e){
            System.out.println("Something went wrong!");
            e.printStackTrace();

        }finally {
            if(flag){
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
    private static Student getStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Student First Name:");
        String firstName = scanner.nextLine();

        System.out.print("Enter Student Middle Name:");
        String middleName = scanner.nextLine();

        System.out.print("Enter Student Last Name:");
        String lastName = scanner.nextLine();

        System.out.print("Enter House Number:");
        int houseNumber = scanner.nextInt();

        System.out.print("Enter Locality:");
        String area = scanner.nextLine();

        System.out.print("Enter City Name:");
        String city = scanner.nextLine();

        System.out.print("Enter Student Standard:");
        String standard = scanner.nextLine();

        StudentName studentName = new StudentName();
        studentName.setFirstName(firstName);
        studentName.setMiddleName(middleName);
        studentName.setLastName(lastName);

        StudentAddress studentAddress = new StudentAddress();
        studentAddress.setHouseNumber(houseNumber);
        studentAddress.setArea(area);
        studentAddress.setCityName(city);

        Student student = new Student();
        student.setStudentStandard(standard);
        student.setStudentName(studentName);
        student.setStudentAddress(studentAddress);

        return student;
    }

}
