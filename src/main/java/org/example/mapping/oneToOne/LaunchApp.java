package org.example.mapping.oneToOne;

import org.example.mapping.oneToOne.entity.Answer;
import org.example.mapping.oneToOne.entity.Question;
import org.example.utility.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LaunchApp {
    public static void main(String[] args) {

        Session session = null;
        Transaction transaction = null;
        boolean flag = false;

        Question question1 = new Question();
        //question1.setQuestionId(1);
        question1.setQuestionName("What is Hibernate?");

        Answer answer1 = new Answer();
        //answer1.setAnswerId(101);
        answer1.setAnswerName("Hibernate is a ORM Framework");

        Question question2 = new Question();
        //question2.setQuestionId(2);
        question2.setQuestionName("What is JPA?");

        Answer answer2 = new Answer();
        //answer2.setAnswerId(102);
        answer2.setAnswerName("JPA is a ORA Specification.");

        question1.setAnswer(answer1);
        question2.setAnswer(answer2);

        try {
            session = HibernateUtil.getSession();
           /* Question question = session.get(Question.class,102);
            System.out.println(question);*/

            transaction = session.beginTransaction();

            session.persist(question1);
            session.persist(question2);

            flag = true;

        }catch (HibernateException e){
            System.out.println("Question not save.");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("Something went wrong!");
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

}
