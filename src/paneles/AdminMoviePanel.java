/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Jahid
 */
public class AdminMoviePanel extends javax.swing.JPanel {

    /**
     * Creates new form AdminMoviePanel
     */
    public AdminMoviePanel() {
        initComponents();
        DefaultTableModel model = (DefaultTableModel)MovieTable.getModel();
        model.setRowCount(0);  
        show_movie();
    }
    
    public ArrayList<UserMoviePanels> movieList(){
        ArrayList<UserMoviePanels> moviesList = new ArrayList<>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager
            .getConnection(
            "jdbc:sqlserver://localhost:1433;databaseName=CineplexManagementSystem;selectMethod=cursor", "sa", "123456");


            String sql = "Select * from MOVIE";  
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            UserMoviePanels movies;
            while(rs.next()){
                movies = new UserMoviePanels(rs.getInt("MovieId"),rs.getString("MovieName"),rs.getString("Director"),rs.getString("CastName"),rs.getString("Details"),rs.getString("Rating"),rs.getBytes("Picture")); 
                moviesList.add(movies);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return moviesList;
    }
    
    public void show_movie(){
        ArrayList<UserMoviePanels> list = movieList();
        DefaultTableModel model = (DefaultTableModel)MovieTable.getModel();
        Object[] row = new Object[6];
        for(int i = 0; i < list.size(); i++){
            row[0] = list.get(i).getMovieId();
            row[1] = list.get(i).getMovieName();
            row[2] = list.get(i).getDirector();
            row[3] = list.get(i).getDetails();
            row[4] = list.get(i).getCastName();
            row[5] = list.get(i).getRating();
            model.addRow(row); 
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

        jPanel2 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        MovieTable = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setLayout(null);

        jPanel2.setBackground(new java.awt.Color(82, 82, 82));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator3.setToolTipText("");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Movies:");

        jButton2.setBackground(new java.awt.Color(153, 255, 153));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("Refresh");
        jButton2.setContentAreaFilled(false);
        jButton2.setOpaque(true);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(153, 255, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Add Movie");
        jButton1.setContentAreaFilled(false);
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        MovieTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        MovieTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Movie Id", "Movie Name", "Director", "Details", "Production", "Rating"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        MovieTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MovieTable.setRowHeight(26);
        jScrollPane1.setViewportView(MovieTable);

        jButton3.setBackground(new java.awt.Color(153, 255, 153));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("Movie Details");
        jButton3.setContentAreaFilled(false);
        jButton3.setOpaque(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(153, 255, 153));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setText("Update Movie");
        jButton4.setContentAreaFilled(false);
        jButton4.setOpaque(true);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(153, 255, 153));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setText("Delete Movie");
        jButton5.setContentAreaFilled(false);
        jButton5.setOpaque(true);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButton1)
                        .addGap(41, 41, 41)
                        .addComponent(jButton2)
                        .addGap(40, 40, 40)
                        .addComponent(jButton3)
                        .addGap(71, 71, 71)
                        .addComponent(jButton4)
                        .addGap(70, 70, 70)
                        .addComponent(jButton5)))
                .addContainerGap(170, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(346, 346, 346))
        );

        add(jPanel2);
        jPanel2.setBounds(-5, -2, 1110, 840);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int opt = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Delete", JOptionPane.YES_NO_OPTION);
        if(opt == 0){
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection connection = DriverManager
                .getConnection(
                "jdbc:sqlserver://localhost:1433;databaseName=CineplexManagementSystem;selectMethod=cursor", "sa", "123456");

                int i = MovieTable.getSelectedRow();
                TableModel model = MovieTable.getModel();
                String movieId = model.getValueAt(i, 0).toString();

                String sql = "Delete From MOVIE where MovieId="+movieId; 
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.executeUpdate();
                DefaultTableModel Model = (DefaultTableModel)MovieTable.getModel();
                Model.setRowCount(0);  
                show_movie();
                JOptionPane.showMessageDialog(null, "Deleted Successfully!");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new AddMovieDetails().setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int i = MovieTable.getSelectedRow();
        TableModel model = MovieTable.getModel();
        String movieId = model.getValueAt(i, 0).toString();
        String movieName = model.getValueAt(i, 1).toString();
        String director = model.getValueAt(i, 2).toString();
        String cast = model.getValueAt(i, 3).toString();
        String details = model.getValueAt(i, 4).toString();
        String rating = model.getValueAt(i, 5).toString();
        
        byte[] img = (movieList().get(i).getPicture());
        new AdminMovieUpdate(movieId,movieName,director,cast,details,rating,img).setVisible(true); 
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DefaultTableModel model = (DefaultTableModel)MovieTable.getModel();
        model.setRowCount(0);  
        show_movie();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int i = MovieTable.getSelectedRow();
        TableModel model = MovieTable.getModel();
        String movieId = model.getValueAt(i, 0).toString();
        String movieName = model.getValueAt(i, 1).toString();
        String director = model.getValueAt(i, 2).toString();
        String cast = model.getValueAt(i, 3).toString();
        String details = model.getValueAt(i, 4).toString();
        String rating = model.getValueAt(i, 5).toString();
        byte[] img = (movieList().get(i).getPicture());
        new MovieDetails(movieId,movieName,director,cast,details,rating,img).setVisible(true); 
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable MovieTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
