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
import model.bean.PessoasEspacosDeCafe;

public class PessoasEspacosDeCafeDAO {

    /**
     * Inserindo PessoasEspacosDeCafe no banco
     *
     * @return
     */
    public void create(PessoasEspacosDeCafe pec) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO PessoasEspacosDeCafe (pessoasIdPessoas, espacosDeCafeIdEspacosDeCafe)VALUES(?, ?)");

            stmt.setInt(1, pec.getPessoasIdPessoas());
            stmt.setInt(2, pec.getEspacosDeCafeIdEspacosDeCafe());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    /**
     * Chamando PessoasEspacosDeCafe do banco
     *
     * @return
     */
    public List<PessoasEspacosDeCafe> read() {

        Connection con = null;

        PreparedStatement stmt = null;

        ResultSet rs = null;

        List<PessoasEspacosDeCafe> mostrarEspacosDeCafe = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement("SELECT * FROM PessoasEspacosDeCafe");
            rs = stmt.executeQuery();

            while (rs.next()) {

                PessoasEspacosDeCafe EspacosDeCafeDoBanco = new PessoasEspacosDeCafe();

                EspacosDeCafeDoBanco.setPessoasIdPessoas(rs.getInt("pessoasIdPessoas"));
                EspacosDeCafeDoBanco.setEspacosDeCafeIdEspacosDeCafe(rs.getInt("espacosDeCafeIdEspacosDeCafe"));
                mostrarEspacosDeCafe.add(EspacosDeCafeDoBanco);

            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return mostrarEspacosDeCafe;

    }
}
