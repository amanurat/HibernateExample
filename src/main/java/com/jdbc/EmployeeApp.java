package com.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.EnumMap;

/**
 * Created by amanurat on 11/16/14 AD.
 */
public class EmployeeApp {

    public static void main(String[] args) throws Exception {

        // The credentials that we need to have available for the connection to the database.
        String username = "root";
        String password = "";
        String databaseName = "hibernatedb";

        Connection connect = null;
        Statement statement = null;

        try {
            // Load the MySQL driver.
            Class.forName("com.mysql.jdbc.Driver");

            // Setup the connection to the database.
            // Take notice at the different variables that are needed here:
            //		1. The name of the database and its location (currently localhost)
            //		2. A valid username/password for the connection.
            connect = DriverManager.getConnection("jdbc:mysql://localhost/"
                    + databaseName + "?"
                    + "user=" + username
                    + "&password=" + password);

            // Create the statement to be used to get the results.
            statement = connect.createStatement();

            // Create a query to use.
            String query = "SELECT * FROM EMPLOYEE";

            // Execute the query and get the result set, which contains
            // all the results returned from the database.
            ResultSet resultSet = statement.executeQuery(query);

            ArrayList<Employee> employees = new ArrayList<Employee>();

            while (resultSet.next()) {

                // Now we can fetch the data by column name, save and use them!
                int employeeId = resultSet.getInt("EMPLOYEE_ID");
                String firstName = resultSet.getString("FIRST_NAME");
                String lastName = resultSet.getString("LAST_NAME");
                int age = resultSet.getInt("age");

                Employee employee = new Employee();
                employee.setId(employeeId);
                employee.setFirstName(firstName);
                employee.setLastName(lastName);
                employee.setAge(age);

                employees.add(employee);

//                System.out.println("\temployeeId: " + employeeId + ", firstName: " + firstName + ", age: " + age);
            }

            for (Employee employee : employees) {
                System.out.println("employeeId: " + employee.getId() + "," +
                        " firstName: " + employee.getFirstName() + ", " +
                        " lastName: " + employee.getLastName() + ", " +
                        " age: " + employee.getAge());

            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // We have to close the connection and release the resources used.
            // Closing the statement results in closing the resultSet as well.
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }


}
