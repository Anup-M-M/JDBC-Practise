
// import the package
import java.sql.*;

public class DemoJDBC {

    public static void main(String[] args){

        String url = "jdbc:mysql://localhost:3306/demo123";

        String username = "springstudent";

        String password = "springstudent";

       // String query = "select sname from student where sid=1";

        String query = "select * from student";



        try {
            //load and register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create the connection
            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Connection Established");

            //create statement
            Statement st = con.createStatement();

            //execute statement
            ResultSet rs = st.executeQuery(query);

            //process the results

            /*rs.next();
            String name = rs.getString("sname");
            System.out.println("Name of the Student is : "+ name);*/

            while (rs.next()){
                System.out.print(rs.getInt(1)+ " - ");
                System.out.print(rs.getString(2)+ " - ");
                System.out.println(rs.getInt(3));
            }

            //Close Connection
            con.close();
            System.out.println("Connection closed");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
