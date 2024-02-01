import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class PrepareJdbc {

    public static void main(String[] args){

        String url = "jdbc:mysql://localhost:3306/demo123";

        String username = "springstudent";

        String password = "springstudent";

        int sid = 4;

        String sname = "Arun";

        int marks = 90;

        String query = "insert into student values(?,?,?)";


        try {
            //load and register the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create the connection
            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Connection Established");

            //create statement
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1,sid);
            st.setString(2,sname);
            st.setInt(3,marks);

            st.execute();
//            System.out.println(status);

            //Close Connection
            con.close();
            System.out.println("Connection closed");

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
