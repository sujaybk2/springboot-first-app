package com.javaguides.springboot;

import org.springframework.web.bind.annotation.*;

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

        String query = "SELECT * FROM propertyListing";
        try  {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/propertyListing","root","12345678");
            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            // Process the result set and create a User object
            // Return the User object
            System.out.println("jjjjjjjjjjjj"+resultSet);
            model obj = new model(); //create an object for the model class
            while(resultSet.next()){
                obj.listingNumber  = resultSet.getInt(1);
                obj.street_address = resultSet.getString(2);
                obj.street_name    = resultSet.getString(3);
                obj.city           = resultSet.getString(4);
                obj.state          = resultSet.getString(5);
                obj.zip            = resultSet.getInt(6);
                obj.active_status  = resultSet.getBoolean(7);
                obj.cost           = resultSet.getInt(8);


                System.out.println(obj.listingNumber+" " + obj.street_address + " " + obj.street_name + " " + obj.city + " " + obj.state + " " + obj.zip + " " + obj.active_status + " " + obj.cost);

            }
        } catch (Exception e){

            e.printStackTrace();
        }
        return "Welcome to Sujay's Property Management, a Microservice";

    }

    @PostMapping("/createProperty")
    public String insertProperty(int streetNumber,String streetName){

        String city = "WalnutCReek", state="CA";
         int zip= 23445;
         boolean activeStatus=true;
         int cost = 1232322;
        String query = "INSERT INTO propertyListing ( street_address, street_name, city, state, zip, active_status, cost) VALUES ("+ "\""+ streetNumber +"\""+ "," + streetName + "," +"\""+ city +"\""+ "," +"\""+ state +"\""+ "," + zip + "," + activeStatus + "," + cost +")";
        System.out.println("hiiiiiiii"+query);
        try  {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/propertyListing","root","12345678");
            PreparedStatement statement = connection.prepareStatement(query);
//            statement.setInt(1, userId);
            int resultSet = statement.executeUpdate();
            // Process the result set and create a User object
            // Return the User object
            return "Post/Insert is successful"+ resultSet;
        } catch (Exception e){

            e.printStackTrace();
        } finally{
            return "finalllyyy";
        }

    }

//    @PutMapping("/updateProperty")
//    {
//
//        return "Creation successful";
//    }
//    @DeleteMapping("/deleteProperty"){
//
//        return "Deletion successful";
//    }

}





