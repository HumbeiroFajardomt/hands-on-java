package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataSource {
//1
  public static Connection connect(){
    String db_file = "jdbc:sqlite:resources/bank.db";
    //Declaration of connection object
    Connection connection = null;
    //it is neccesary handle the exception for getConnection 
    
    try{
      connection = DriverManager.getConnection(db_file);
      System.out.println("we're Connected");//Message to check Connection 
    }catch(SQLException e){
      e.printStackTrace();//git a log of the code execution path
    }

    return connection;//Test our connection by calling this method from the main method
    
  }
   
  //2
  public static Customer getCustomer(String username){
//to craft a sql query that  will get the customer data from the databases
//Using a String  we put the variable
String sql = "select * from customers where username = ?"; //it is not a good practice put the variable username,
//it could be used  as a sql injection meant to stel data
// put ? to serve as a placeholder // technique used to query the database will be safer
Customer customer = null; // to get access to customer var
//3 try catch with the resources to close the connection 
try(Connection connection = connect(); 
//additional resources
    PreparedStatement statement = connection.prepareStatement(sql)){
      //set Values for placeholders set method to do so ? is string so cal string method
      //possition placeholder ? = 1 there is just one and value = username
statement.setString(1, username);
//to execute query and add result set to complete the query and it is autoclosed
try(ResultSet resultset = statement.executeQuery()){
  customer = new Customer(
    resultset.getInt("id"),
    resultset.getString("name"),
    resultset.getString("password"),
    resultset.getString("username"),
    resultset.getInt("account_Id"));
}



}catch(SQLException e){
  e.printStackTrace();
}
return customer;
  }


  public static void main(String[] args){
   Customer customer =getCustomer("bdowsh4@mozilla.com");
    System.out.println(customer.getPassword());
  }

}
