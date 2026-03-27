package org.starnoh;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;


// CRUD Operations
public class StudentDao {

    public void saveStudent (Student student){
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(student);
            transaction.commit();
        } catch(Exception e) {
            e.printStackTrace();

            if (transaction != null && transaction.getStatus().canRollback()) {

                try {
                transaction.rollback();

                } catch (IllegalStateException ise){
                    System.err.println("Could not rollback: Connection already closed");
                }
            }

        }


    }

    public Student getStudent(Long id){
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(Student.class , id);
        }
    }

    public void updateStudent(Student student) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(student);
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();

            if (transaction != null && transaction.getStatus().canRollback()) {

                try {
                    transaction.rollback();

                } catch (IllegalStateException ise){
                    System.err.println("Could not rollback: Connection already closed");
                }
            }
        }
    }

    public void deleteStudent(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Student student = session.find(Student.class , id);
            if(student != null){
                session.remove(student);
            }
            transaction.commit();

        } catch (Exception e){
            e.printStackTrace();

            if (transaction != null && transaction.getStatus().canRollback()) {

                try {
                    transaction.rollback();

                } catch (IllegalStateException ise){
                    System.err.println("Could not rollback: Connection already closed");
                }
            }
        }
    }
}


