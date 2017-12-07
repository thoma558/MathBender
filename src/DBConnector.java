import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBConnector {

    public static void main(String[] args){
        DBConnector db = new DBConnector();
        //db.addScore("rushan", 1);
    }

    // String url = "jdbc:mysql://mathbender.cpa845rkfsyh.us-east-2.rds.amazonaws.com:3306/";
    String url = "mathbender.cpa845rkfsyh.us-east-2.rds.amazonaws.com";
    String dbName = "mathbender";
    String username = "root";
    String password = "password";

    //port=3306

    Connection con = null;
    Statement statement = null;
    ResultSet rs = null;
    public DBConnector(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        String connectionUrl = "jdbc:mysql://"+url + ":3306/";
        try {
            con= DriverManager.getConnection(connectionUrl + dbName, username, password);
            statement = con.createStatement();
        } catch (Exception e) {
          System.out.println("Connection Failed\n"+e.getMessage());
        }
    }


    public void addScore(String username, int score) {
        String date="2017-01-01";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        date = dateFormat.format(d);
        String sql = String.format("INSERT INTO scores\n values (\'%s\', %d, \'%s\')", username, score, date);
        try {
            statement.executeUpdate(sql);
            //rs=statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
