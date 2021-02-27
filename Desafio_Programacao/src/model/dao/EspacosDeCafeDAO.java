package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.EspacosDeCafe;

public class EspacosDeCafeDAO {

    /**
     * Inserindo EspacosDeCafe no banco
     *
     * @return
     */
    public void create(EspacosDeCafe edc) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO EspacosDeCafe (nomeEspacosDeCafe, lotacaoEspacosDeCafe, intervaloEspacosDeCafe)VALUES(?, ?, ?)");

            stmt.setString(1, edc.getNomeEspacosDeCafe());
            stmt.setInt(2, edc.getLotacaoEspacosDeCafe());
            stmt.setBoolean(3, edc.isIntervaloEspacosDeCafe());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    /**
     * Chamando EspacosDeCafe do banco
     *
     * @return
     */
    public List<EspacosDeCafe> read() {

        Connection con = null;

        PreparedStatement stmt = null;

        ResultSet rs = null;

        List<EspacosDeCafe> mostrarEspacosDeCafe = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement("SELECT * FROM EspacosDeCafe");
            rs = stmt.executeQuery();

            while (rs.next()) {

                EspacosDeCafe espacosDeCafeDoBanco = new EspacosDeCafe();

                espacosDeCafeDoBanco.setNomeEspacosDeCafe(rs.getString("nomeEspacosDeCafe"));
                espacosDeCafeDoBanco.setLotacaoEspacosDeCafe(rs.getInt("lotacaoEspacosDeCafe"));
                espacosDeCafeDoBanco.setIntervaloEspacosDeCafe(rs.getBoolean("intervaloEspacosDeCafe"));
                mostrarEspacosDeCafe.add(espacosDeCafeDoBanco);

            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return mostrarEspacosDeCafe;

    }
}
