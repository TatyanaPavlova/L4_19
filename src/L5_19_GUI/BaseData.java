package L5_19_GUI;

import com.company.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BaseData {

    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    public static void Conn() throws ClassNotFoundException, SQLException {
        conn = DriverManager.getConnection("jdbc:sqlite:base.sdb");
    }

    public static void CreateDB() throws ClassNotFoundException, SQLException {
        Conn();
        statmt = conn.createStatement();
        statmt.execute("CREATE TABLE if not exists 'Insects' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'type' TEXT, 'countFeet' INT, 'countEyes' INT,'wings' TEXT, 'color' TEXT, 'variety' TEXT);");
        CloseDB();
    }

    public static void deleteFromDB() throws SQLException, ClassNotFoundException {
        Conn();
        statmt = conn.createStatement();
        statmt.executeUpdate("DROP TABLE IF EXISTS 'Insects'");
        CloseDB();
    }

    public static void WriteDB(Insects insects) throws SQLException, ClassNotFoundException {
        Conn();
        statmt = conn.createStatement();
        statmt.execute(String.format(
                "INSERT INTO Insects (type, countFeet, countEyes, wings, color, variety) " +
                        "VALUES ('%s', '%s','%s','%s','%s','%s')",
                insects.getType(), insects.getFeet(), insects.getEyes(), insects.getWings(), insects.getColor(), insects.getVariety()
        ));
        CloseDB();
    }


    public static ArrayList<Insects> ReadDB() throws ClassNotFoundException, SQLException {
        Conn();
        ArrayList<Insects> insects = new ArrayList<>();
        statmt = conn.createStatement();
        resSet = statmt.executeQuery("SELECT * FROM Insects");
        while (resSet.next()) {
            String type = resSet.getString("type");
            int countFeet = resSet.getInt("countFeet");
            int countEyes = resSet.getInt("countEyes");
            String wings = resSet.getString("wings");
            String color = resSet.getString("color");
            String variety = resSet.getString("variety");
            Insects ins = null;
            if ("Муравей".equals(type)) {
                ins = new Ant(countFeet, countEyes, wings, color, variety);
            }
            if ("Бабочка".equals(type)) {
                ins = new Butterfly(countFeet, countEyes, wings, color, variety);
            }
            if ("Гусеница".equals(type)) {
                ins = new Caterpillar(countFeet, countEyes, wings, color, variety);
            }
            if ("Комар".equals(type)) {
                ins = new Mosquito(countFeet, countEyes, wings, color, variety);
            }
            insects.add(ins);
        }
        resSet.close();
        CloseDB();
        return insects;
    }

    public static void CloseDB() throws ClassNotFoundException, SQLException {
        conn.close();
        statmt.close();
    }

}
