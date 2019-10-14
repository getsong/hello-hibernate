package com.getsong.hibernate.helloworld;

import com.getsong.hibernate.helloworld.entities.Student;
import com.getsong.hibernate.helloworld.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


/**
 * TODO: Purpose
 *
 * @author TODO: getso
 * @since 10/10/2019 8:20 PM
 */
public class App {
  public static void main(String[] args) {
    Student student = new Student("Ramesh", "Fadatare", "rameshfadatare@javaguides.com");
    Student student1 = new Student("John", "Cena", "john@javaguides.com");
    Transaction transaction = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      transaction = session.beginTransaction();
      session.save(student);
      session.save(student1);
      transaction.commit();
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    }

    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      transaction = session.beginTransaction();
      List<Student> students = session.createQuery("from Student", Student.class).list();
      students.forEach(System.out::println);
    } catch (Exception e) {
      if (transaction != null) {
        transaction.rollback();
      }
      e.printStackTrace();
    }
  }
}
