import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class User{
    String user_id;
    String user_name;
    String user_address;

    public void add()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Details:\n Enter User ID");
        String user_id = sc.nextLine();
        System.out.println("Enter User Name:");
        String user_name = sc.nextLine();
       

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Employee", "root", "new-password");
            Statement stmt = con.createStatement();

            // Inserting data in database
            String q1 = "insert into user_info values('" + user_id + "', '" + user_name + "')";
            int x = stmt.executeUpdate(q1);
            if (x > 0)
                System.out.println("Successfully Inserted");
            else
                System.out.println("Insert Failed");

            //con.close();
        } catch (Exception e)
        {
            System.out.println(e);

        }

    }


    public void update()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID to update:");
        String user_id = sc.nextLine();
        System.out.println("Enter Address to update");
        String user_address = sc.nextLine();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Employee", "root", "new-password");
            Statement stmt = con.createStatement();
            String q1 = "UPDATE user_info set user_address = '" + user_address +
                    "' WHERE user_id = '" +user_id+ "'";
            int x = stmt.executeUpdate(q1);

            if (x > 0)
                System.out.println("Address Updated Successfully Updated");
            else
                System.out.println("ERROR OCCURED :(");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void delete()
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

    public void read(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID of record which you want to display:");
        String user_id = sc.nextLine();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Employee", "root", "new-password");
            Statement stmt = con.createStatement();

            // SELECT query
            String q1 = "select * from user_info WHERE id = '" + user_id +
                    "'";
            ResultSet rs = stmt.executeQuery(q1);
            if (rs.next())
            {
                System.out.println("User-Id : " + rs.getString(1)+"\n User_Name :" + rs.getString(2));

            }
            else
            {
                System.out.println("No such user id is already registered");
            }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        User mn=new User();
        System.out.println("Hello,Enter your choice");
        Scanner sc = new Scanner(System.in);

        int ch = 0;
        do{
            System.out.println("1.Add \n2.update \n3.delete \n4.display ");
            ch = sc.nextInt();



            switch (ch) {


                case 1:
                    mn.add();
                    break;
                case 2:
                    mn.update();
                    break;
                case 3:
                    mn.delete();
                case 4:
                    mn.read();
            }
        }while (ch>5);
    }
}








