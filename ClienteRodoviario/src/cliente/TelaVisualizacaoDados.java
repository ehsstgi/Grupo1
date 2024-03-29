package cliente;

public class TelaVisualizacaoDados extends javax.swing.JFrame {

    /**
     * Creates new form TelaVisualizacaoDados
     */
    public TelaVisualizacaoDados() {
        initComponents();
        setVisible(true);
    }

    public TelaVisualizacaoDados(String poltrona, String linha, String origem, String destino, String data, String horario, String nome, String documento, String valor) {
        initComponents();
        lblPoltronaVl.setText(poltrona);
        lblLinhaVl.setText(linha);
        lblViagemVl.setText(origem + " -> " + destino);
        lblDataVl.setText(data);
        lblHorarioVl.setText(horario);
        lblPassageiroVl.setText(nome);
        lblDocumentoVl.setText(documento);
        lblValorVl.setText("R$ " + valor);
        setVisible(true);
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
        lblValor = new javax.swing.JLabel();
        lblValorVl = new javax.swing.JLabel();
        lblHorario = new javax.swing.JLabel();
        lblHorarioVl = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblLinha = new javax.swing.JLabel();
        lblPoltrona = new javax.swing.JLabel();
        lblPoltronaVl = new javax.swing.JLabel();
        lblLinhaVl = new javax.swing.JLabel();
        lblDataVl = new javax.swing.JLabel();
        btnOK = new javax.swing.JButton();
        lblPassageiro = new javax.swing.JLabel();
        lblPassageiroVl = new javax.swing.JLabel();
        lblDocumento = new javax.swing.JLabel();
        lblDocumentoVl = new javax.swing.JLabel();
        lblViagem = new javax.swing.JLabel();
        lblViagemVl = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        javax.swing.JMenu btnArquivo = new javax.swing.JMenu();
        btnLogin = new javax.swing.JRadioButtonMenuItem();
        btnSair = new javax.swing.JRadioButtonMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem3 = new javax.swing.JRadioButtonMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Visualização dos Dados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        lblValor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblValor.setText("Valor:");

        lblHorario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblHorario.setText("Horário:");

        lblData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblData.setText("Data:");

        lblLinha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblLinha.setText("Linha:");

        lblPoltrona.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPoltrona.setText("Poltrona:");

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        lblPassageiro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPassageiro.setText("Passageiro:");

        lblDocumento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDocumento.setText("Documento:");

        lblViagem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblViagem.setText("Viagem:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(lblValor)
                                .addGap(29, 29, 29)
                                .addComponent(lblValorVl, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblHorario)
                                .addGap(18, 18, 18)
                                .addComponent(lblHorarioVl, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPoltrona)
                                    .addComponent(lblData)
                                    .addComponent(lblLinha))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblLinhaVl, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPoltronaVl, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDataVl, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblDocumento)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblDocumentoVl, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(lblPassageiro)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblPassageiroVl, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblViagem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblViagemVl, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(318, 318, 318)
                        .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPoltrona)
                    .addComponent(lblPoltronaVl, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLinha)
                    .addComponent(lblLinhaVl, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblViagem)
                    .addComponent(lblViagemVl, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblData)
                    .addComponent(lblDataVl, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHorario)
                    .addComponent(lblHorarioVl, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPassageiroVl, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassageiro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDocumento)
                    .addComponent(lblDocumentoVl, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValorVl, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValor))
                .addGap(44, 44, 44)
                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnArquivo.setText("Administrator");

        btnLogin.setSelected(true);
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        btnArquivo.add(btnLogin);

        btnSair.setSelected(true);
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        btnArquivo.add(btnSair);

        jMenuBar1.add(btnArquivo);

        jMenu3.setText("Compras");

        jRadioButtonMenuItem2.setSelected(true);
        jRadioButtonMenuItem2.setText("Comprar Passagem");
        jRadioButtonMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jRadioButtonMenuItem2);

        jRadioButtonMenuItem3.setSelected(true);
        jRadioButtonMenuItem3.setText("Retirar Passagem");
        jRadioButtonMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jRadioButtonMenuItem3);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Sobre");
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu4ActionPerformed(evt);
            }
        });

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("Integrantes");
        jRadioButtonMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jRadioButtonMenuItem1);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        TelaInicial inicial = new TelaInicial();
        inicial.setLocationRelativeTo(null);
        inicial.setVisible(true);

        frmMenu tamanho = new frmMenu();
        tamanho.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void jRadioButtonMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem2ActionPerformed
        TelaCompra compra = new TelaCompra();
        compra.setLocationRelativeTo(null);
        compra.setVisible(true);
    }//GEN-LAST:event_jRadioButtonMenuItem2ActionPerformed

    private void jRadioButtonMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem3ActionPerformed
        TelaRetiraPassagem retira = new TelaRetiraPassagem();
        retira.setLocationRelativeTo(null);
        retira.setVisible(true);
    }//GEN-LAST:event_jRadioButtonMenuItem3ActionPerformed

    private void jRadioButtonMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem1ActionPerformed
        Integrantes integrantes = new Integrantes();
        integrantes.setLocationRelativeTo(null);
        integrantes.setVisible(true);
    }//GEN-LAST:event_jRadioButtonMenuItem1ActionPerformed

    private void jMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu4ActionPerformed
   }//GEN-LAST:event_jMenu4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TelaVisualizacaoDados().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButtonMenuItem btnLogin;
    private javax.swing.JButton btnOK;
    private javax.swing.JRadioButtonMenuItem btnSair;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem3;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblDataVl;
    private javax.swing.JLabel lblDocumento;
    private javax.swing.JLabel lblDocumentoVl;
    private javax.swing.JLabel lblHorario;
    private javax.swing.JLabel lblHorarioVl;
    private javax.swing.JLabel lblLinha;
    private javax.swing.JLabel lblLinhaVl;
    private javax.swing.JLabel lblPassageiro;
    private javax.swing.JLabel lblPassageiroVl;
    private javax.swing.JLabel lblPoltrona;
    private javax.swing.JLabel lblPoltronaVl;
    private javax.swing.JLabel lblValor;
    private javax.swing.JLabel lblValorVl;
    private javax.swing.JLabel lblViagem;
    private javax.swing.JLabel lblViagemVl;
    // End of variables declaration//GEN-END:variables
}
