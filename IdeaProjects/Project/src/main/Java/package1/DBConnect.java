package package1 ;

import java.sql.*;
import java.util.Scanner;

public class DBConnect
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID to delete:");
        String user_id = sc.nextLine();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Employee", "root", "new-password");
            Statement stmt = con.createStatement();

            String q1 = "DELETE from user_info WHERE user_id = '" + user_id +
                    '\'';

            int x = stmt.executeUpdate(q1);

            if (x > 0)
                System.out.println("One User Successfully Deleted");
            else
                System.out.println("ERROR OCCURED :(");

            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
