import java.sql.*;
import java.util.Scanner;

public class employeee {

    static final String URL = "jdbc:mysql://localhost:3306/training_db";
    static final String USER = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Connected");

            while (true) {

                System.out.println("\nOPERATIONS TO PERFORM");
                System.out.println("1. Insert Employee");
                System.out.println("2. View All Employees");
                System.out.println("3. View Specific Employee");
                System.out.println("4. Update Employee");
                System.out.println("5. Delete Employee");
                System.out.println("6. Exit");
                System.out.print("Enter Your Choice: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        String insert = "INSERT INTO employee VALUES(?,?,?,?,?,?,?,?,?,?,?)";
                        PreparedStatement p = con.prepareStatement(insert);
                        System.out.print("Enter Employee ID: ");
                        int empid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Employee Name: ");
                        String empname = sc.nextLine();
                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();
                        System.out.print("Enter Mobile Number: ");
                        String mobile = sc.nextLine();
                        System.out.print("Enter City: ");
                        String city = sc.nextLine();
                        System.out.print("Enter State: ");
                        String state = sc.nextLine();
                        System.out.print("Enter Date Of Joining (YYYY-MM-DD): ");
                        String doj = sc.nextLine();
                        System.out.print("Enter Department ID: ");
                        int deptid = sc.nextInt();
                        System.out.print("Enter Project ID: ");
                        int projid = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Status (ACTIVE/INACTIVE): ");
                        String status = sc.nextLine();
                        System.out.print("Enter Experience: ");
                        int exp = sc.nextInt();
                        p.setInt(1, empid);
                        p.setString(2, empname);
                        p.setString(3, email);
                        p.setString(4, mobile);
                        p.setString(5, city);
                        p.setString(6, state);
                        p.setString(7, doj);
                        p.setInt(8, deptid);
                        p.setInt(9, projid);
                        p.setString(10, status);
                        p.setInt(11, exp);
                        int i = p.executeUpdate();
                        if (i > 0) {
                            System.out.println("Employee Inserted");
                        } else {
                            System.out.println("Insertion Failed");
                        }
                        break;

                    case 2:

                        String selectQuery = "SELECT * FROM employee";

                        Statement s = con.createStatement();

                        ResultSet rs = s.executeQuery(selectQuery);

                        System.out.println("\n----- EMPLOYEE DETAILS -----");

                        while (rs.next()) {

                            System.out.println("Employee ID      : " + rs.getInt("empid"));
                            System.out.println("Employee Name    : " + rs.getString("empname"));
                            System.out.println("Email ID         : " + rs.getString("emailid"));
                            System.out.println("Mobile Number    : " + rs.getString("mobilenumber"));
                            System.out.println("City             : " + rs.getString("city"));
                            System.out.println("State            : " + rs.getString("state"));
                            System.out.println("Date Of Joining  : " + rs.getDate("date_of_joining"));
                            System.out.println("Department ID    : " + rs.getInt("departmentid"));
                            System.out.println("Project ID       : " + rs.getInt("projectid"));
                            System.out.println("Status           : " + rs.getString("status"));
                            System.out.println("Experience       : " + rs.getInt("experience"));

                            System.out.println("--------------------------------");
                        }

                        break;

                    case 3:

                        System.out.print("Enter Employee ID To View: ");

                        int searchId = sc.nextInt();

                        String specificQuery = "SELECT * FROM employee WHERE empid=?";

                        PreparedStatement sp = con.prepareStatement(specificQuery);

                        sp.setInt(1, searchId);

                        ResultSet sr =
                                sp.executeQuery();

                        if (sr.next()) {

                            System.out.println("\n----- EMPLOYEE DETAILS -----");

                            System.out.println("Employee ID      : " + sr.getInt("empid"));
                            System.out.println("Employee Name    : " + sr.getString("empname"));
                            System.out.println("Email ID         : " + sr.getString("emailid"));
                            System.out.println("Mobile Number    : " + sr.getString("mobilenumber"));
                            System.out.println("City             : " + sr.getString("city"));
                            System.out.println("State            : " + sr.getString("state"));
                            System.out.println("Date Of Joining  : " + sr.getDate("date_of_joining"));
                            System.out.println("Department ID    : " + sr.getInt("departmentid"));
                            System.out.println("Project ID       : " + sr.getInt("projectid"));
                            System.out.println("Status           : " + sr.getString("status"));
                            System.out.println("Experience       : " + sr.getInt("experience"));

                        } else {

                            System.out.println("Employee Not Found");
                        }

                        break;

                    case 4:

                        System.out.print("Enter Employee ID To Update: ");

                        int updateId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter New City: ");

                        String newCity = sc.nextLine();

                        String updateQuery =
                                "UPDATE employee SET city=? WHERE empid=?";

                        PreparedStatement ups =
                                con.prepareStatement(updateQuery);

                        ups.setString(1, newCity);
                        ups.setInt(2, updateId);

                        int u = ups.executeUpdate();

                        if (u > 0) {

                            System.out.println("Employee Updated");

                        } else {

                            System.out.println("Employee Not Found");
                        }

                        break;

                    case 5:

                        System.out.print("Enter Employee ID To Delete: ");

                        int deleteId = sc.nextInt();

                        String deleteQuery =
                                "DELETE FROM employee WHERE empid=?";

                        PreparedStatement dps =
                                con.prepareStatement(deleteQuery);

                        dps.setInt(1, deleteId);

                        int d = dps.executeUpdate();

                        if (d > 0) {

                            System.out.println("Employee Deleted");

                        } else {

                            System.out.println("Employee Not Found");
                        }

                        break;

                    case 6:

                        System.out.println("Exit");

                        con.close();

                        System.exit(0);

                    default:

                        System.out.println("Invalid Choice");
                }
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}