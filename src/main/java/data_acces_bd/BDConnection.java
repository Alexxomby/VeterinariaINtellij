/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_acces_bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import jakarta.servlet.ServletContext;

/**
 *
 * @author user
 */
public class BDConnection {

    private static Connection connection;

    //dice definir constructor de la clase

    private BDConnection() {
    }

    public static Connection getConnection(ServletContext context){
        if(connection == null){
            try {
                String url = context.getInitParameter("http://localhost:3306/mascotas");
                String user = context.getInitParameter("root");
                String password = context.getInitParameter("batiziano2023");

                //malnacido driver del mysql
                Class.forName("com.mysql.cj.jdbc.Driver");

                connection = DriverManager.getConnection(url,user,password);


            } catch (SQLException | ClassNotFoundException  e) {
                System.out.println("No conecto porque peto");
                System.out.println("Error : "+ e.getMessage());
            }

        }
        return connection;
    }

}
