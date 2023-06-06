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
                String value = resultSet.getString(1);

                System.out.println("value='"+value+"'");
            }
        } catch (Exception e){

            e.printStackTrace();
        }
        return "Welcome to Sujay's Property Management, a Microservice";

    }


}





