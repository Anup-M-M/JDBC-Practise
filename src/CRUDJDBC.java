import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CRUDJDBC {

    public static void main(String[] args){

        String url = "jdbc:mysql://localhost:3306/demo123";

        String username = "springstudent";

        String password = "springstudent";

       // String query = "insert into student values(3, 'Anup', 50)";
      // String query = "update student set sname='rash' where sid=2";
        String query = "delete from student where sid=2";

        try {
            //load and register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create the connection
            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Connection Established");

            //create statement
            Statement st = con.createStatement();

            st.execute(query);
//            System.out.println(status);

            //Close Connection
            con.close();
            System.out.println("Connection closed");

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
