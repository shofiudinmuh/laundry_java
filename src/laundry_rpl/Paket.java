/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundry_rpl;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.*;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;

/**
 *
 * @author asus
 */
public class Paket extends javax.swing.JFrame {
    private DefaultTableModel tabmode;
    private Connection conn;


    /**
     * Creates new form Paket
     */
    public Paket() throws SQLException {
        initComponents();
        this.conn = new koneksi().getkoneksi();
        aktif();
        clear();
        dataTable();
        autonumber();

        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();

        // membuat titik x dan y
        int x = layar.width / 2  - this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;
        this.setLocation(x, y);
    }
    protected void autonumber(){
        try{
            String sql = "SELECT kd_paket FROM paket_laundry order by kd_paket asc";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            kd_paket.setText("PL0001");
            while(rs.next()){
                String kd = rs.getString("kd_paket").substring(2);
                int AN = Integer.parseInt(kd)+1;
                String Nol = "";
                
                if (AN < 10){
                    Nol = "000";
                }
                else if (AN < 100){
                    Nol = "00";
                }
                else if (AN < 1000){
                    Nol = "0";
                }
                else if (AN < 10000){
                    Nol = "";
                }
                kd_paket.setText("PL"+Nol+AN);
            }
        }
            catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Auto number gagal"+e);
            }
    }
    protected void aktif(){
        kd_paket.requestFocus();
        }
    protected void dataTable(){
        Object[] Baris = {"Kode Paket","Nama Paket","Harga"};
        tabmode = new DefaultTableModel(null, Baris);
        String cariitem = txtcari.getText();

        try {
            String sql = "SELECT * FROM paket_laundry where kd_paket like '%"+cariitem+"%' or nama_paket  order by kd_paket asc";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()){
                tabmode.addRow(new Object[]{
                hasil.getString(1),
                hasil.getString(2),
                hasil.getString(3),               
                });
            }
        TblPaket.setModel(tabmode);
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,"data gagal dipanggil"+e);
        }
    }
    void clear(){
        kd_paket.setText("");
        nama_paket.setText("");
        harga.setText("");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TblPaket = new javax.swing.JTable();
        btn_edit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        kd_paket = new javax.swing.JTextField();
        nama_paket = new javax.swing.JTextField();
        harga = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        txtcari = new javax.swing.JTextField();
        btn_delete1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        LogOut = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        Dashboard = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        UpdateAdmin = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Report = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        Paket = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TblPaket.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TblPaket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Kode Paket", "Nama Paket", "Harga"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TblPaket.setGridColor(new java.awt.Color(255, 255, 255));
        TblPaket.setRowHeight(30);
        TblPaket.setShowHorizontalLines(false);
        TblPaket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblPaketMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblPaket);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 930, 340));

        btn_edit.setBackground(new java.awt.Color(85, 65, 118));
        btn_edit.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btn_edit.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        jPanel1.add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 670, 120, 40));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel4.setText("Harga");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 550, 220, 40));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel5.setText("Kode Paket");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 430, 220, 40));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel6.setText("Nama Paket");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 490, 220, 40));

        kd_paket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kd_paketActionPerformed(evt);
            }
        });
        jPanel1.add(kd_paket, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 430, 340, 40));

        nama_paket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_paketActionPerformed(evt);
            }
        });
        jPanel1.add(nama_paket, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 490, 340, 40));

        harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hargaActionPerformed(evt);
            }
        });
        jPanel1.add(harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 550, 340, 40));

        save.setBackground(new java.awt.Color(85, 65, 118));
        save.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel1.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 670, 120, 40));

        btn_clear.setBackground(new java.awt.Color(85, 65, 118));
        btn_clear.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btn_clear.setForeground(new java.awt.Color(255, 255, 255));
        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });
        jPanel1.add(btn_clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 670, 120, 40));

        txtcari.setBorder(null);
        txtcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcariActionPerformed(evt);
            }
        });
        jPanel1.add(txtcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 100, 300, 30));

        btn_delete1.setBackground(new java.awt.Color(85, 65, 118));
        btn_delete1.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        btn_delete1.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete1.setText("Delete");
        btn_delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delete1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_delete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 670, 120, 40));

        jPanel2.setBackground(new java.awt.Color(54, 33, 89));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        LogOut.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        LogOut.setForeground(new java.awt.Color(255, 255, 255));
        LogOut.setText("Log Out");
        LogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogOutMouseClicked(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(54, 33, 89));

        Dashboard.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        Dashboard.setForeground(new java.awt.Color(255, 255, 255));
        Dashboard.setText("Dashboard");
        Dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMouseEntered(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dashboard.png"))); // NOI18N
        jLabel3.setText("jLabel2");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(5, 5, 5))
                    .addComponent(Dashboard, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18))
        );

        jPanel10.setBackground(new java.awt.Color(54, 33, 89));

        UpdateAdmin.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        UpdateAdmin.setForeground(new java.awt.Color(255, 255, 255));
        UpdateAdmin.setText("Kelola Admin");
        UpdateAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateAdminMouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kelola user.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UpdateAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UpdateAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );

        Report.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        Report.setForeground(new java.awt.Color(255, 255, 255));
        Report.setText("Report");
        Report.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReportMouseClicked(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/report.png"))); // NOI18N
        jLabel14.setText("jLabel9");

        jPanel13.setBackground(new java.awt.Color(85, 65, 118));

        Paket.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        Paket.setForeground(new java.awt.Color(255, 255, 255));
        Paket.setText("Paket");
        Paket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PaketMouseClicked(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kelola paket.png"))); // NOI18N
        jLabel7.setText("jLabel3");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Paket, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Paket, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel7)
        );

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logout.png"))); // NOI18N
        jLabel15.setText("jLabel10");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Report, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Report, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LogOut)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(445, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 810));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1359, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kd_paketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kd_paketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kd_paketActionPerformed

    private void nama_paketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_paketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_paketActionPerformed

    private void hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hargaActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        if(JOptionPane.showConfirmDialog(null,"Ubah Data Paket","U-Laundry", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            String nama = nama_paket.getText();
            try{
            if(nama.isEmpty()){
                JOptionPane.showMessageDialog(null,"Data belum dipilih ");
            }else{
        String sql = "update paket_laundry set kd_paket=?,nama_paket=?,harga=? where kd_paket ='"
                       +kd_paket.getText()+"'";
        
               try {
                        PreparedStatement stat = conn.prepareStatement(sql);
                        stat.setString(1,kd_paket.getText());
                        stat.setString(2,nama_paket.getText());
                        stat.setString(3,harga.getText());
                        stat.executeUpdate();
                        JOptionPane.showMessageDialog(null, "data berhasil disimpan");
                        clear();
                   }
               catch (SQLException e){
                        JOptionPane.showMessageDialog(null, "data gagal disimpan" +e);
                   }
               dataTable();
               autonumber();
            }
            }catch(Exception e){
            
            }
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        String nama= nama_paket.getText();
        String hrg = harga.getText();

        try{
            if(nama.isEmpty()){
                JOptionPane.showMessageDialog(null,"Masukkan nama paket");
            }if(hrg.isEmpty()){
                JOptionPane.showMessageDialog(null,"Masukkan harga paket");
            }
        }catch(Exception e){
            
        }
        
               try {
                   String sql = "insert paket_laundry values (?,?,?)";
                        PreparedStatement stat = conn.prepareStatement(sql);
//                        autonumber();
                        stat.setString(1,kd_paket.getText());
                        stat.setString(2,nama_paket.getText());
                        stat.setString(3,harga.getText());
                        stat.executeUpdate();
                        JOptionPane.showMessageDialog(null, "data berhasil disimpan");
                        clear();
                   }
               catch (SQLException e){
                        JOptionPane.showMessageDialog(null, "data gagal disimpan"+e.getMessage());
                   }
               dataTable();
               autonumber();
    }//GEN-LAST:event_saveActionPerformed

    private void txtcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcariActionPerformed

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
           clear();        // TODO add your handling code here:
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delete1ActionPerformed
        if(JOptionPane.showConfirmDialog(null,"Ubah Data Paket","U-Laundry", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            String nama = nama_paket.getText();
            try{
            if(nama.isEmpty()){
                JOptionPane.showMessageDialog(null,"Data belum dipilih ");
            }else{
        String sql = "delete from paket_laundry where nama_paket = '"+nama_paket.getText()+"'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "data berhasil dihapus");
                clear();
            }
            catch (SQLException e){
                JOptionPane.showMessageDialog(null, "data gagal dihapus" +e);
            }
            dataTable();
            }
            }catch(Exception e){
            
            }
            autonumber();
        }
    }//GEN-LAST:event_btn_delete1ActionPerformed

    private void LogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutMouseClicked
        if(JOptionPane.showConfirmDialog(null,"Log Out","U-Laundry", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
        this.dispose();
        loginOwner p = null;
        try {
            p = new loginOwner();
        } catch (SQLException ex) {
            Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        p.setVisible(true);
        }
    }//GEN-LAST:event_LogOutMouseClicked

    private void DashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMouseClicked
        
        DashboardOwner p = null;
        try {
            p = new DashboardOwner();
        } catch (SQLException ex) {
            Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_DashboardMouseClicked

    private void DashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMouseEntered

    }//GEN-LAST:event_DashboardMouseEntered

    private void UpdateAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateAdminMouseClicked
        KelolaAdmin p = null;
        try {
            p = new KelolaAdmin();
        } catch (SQLException ex) {
            Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_UpdateAdminMouseClicked

    private void ReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportMouseClicked
       ReportOwner p = null;
        try {
            p = new ReportOwner();
        } catch (SQLException ex) {
            Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ReportMouseClicked

    private void PaketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PaketMouseClicked
        this.dispose();
        Paket p = null;
        try {
            p = new Paket();
        } catch (SQLException ex) {
            Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        p.setVisible(true);
    }//GEN-LAST:event_PaketMouseClicked

    private void TblPaketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblPaketMouseClicked
         int row = TblPaket.getSelectedRow();
        kd_paket.setText(TblPaket.getModel().getValueAt(row, 0).toString());
        nama_paket.setText(TblPaket.getModel().getValueAt(row, 1).toString());
        harga.setText(TblPaket.getModel().getValueAt(row, 2).toString());
    }//GEN-LAST:event_TblPaketMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Paket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Paket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Paket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Paket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Paket().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Paket.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Dashboard;
    private javax.swing.JLabel LogOut;
    private javax.swing.JLabel Paket;
    private javax.swing.JLabel Report;
    private javax.swing.JTable TblPaket;
    private javax.swing.JLabel UpdateAdmin;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_delete1;
    private javax.swing.JButton btn_edit;
    private javax.swing.JTextField harga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kd_paket;
    private javax.swing.JTextField nama_paket;
    private javax.swing.JButton save;
    private javax.swing.JTextField txtcari;
    // End of variables declaration//GEN-END:variables
}
