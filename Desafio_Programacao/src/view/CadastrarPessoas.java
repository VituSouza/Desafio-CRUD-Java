package view;

import java.util.List;
import model.bean.Pessoas;
import model.bean.PessoasSalasDoEvento;
import model.bean.SalasDoEvento;
import model.dao.PessoasDAO;
import model.dao.PessoasEspacosDeCafeDAO;
import model.dao.PessoasSalasDoEventoDAO;
import model.dao.SalasDoEventoDAO;

public class CadastrarPessoas extends javax.swing.JFrame {

    public CadastrarPessoas(int etapa) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.etapa = etapa;
    }

    private int etapa = 0;

    /**
     * Verificar quantidade de pessoas na SalasDoEvento
     *
     * @return
     */
    private void verificarPessoa(int idPessoa) {
        PessoasEspacosDeCafeDAO pessoasEspacosDeCafeDAO = new PessoasEspacosDeCafeDAO();
        PessoasSalasDoEventoDAO pessoasSalasDoEventoDAO = new PessoasSalasDoEventoDAO();
        SalasDoEventoDAO salasDoEventoDAO = new SalasDoEventoDAO();

        List<PessoasSalasDoEvento> pessoasSalasDoEvento = pessoasSalasDoEventoDAO.read();
        List<SalasDoEvento> salasDoEvento = salasDoEventoDAO.read();

        for (SalasDoEvento sala : salasDoEvento) {
            int qtd = 0;
            for (PessoasSalasDoEvento pessoasComSala : pessoasSalasDoEvento) {
                if (sala.getId() == pessoasComSala.getSalasDoEventoIdSalasDoEvento()) {

                    qtd++;
                }
            }

            sala.setQtdPessoas(qtd);
        }

        boolean todosIguais = false;

        for (int i = 0; i < salasDoEvento.size(); i++) {
            if (i != 0) {
                if (salasDoEvento.get(0).getQtdPessoas() > salasDoEvento.get(i).getQtdPessoas()) {
                    System.out.println(i);
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNomePessoas = new javax.swing.JLabel();
        txtNomePessoas = new javax.swing.JTextField();
        lblSobrenomePessoas = new javax.swing.JLabel();
        txtSobrenomePessoas = new javax.swing.JTextField();
        btnCadastroPessoas = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setResizable(false);

        lblNomePessoas.setText("Digite o Nome");

        lblSobrenomePessoas.setText("Digite o Sobrenome");

        btnCadastroPessoas.setText("Cadastrar");
        btnCadastroPessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroPessoasActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSobrenomePessoas)
                            .addComponent(txtSobrenomePessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNomePessoas)
                            .addComponent(txtNomePessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCadastroPessoas)))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNomePessoas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomePessoas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSobrenomePessoas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSobrenomePessoas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastroPessoas)
                    .addComponent(btnCancelar))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * Ação do Botão de cadastrar atributos do Pessoas
     *
     * @return
     */
    private void btnCadastroPessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroPessoasActionPerformed
        // TODO add your handling code here:
        Pessoas novaPessoas = new Pessoas();
        PessoasDAO pessoasDao = new PessoasDAO();
        novaPessoas.setNomePessoas(txtNomePessoas.getText());
        novaPessoas.setSobrenomePessoas(txtSobrenomePessoas.getText());
        pessoasDao.create(novaPessoas);

        txtNomePessoas.setText("");
        txtSobrenomePessoas.setText("");
    }//GEN-LAST:event_btnCadastroPessoasActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastroPessoas;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblNomePessoas;
    private javax.swing.JLabel lblSobrenomePessoas;
    private javax.swing.JTextField txtNomePessoas;
    private javax.swing.JTextField txtSobrenomePessoas;
    // End of variables declaration//GEN-END:variables

}