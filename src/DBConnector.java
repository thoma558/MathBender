import java.sql.*;

public class DBConnector {

    String url = "mathbender.cpa845rkfsyh.us-east-2.rds.amazonaws.com";
    String username = "root";
    String password = "password";

    //port=3306

    Connection con = null;
    Statement statement = null;
    ResultSet rs = null;
    public DBConnector(){
        String connnectionUrl = url + ";" + "databaseName=mathbender;" + "user="+username + ";password="+password;
        try {
            con= DriverManager.getConnection(connnectionUrl);
            statement = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void addScore(String username, int score) {
        String date="";
        String sql = String.format("INSERT INTO scores\n values (\'%s\', %d, \'%s\')", username, score, date);
        try {
            rs=statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
