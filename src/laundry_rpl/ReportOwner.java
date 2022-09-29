/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundry_rpl;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author asus
 */
public class ReportOwner extends javax.swing.JFrame {
private Connection conn;
    private Statement st;
    private ResultSet rs;
    private String sql="";
    public ReportOwner() throws SQLException {
        initComponents();
        this.conn = new koneksi().getkoneksi();
        datatable();
        datatable2();
        datatable3();
        totalSales();
        totalPengeluaran();
        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();

        // membuat titik x dan y
        int x = layar.width / 2  - this.getSize().width / 2;
        int y = layar.height / 2 - this.getSize().height / 2;
        this.setLocation(x, y);
    }
    private void datatable(){
        DefaultTableModel data = new DefaultTableModel();
        data.addColumn ("Jam");
        data.addColumn ("Kode Transaksi");
        data.addColumn ("ID Pelanggan");
        data.addColumn ("Nama");
        data.addColumn ("Paket");
        data.addColumn ("Berat");
        data.addColumn ("Total");
        try{    

            st=conn.createStatement();
            rs=st.executeQuery("select jam,kd_transaksi,id_pelanggan,nama,paket,berat,total from transaksi where pembayaran = 'Lunas' ");
            while (rs.next())
                data.addRow(new Object[]{

                    rs.getString(1), rs.getString(2),
                    rs.getString(3), rs.getString(4),
                    rs.getString(5), rs.getString(6),
                    rs.getString(7),
                });
            TbSales.setModel(data);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR \n Gagal Memuat KeDatabase"+e.getMessage());
        }
    }
    private void totalSales(){
        try{
            st= conn.createStatement();
            rs = st.executeQuery("SELECT  sum(total)as total_sales  FROM transaksi where pembayaran = 'Lunas' ");
            while(rs.next()){
                lblSales.setText(rs.getString("total_sales"));
//                txtSales.setText(rs.getString("total_sales"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR"+e.getMessage());
        }
    }private void totalPengeluaran(){
        try{
            st= conn.createStatement();
            rs = st.executeQuery("SELECT  sum(total)as total_pengeluaran  FROM pengeluaran ");
            while(rs.next()){
                lblPengeluaran.setText(rs.getString("total_pengeluaran"));
//                txtSales.setText(rs.getString("total_sales"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR"+e.getMessage());
        }
    }
    
    private void datatable2(){
        DefaultTableModel data = new DefaultTableModel();
        data.addColumn ("Tanggal");
        data.addColumn ("Nama Barang");
        data.addColumn ("Harga");
        data.addColumn ("Total");
        try{    

            st=conn.createStatement();
            rs=st.executeQuery("select tgl,nama_barang,harga,total from pengeluaran");
            while (rs.next())
                data.addRow(new Object[]{

                    rs.getString(1), rs.getString(2),
                    rs.getString(3), rs.getString(4),
                });
            TbPengeluaran.setModel(data);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR \n Gagal Memuat KeDatabase \n Aktifkan Database Sebelum Memulai");
        }
    }private void datatable3(){
        DefaultTableModel data = new DefaultTableModel();
        data.addColumn ("ID Pelanggan");
        data.addColumn ("Nama");
        data.addColumn ("Jenis Kelamin");
        data.addColumn ("Alamat");
        data.addColumn ("No. Hp");
        try{    

            st=conn.createStatement();
            rs=st.executeQuery("select * from pelanggan");
            while (rs.next())
                data.addRow(new Object[]{

                    rs.getString(1), rs.getString(2),
                    rs.getString(3), rs.getString(4),
                    rs.getString(5),
                });
            TblPelanggan.setModel(data);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "ERROR \n Gagal Memuat KeDatabase \n Aktifkan Database Sebelum Memulai");
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnprint = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbSales = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbPengeluaran = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TblPelanggan = new javax.swing.JTable();
        lblPengeluaran = new javax.swing.JLabel();
        lblProfit = new javax.swing.JLabel();
        lblSales = new javax.swing.JLabel();
        lblDefisit = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        Dashboard = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        UpdateAdmin = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        Report = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        Paket = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        LogOut = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblSales2 = new javax.swing.JLabel();
        lblSales3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel5.setText("Total Pemasukan");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 560, 150, 40));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel6.setText("Total Pengeluaran");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 560, 150, 40));

        btnprint.setBackground(new java.awt.Color(85, 65, 118));
        btnprint.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        btnprint.setForeground(new java.awt.Color(255, 255, 255));
        btnprint.setText("Print");
        btnprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprintActionPerformed(evt);
            }
        });
        jPanel1.add(btnprint, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 710, 120, 40));

        jTabbedPane1.setBackground(new java.awt.Color(255, 206, 220));
        jTabbedPane1.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N

        TbSales.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TbSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Tanggal", "Kode Transaksi", "ID Pelanggan", "Nama Pelangggan", "Paket", "Berat", "Total"
            }
        ));
        TbSales.setGridColor(new java.awt.Color(255, 255, 255));
        TbSales.setRowHeight(30);
        TbSales.setShowHorizontalLines(false);
        jScrollPane2.setViewportView(TbSales);

        jTabbedPane1.addTab("Pemasukan", jScrollPane2);

        TbPengeluaran.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TbPengeluaran.setModel(new javax.swing.table.DefaultTableModel(
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
                "Tanggal", "Nama Barang", "Total"
            }
        ));
        TbPengeluaran.setGridColor(new java.awt.Color(255, 255, 255));
        TbPengeluaran.setRowHeight(30);
        TbPengeluaran.setShowHorizontalLines(false);
        jScrollPane1.setViewportView(TbPengeluaran);

        jTabbedPane1.addTab("Pengeluaran", jScrollPane1);

        TblPelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Pelanggan", "Nama ", "Jenis Kelamin", "Alamat", "No. Hp"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TblPelanggan.setGridColor(new java.awt.Color(255, 255, 255));
        TblPelanggan.setRowHeight(30);
        TblPelanggan.setSelectionBackground(new java.awt.Color(153, 153, 255));
        TblPelanggan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblPelangganMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TblPelanggan);

        jTabbedPane1.addTab("Pelanggan", jScrollPane3);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 970, 480));

        lblPengeluaran.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanel1.add(lblPengeluaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 560, 110, 40));

        lblProfit.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanel1.add(lblProfit, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 560, 110, 40));

        lblSales.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanel1.add(lblSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 560, 110, 40));

        lblDefisit.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jPanel1.add(lblDefisit, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 610, 110, 40));

        jPanel4.setBackground(new java.awt.Color(54, 33, 89));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N
        jLabel1.setText("jLabel1");

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

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dashboard.png"))); // NOI18N
        jLabel8.setText("jLabel2");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jPanel7.setBackground(new java.awt.Color(85, 65, 118));

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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 88, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Report, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(Report, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UpdateAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(7, 7, 7))))
        );

        jPanel13.setBackground(new java.awt.Color(54, 33, 89));

        Paket.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        Paket.setForeground(new java.awt.Color(255, 255, 255));
        Paket.setText("Paket");
        Paket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PaketMouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kelola paket.png"))); // NOI18N
        jLabel3.setText("jLabel3");

        LogOut.setFont(new java.awt.Font("Yu Gothic UI", 1, 24)); // NOI18N
        LogOut.setForeground(new java.awt.Color(255, 255, 255));
        LogOut.setText("Log Out");
        LogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogOutMouseClicked(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logout.png"))); // NOI18N
        jLabel15.setText("jLabel10");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Paket, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(Paket, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LogOut)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(416, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 810));

        lblSales2.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblSales2.setText("Rp.");
        jPanel1.add(lblSales2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 560, 40, 40));

        lblSales3.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        lblSales3.setText("Rp.");
        jPanel1.add(lblSales3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 560, 40, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1360, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprintActionPerformed
        if(JOptionPane.showConfirmDialog(null,"Cetak Pemasukan ","U-Laundry", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
           try{
                            HashMap parameter = new HashMap();
                            File file = new File ("src/Report/reportPemasukan.jasper");
                            JasperReport jr = (JasperReport) JRLoader.loadObject(file);
                            JasperPrint jp = JasperFillManager.fillReport(jr, parameter, conn);
                            JasperViewer.viewReport(jp, false);
                            JasperViewer.setDefaultLookAndFeelDecorated(true);
                        } catch (Exception e){
                            javax.swing.JOptionPane.showMessageDialog(null,
                            "Data Tidak Dapat di Cetak !!!" + "\n" + e.getMessage(), 
                            "Cetak Data", javax.swing.JOptionPane.ERROR_MESSAGE);
                        } 
        }else{
            if(JOptionPane.showConfirmDialog(null,"Cetak Pengeluaran ","U-Laundry", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION){
            try{
                            HashMap parameter = new HashMap();
                            File file = new File ("src/Report/reportPengeluaran.jasper");
                            JasperReport jr = (JasperReport) JRLoader.loadObject(file);
                            JasperPrint jp = JasperFillManager.fillReport(jr, parameter, conn);
                            JasperViewer.viewReport(jp, false);
                            JasperViewer.setDefaultLookAndFeelDecorated(true);
                        } catch (Exception e){
                            javax.swing.JOptionPane.showMessageDialog(null,
                            "Data Tidak Dapat di Cetak !!!" + "\n" + e.getMessage(), 
                            "Cetak Data", javax.swing.JOptionPane.ERROR_MESSAGE);
                        } 
        }
        }
    }//GEN-LAST:event_btnprintActionPerformed

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
        this.dispose();
        DashboardOwner p = null;
        try {
            p = new DashboardOwner();
        } catch (SQLException ex) {
            Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        p.setVisible(true);
    }//GEN-LAST:event_DashboardMouseClicked

    private void DashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMouseEntered

    }//GEN-LAST:event_DashboardMouseEntered

    private void UpdateAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateAdminMouseClicked
        this.dispose();
        KelolaAdmin p = null;
        try {
            p = new KelolaAdmin();
        } catch (SQLException ex) {
            Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        p.setVisible(true);
    }//GEN-LAST:event_UpdateAdminMouseClicked

    private void ReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportMouseClicked
        
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

    private void TblPelangganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblPelangganMouseClicked
        
    }//GEN-LAST:event_TblPelangganMouseClicked

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
            java.util.logging.Logger.getLogger(ReportOwner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportOwner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportOwner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportOwner.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ReportOwner().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ReportOwner.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Dashboard;
    private javax.swing.JLabel LogOut;
    private javax.swing.JLabel Paket;
    private javax.swing.JLabel Report;
    private javax.swing.JTable TbPengeluaran;
    private javax.swing.JTable TbSales;
    private javax.swing.JTable TblPelanggan;
    private javax.swing.JLabel UpdateAdmin;
    private javax.swing.JButton btnprint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblDefisit;
    private javax.swing.JLabel lblPengeluaran;
    private javax.swing.JLabel lblProfit;
    private javax.swing.JLabel lblSales;
    private javax.swing.JLabel lblSales2;
    private javax.swing.JLabel lblSales3;
    // End of variables declaration//GEN-END:variables
}
