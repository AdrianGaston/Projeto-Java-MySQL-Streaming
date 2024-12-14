package br.com.senac.cenaflixjpa.gui;

import br.com.senac.cenaflixjpa.Usuario;
import br.com.senac.cenaflixjpa.persistencia.Podcast;
import br.com.senac.cenaflixjpa.persistencia.PodcastDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Listagem extends javax.swing.JFrame {
    private Usuario usuario;
    
    public Listagem(JTable tblPodcast, Usuario usuario) {
        this.tblPodcast = tblPodcast;
        this.usuario = usuario;
        initComponents();
        carregarLista();
        permissoes();
    } 
    
    //Método para configurar as permissões dos usuários
    private void permissoes(){
        if (usuario.getTipo().equalsIgnoreCase("Operador")) {
            btnExcluir.setEnabled(false);
        } else if (usuario.getTipo().equalsIgnoreCase("Usuário")) {
            btnCadastro.setEnabled(false);
            btnExcluir.setEnabled(false);
        }
    }
    
    //Método para carregar a lista
    private void carregarLista(){
        PodcastDAO pd = new PodcastDAO();
        List<Podcast> podcasts = pd.listar();
        if (podcasts.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum podcast encontrado!");
        } else {
            preencherTabela(podcasts);
        }
    }
    //Método para preencher a tabela
    public void preencherTabela(List<Podcast> podcasts){
        String colunas[] = {"Id", "Produtor", "Nome do episódio", "Número Episódio", "Duração", "URL"};
        String dados[][] = new String[podcasts.size()][colunas.length];
        
        int i = 0;
        for(Podcast p: podcasts){
            dados[i] = new String[]{
                String.valueOf(p.getId()),
                p.getProdutor(),
                p.getNomeEpisodio(),
                String.valueOf(p.getNumeroEpisodio()),
                p.getDuracao(),
                p.getUrl()
            };
            i++;
        }
        DefaultTableModel model = new DefaultTableModel(dados, colunas);
        tblPodcast.setModel(model);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPodcast = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        btnCadastro = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LISTAGEM");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("CENAFLIX");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("LISTAGEM");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Pesquisar podcast por produtor:");

        txtPesquisar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblPodcast.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Produtor", "Nome Episódio", "Nº Episódio", "Duração", "URL do Repo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPodcast);

        btnExcluir.setBackground(new java.awt.Color(153, 153, 153));
        btnExcluir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 0, 0));
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnCadastro.setBackground(new java.awt.Color(153, 153, 153));
        btnCadastro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCadastro.setText("Cadastrar");
        btnCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroActionPerformed(evt);
            }
        });

        btnPesquisar.setBackground(new java.awt.Color(204, 204, 204));
        btnPesquisar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162)
                .addComponent(btnCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir)
                    .addComponent(btnCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSair))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroActionPerformed
        dispose();
        Cadastrar telaCadastro = new Cadastrar(tblPodcast, usuario);
        telaCadastro.setVisible(true);
    }//GEN-LAST:event_btnCadastroActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try{
            if (tblPodcast.getSelectedRow() >= 0) { 
                String produtor = (String)tblPodcast.getValueAt(tblPodcast.getSelectedRow(), 1);
                
                int resposta = JOptionPane.showConfirmDialog(this, "Deseja mesmo excluir o registro do produtor '" + produtor + "'?", "EXCLUIR?", JOptionPane.YES_NO_OPTION);
                
                if(resposta == 0){
                    PodcastDAO podcastDao = new PodcastDAO();
                    podcastDao.excluir(produtor);
                    JOptionPane.showMessageDialog(rootPane, "Registro excluido com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                    carregarLista();
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Atenção, selecione para excluir!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Ocorreu uma falha:\n" + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        if (txtPesquisar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Atenção, informe um produtor para pesquisar!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {
            String produtor = txtPesquisar.getText().trim();
            PodcastDAO pd = new PodcastDAO();
            List<Podcast> podcasts = pd.pesquisar(produtor);
            
            if (podcasts.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Nenhum podcast encontrado com esse produtor!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            } else {
                preencherTabela(podcasts);
            }
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JTable tblPodcast = new JTable();
                Usuario usuario = new Usuario();
                new Listagem(tblPodcast, usuario).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastro;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPodcast;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}
