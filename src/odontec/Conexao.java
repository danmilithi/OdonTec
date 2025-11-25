package odontec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/OdonTecDB";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }
}
