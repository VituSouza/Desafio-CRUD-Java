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
import model.bean.Pessoas;

public class PessoasDAO {

    /**
     * Inserindo Pessoas no banco
     *
     * @return
     */
    public void create(Pessoas pes) {

        Connection con = null;

        PreparedStatement stmt = null;

        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement("INSERT INTO Pessoas (idPessoas, nomePessoas, sobrenomePessoas)VALUES(0, ?, ?)");

            stmt.setString(1, pes.getNomePessoas());
            stmt.setString(2, pes.getSobrenomePessoas());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com Sucesso!");
        } catch (SQLException | RuntimeException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    /**
     * Chamando Pessoas do banco
     *
     * @return
     */
    public List<Pessoas> read() {

        Connection con = null;

        PreparedStatement stmt = null;

        ResultSet rs = null;

        List<Pessoas> mostrarPessoa = new ArrayList<>();

        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement("SELECT * FROM Pessoas");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Pessoas pessoasDoBanco = new Pessoas();

                pessoasDoBanco.setNomePessoas(rs.getString("nomePessoas"));
                pessoasDoBanco.setSobrenomePessoas(rs.getString("sobrenomePessoas"));
                mostrarPessoa.add(pessoasDoBanco);

            }
        } catch (SQLException ex) {
            Logger.getLogger(PessoasDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return mostrarPessoa;

    }
}
