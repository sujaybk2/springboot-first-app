package com.javaguides.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import java.sql.*;
import java.util.List;

@RestController
public class WelcomeController {
    private Connection connection;

//    public WelcomeController() throws SQLException {
//        connection = connectToDatabase.getConnection();
//    }

    @GetMapping("/getAllProperty")
    public String welcome() {

        String query = "SELECT * FROM propertyList";
        try  {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/addProperties","root","12345678");
            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            // Process the result set and create a User object
            // Return the User object
            System.out.println("jjjjjjjjjjjj"+resultSet);
            while(resultSet.next()){
                String value1 = resultSet.getString(1);
                String value2 = resultSet.getString(2);
                String value3 = resultSet.getString(3);
                String value4 = resultSet.getString(4);
                String value5 = resultSet.getString(5);
                String value6 = resultSet.getString(6);
                String value7 = resultSet.getString(7);
                String value8 = resultSet.getString(8);

                System.out.println("listingNumber");
                System.out.println(value1);
                System.out.println("street_address");
                System.out.println(value2);
                System.out.println("street_name");
                System.out.println(value3);
                System.out.println("city");
                System.out.println(value4);
                System.out.println("state");
                System.out.println(value5);
                System.out.println("zip");
                System.out.println(value6);
                System.out.println("active_status");
                System.out.println(value7);
                System.out.println("cost");
                System.out.println(value8);
            }
        } catch (Exception e){

            e.printStackTrace();
        }
        return "Welcome to Sujay's Property Management, a Microservice";

    }


}





