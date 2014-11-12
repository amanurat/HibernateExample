package com.hibernate.annotation.entity;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * User: assanai.manurat
 * Date: 4/10/2014
 * Time: 2:56 PM
 */
public class DepartmentHibernateTest {


    Logger LOG = LoggerFactory.getLogger(getClass());


    private Configuration config = new Configuration();
    private SessionFactory sessionFactory = config.configure()
            .addAnnotatedClass(Employee.class)
            .addAnnotatedClass(Department.class).buildSessionFactory();


    private Session session;

    @Before
    public void setup() throws Exception {

        LOG.debug("*** Setup ***");
//        new SchemaExport(config).create(true, true);

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
        Department department = (Department) session.get(Department.class, 1);

        LOG.debug("TESTXXXX");
        System.out.println("department : " + department);
        System.out.println("name : " + department.getDepartmentName());
    }

    @Test
    public void testGetAllDepartment() throws Exception {
        List<Department> DepartmentList = session.createCriteria(Department.class).list();

        System.out.println("Total of Department : " + DepartmentList);
    }

    @Test
    public void testHQLNameQuery() throws Exception {

        List<Department> departments = session.getNamedQuery("GET_ALL_DEPARTMENT").list();
        System.out.println(departments);

        Query namedQuery = session.getNamedQuery("GET_DEPARTMENT_BY_ID");
        namedQuery.setInteger("ID", 1);

        Department department = (Department) namedQuery.list().get(0);
        System.out.println(department);

    }

    @Test
    public void testSQLNameQuery() throws Exception {

        Query query = session.getNamedQuery("GET_DEPARTMENT_BY_ID_NATIVE");
        query.setInteger("ID", 1);

        Department department = (Department) query.list().get(0);
        System.out.println(department);
        System.out.println(department.getDepartmentName());

    }
}
