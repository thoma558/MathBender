import org.junit.Test;

public class DBTest {

    //Test class for DB Connection

    @Test
    public void testConnection(){
        DBConnector db = new DBConnector();
        db.addScore("Rushan", 3);

    }
}
