package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/bd_desafio_programacao?useTimezone=true&serverTimezone=UTC&user=root&password=root";
    private static final String USER = "root";
    private static final String PASS = "root";

    /**
     * O metodo getConnection chama a conexão do banco
     *
     * @return
     */
    public static Connection getConnection() {

        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Erro na Conexão: ", ex);
        }
    }

    /**
     * O metodo closeConnection fecha a conexão banco com o parametro con
     *
     * @return
     */
    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * O metodo closeConnection fecha a conexão banco com o parametro con e stmt
     *
     * @return
     */
    public static void closeConnection(Connection con, PreparedStatement stmt) {
        closeConnection(con);
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * O metodo closeConnection fecha a conexão banco com o parametro con,stmt e
     * rs
     *
     * @return
     */
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        closeConnection(con, stmt);
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
