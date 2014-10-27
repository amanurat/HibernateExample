package com.hibernate.annotation.entity;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


/**
 * User: assanai.manurat
 * Date: 4/10/2014
 * Time: 2:56 PM
 */
public class StudentHibernateTest {


    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    private Session session;

    @Before
    public void setup() throws Exception {
        session = sessionFactory.openSession();
    }

    @After
    public void tearDown() throws Exception {
       session.close();
    }

    @Test
    public void testInsertStudent() throws Exception {
        session.beginTransaction();

        Student student1 = new Student("student1", "student1@email.com");
        session.save(student1);
        Student student2 = new Student("student2", "student2@email.com");
        session.save(student2);
        Student student3 = new Student("student3", "student3@email.com");
        session.save(student3);

        session.getTransaction().commit();
    }

    @Test
    public void testGetStudent() throws Exception {
        Student student  = (Student) session.get(Student.class, 2L);
        System.out.println("student : "+ student);
        System.out.println("name : " + student.getName());
        System.out.println("email : " + student.getEmail());

    }

    @Test
    public void testGetAllStudent() throws Exception {
        List<Student> studentList = session.createCriteria(Student.class).list();

        System.out.println("Total of student : "+ studentList);

    }
}
