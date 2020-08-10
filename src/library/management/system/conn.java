package library.management.system;


import java.sql.*;  

public class conn{
    Connection c; // interfaces
    Statement s;
    public conn(){  
        try{  
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  //Registering the driver class
           c =DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Library_Management_System1;user=admin;password=7890");   //Creating Connection  
           s =c.createStatement();  //creating statement
            
           
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
} 