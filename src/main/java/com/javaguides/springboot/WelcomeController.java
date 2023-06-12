package com.javaguides.springboot;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import java.sql.*;
import java.util.List;

@RestController
public class WelcomeController {
    private Connection connection;

    @GetMapping("/getAllProperty")
    public List<model> welcome() {

        List<model> result = new ArrayList<model>();  //creating result list
        model obj = new model(); //create an object for the model class
        String query = "SELECT * FROM propertyListing";
        try  {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();     connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/propertyListing","root","12345678");
//
            PreparedStatement statement = connection.prepareStatement(query);
//           Run the query
            ResultSet resultSet = statement.executeQuery();
            // Process the result set and create a User object
            // Return the User object
//            System.out.println(resultSet);

            while(resultSet.next()){
                obj = new model();
                obj.listingNumber  = resultSet.getInt(1);
                obj.street_address = resultSet.getString(2);
                obj.street_name    = resultSet.getString(3);
                obj.city           = resultSet.getString(4);
                obj.state          = resultSet.getString(5);
                obj.zip            = resultSet.getInt(6);
                obj.cost           = resultSet.getInt(7);

                result.add(obj);
//                System.out.println(obj.listingNumber+" " + obj.street_address + " " + obj.street_name + " " + obj.city + " " + obj.state + " " + obj.zip + " " + " " + obj.cost);

            }
        } catch (Exception e){

            e.printStackTrace();
        } finally {
            return result;
        }


    }

    @PostMapping("/createProperty")
    public String insertProperty(@RequestParam(value = "params") int streetNumber,
                                 @RequestParam(value = "stn") String streetName,
                                 @RequestParam(value = "ct") String city,
                                 @RequestParam(value = "st") String state,
                                 @RequestParam(value = "zp") int zip,
                                 @RequestParam(value = "cs") int cost){
        String query = "INSERT INTO propertyListing ( street_address, street_name, city, state, zip, cost) VALUES ("+ streetNumber + "," + streetName + "," + city + "," + state + "," + zip + "," + cost +")";
        System.out.println(query);
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
            return "Completed query";
        }

    }
//      @PatchMapping("/partialUpdateProperty")
//      {
//
//      }
//          return "Patch successful";
//      }
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





