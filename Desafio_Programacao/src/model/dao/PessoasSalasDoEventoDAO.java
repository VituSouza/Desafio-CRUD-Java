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
import model.bean.PessoasSalasDoEvento;

public class PessoasSalasDoEventoDAO {

    /**
     * Inserindo PessoasSalasDoEvento no banco
     *
     * @return
     */
    public void create(PessoasSalasDoEvento pse) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO PessoasSalasDoEvento (pessoasIdPessoas, salasDoEventoIdSalasDoEvento, etapas)VALUES(?, ?, ?)");

            stmt.setInt(1, pse.getPessoasIdPessoas());
            stmt.setInt(2, pse.getSalasDoEventoIdSalasDoEvento());
            stmt.setBoolean(3, pse.isEtapas());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    /**
     * Chamando PessoasSalasDoEvento do banco
     *
     * @return
     */
    public List<PessoasSalasDoEvento> read() {

        Connection con = null;

        PreparedStatement stmt = null;

        ResultSet rs = null;

        List<PessoasSalasDoEvento> mostrarPessoasSalasDoEvento = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement("SELECT * FROM PessoasSalasDoEvento");
            rs = stmt.executeQuery();

            while (rs.next()) {

                PessoasSalasDoEvento pessoasSalasDoEventoDoBanco = new PessoasSalasDoEvento();

                pessoasSalasDoEventoDoBanco.setPessoasIdPessoas(rs.getInt("pessoasIdPessoas"));
                pessoasSalasDoEventoDoBanco.setSalasDoEventoIdSalasDoEvento(rs.getInt("salasDoEventoIdSalasDoEvento"));
                pessoasSalasDoEventoDoBanco.setEtapas(rs.getBoolean("etapas"));
                mostrarPessoasSalasDoEvento.add(pessoasSalasDoEventoDoBanco);

            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return mostrarPessoasSalasDoEvento;

    }
}
