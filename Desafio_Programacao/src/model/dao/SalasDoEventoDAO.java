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
import model.bean.SalasDoEvento;

public class SalasDoEventoDAO {

    /**
     * Inserindo SalasDoEvento no banco
     *
     * @return
     */
    public void create(SalasDoEvento sde) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO SalasDoEvento (nomeSalasDoEvento, lotacaoSalasDoEvento)VALUES(?, ?)");

            stmt.setString(1, sde.getNomeSalasDoEvento());
            stmt.setInt(2, sde.getLotacaoSalasDoEvento());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    /**
     * Chamando SalasDoEnveto do banco
     *
     * @return
     */
    public List<SalasDoEvento> read() {

        Connection con = null;

        PreparedStatement stmt = null;

        ResultSet rs = null;

        List<SalasDoEvento> mostrarSalasDoEvento = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement("SELECT * FROM SalasDoEvento");
            rs = stmt.executeQuery();

            while (rs.next()) {

                SalasDoEvento salasDoEventoDoBanco = new SalasDoEvento();

                salasDoEventoDoBanco.setId(rs.getInt("idSalasDoEvento"));
                salasDoEventoDoBanco.setNomeSalasDoEvento(rs.getString("nomeSalasDoEvento"));
                salasDoEventoDoBanco.setLotacaoSalasDoEvento(rs.getInt("lotacaoSalasDoEvento"));
                mostrarSalasDoEvento.add(salasDoEventoDoBanco);

            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return mostrarSalasDoEvento;

    }
}
