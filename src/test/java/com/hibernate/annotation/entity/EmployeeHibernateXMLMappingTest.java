package com.hibernate.annotation.entity;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * User: assanai.manurat
 * Date: 4/10/2014
 * Time: 2:56 PM
 */
public class EmployeeHibernateXMLMappingTest {

    private Configuration config = new Configuration();
    private SessionFactory sessionFactory = config.configure().buildSessionFactory();
    private Session session;

    @Before
    public void setup() throws Exception {

        new SchemaExport(config).create(true, true);

        session = sessionFactory.openSession();
    }

    @After
    public void tearDown() throws Exception {
       session.close();
    }

    @Test
    public void testInsertDepartment() throws Exception {
        session.beginTransaction();

        Department department = new Department("IT");
        session.save(department);

        Department department2 = new Department("HR");
        session.save(department2);

        session.getTransaction().commit();
    }

    @Test
    public void testGetDepartment() throws Exception {
        Department Department  = (Department) session.get(Department.class, 1);
        System.out.println("Department : "+ Department);
        System.out.println("name : " + Department.getDepartmentName());
    }

    @Test
    public void testGetAllDepartment() throws Exception {
        List<Department> DepartmentList = session.createCriteria(Department.class).list();

        System.out.println("Total of Department : "+ DepartmentList);
    }
}
