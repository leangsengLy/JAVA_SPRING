import javax.swing.plaf.nimbus.State;
import javax.xml.transform.Result;
import java.sql.*;
public class DemoJDBC {
    public static void main(String[] args) throws Exception {
        /*import package
        laod and register
        create connect
        create statement*/
        //Class.forName("org.postgresql.Driver");

        String sql = "SELECT * FROM student";
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Demo","postgres","Pg@123");
        Statement stmt = con.createStatement();
        ResultSet resultDb = stmt.executeQuery(sql);
        while (resultDb.next()) {
            System.out.print(resultDb.getInt( 1) + " : ");
            System.out.print(resultDb.getString(2)+ " ");
            System.out.println(resultDb.getInt(3));
        }
//        PreparedStatement st = con.prepareStatement(sql);
//        st.setInt(1,30);
//        st.setString(2,"Soklinada");
//        st.setInt(3,30);
//        stmt.execute();
        con.close();
        System.out.println("connection close");

//        boolean result =  con.createStatement().execute(sql);
//        System.out.println(result);
//        resultDb.next();
//        String name = resultDb.getString("sname");
//        System.out.println("The Student name "+name);
//read all from table
//        while (resultDb.next()) {
//            System.out.print(resultDb.getInt( 1) + " : ");
//            System.out.print(resultDb.getString(2)+ " ");
//            System.out.println(resultDb.getInt(3));
//        }

    }
}
