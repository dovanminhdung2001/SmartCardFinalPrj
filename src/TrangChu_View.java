
import model.Licence;
import service.DateUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.Buffer;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

public class TrangChu_View extends javax.swing.JFrame {

    
    private CustomerItem[] ci = new CustomerItem[]{
        new CustomerItem("A1", false),
        new CustomerItem("A2", false),
        new CustomerItem("A3", false),
        new CustomerItem("A4", false),
        new CustomerItem("B1", false),
        new CustomerItem("B2", false),
        new CustomerItem("C", false),
        new CustomerItem("D", false)
    };

    public class CustomerItem {

        public String label;
        public boolean status;

        public CustomerItem(String label, boolean status) {
            this.label = label;
            this.status = status;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    public class RenderCheckComboBox implements ListCellRenderer<CustomerItem> {

        @Override
        public Component getListCellRendererComponent(JList<? extends CustomerItem> list, CustomerItem value, int index,
                boolean isSelected, boolean cellHasFocus) {

            JCheckBox checkBox = new JCheckBox();
            checkBox.setText(value.label);
            checkBox.setSelected(value.status);

            if (isSelected) {
                checkBox.setBackground(Color.GRAY);
            } else {
                checkBox.setBackground(Color.WHITE);
            }
            return checkBox;
        }
    }

    public static String calculateSHA256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes());

            // Convert the byte array to hexadecimal format
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String encryptAES(String plaintext, String key) throws Exception {
        byte[] keyBytes = hexStringToByteArray(key); // Convert hex string to byte array
        SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    public static String decryptAES(String encryptedText, String key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }

    public TrangChu_View() {
        initComponents();
        dobChoser.setDateFormatString("yyyy-MM-dd");
        setLocationRelativeTo(null);
        cbLicense.setPreferredSize(new Dimension(cbLicense.getPreferredSize().width, 50));
        cbLicense.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                CustomerItem item = (CustomerItem) ((JComboBox) ae.getSource()).getSelectedItem();
                item.status = !item.status;
                // update the ui of combo
                cbLicense.updateUI();

                //keep the popMenu of the combo as visible
                cbLicense.setPopupVisible(true);
            }
        });
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
        jPanel2 = new javax.swing.JPanel();
        avtLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbLicense = new javax.swing.JComboBox<>();
        btnAvatar = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtPIN = new javax.swing.JTextField();
        dobChoser = new com.toedter.calendar.JDateChooser();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        menuNapTien = new javax.swing.JMenu();
        menuDoiTT = new javax.swing.JMenu();
        menuDoiPIN = new javax.swing.JMenu();
        menuBlock = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        menuThemLoi = new javax.swing.JMenu();
        menuThanhToan = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(avtLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(avtLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("KHỞI TẠO THẺ");

        txtFullName.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtFullName.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Họ và tên");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Ngày sinh");

        txtID.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtID.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Số CCCD");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Hạng bằng");

        cbLicense.setModel(new DefaultComboBoxModel<> (ci));
        cbLicense.setRenderer(new RenderCheckComboBox());

        btnAvatar.setText("Tải lên");
        btnAvatar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvatarActionPerformed(evt);
            }
        });

        btnCreate.setText("Tạo thẻ");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("PIN");

        txtPIN.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtPIN.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(335, 335, 335))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCreate)
                        .addGap(388, 388, 388))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                                    .addComponent(dobChoser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29)
                            .addComponent(txtPIN, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(cbLicense, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(174, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(btnAvatar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(dobChoser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPIN, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbLicense, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(174, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnAvatar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCreate)
                        .addGap(59, 59, 59))))
        );

        jMenu1.setText("TRANG CHỦ");
        jMenuBar1.add(jMenu1);

        jMenu5.setText("THẺ");

        menuNapTien.setText("Nạp tiền");
        menuNapTien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuNapTienMouseClicked(evt);
            }
        });
        jMenu5.add(menuNapTien);

        menuDoiTT.setText("Thay đổi thông tin");
        menuDoiTT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuDoiTTMouseClicked(evt);
            }
        });
        jMenu5.add(menuDoiTT);

        menuDoiPIN.setText("Thay đổi mã PIN");
        menuDoiPIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuDoiPINMouseClicked(evt);
            }
        });
        jMenu5.add(menuDoiPIN);

        menuBlock.setText("Khóa thẻ");
        menuBlock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuBlockMouseClicked(evt);
            }
        });
        jMenu5.add(menuBlock);

        jMenuBar1.add(jMenu5);

        jMenu7.setText("LỖI VI PHẠM");

        menuThemLoi.setText("Thêm lỗi vi phạm");
        menuThemLoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuThemLoiMouseClicked(evt);
            }
        });
        jMenu7.add(menuThemLoi);

        menuThanhToan.setText("Thanh toán phạt");
        menuThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuThanhToanMouseClicked(evt);
            }
        });
        jMenu7.add(menuThanhToan);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuNapTienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuNapTienMouseClicked
        // TODO add your handling code here:
        new NapTien_View().setVisible(true);
    }//GEN-LAST:event_menuNapTienMouseClicked

    private void menuDoiTTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuDoiTTMouseClicked
        // TODO add your handling code here:
        new ThayDoiThongTin_View().setVisible(true);
    }//GEN-LAST:event_menuDoiTTMouseClicked

    private void menuDoiPINMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuDoiPINMouseClicked
        // TODO add your handling code here:
        new DoiMaPin_View().setVisible(true);
    }//GEN-LAST:event_menuDoiPINMouseClicked

    private void menuBlockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuBlockMouseClicked
        // TODO add your handling code here:
        new KhoaThe_View().setVisible(true);
    }//GEN-LAST:event_menuBlockMouseClicked

    private void menuThemLoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuThemLoiMouseClicked
        // TODO add your handling code here:
        new ThemLoi_View().setVisible(true);
    }//GEN-LAST:event_menuThemLoiMouseClicked

    private void menuThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuThanhToanMouseClicked
        // TODO add your handling code here:
        new ThanhToanTienPhat_View().setVisible(true);
    }//GEN-LAST:event_menuThanhToanMouseClicked

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        ArrayList<Licence> selectedAnLicences = new ArrayList<>();
        String fullName = txtFullName.getText();
        String ID = txtID.getText();
        String PIN = txtPIN.getText();  
        Icon avatar = avtLbl.getIcon();
        Date dob = dobChoser.getDate();

        for (int i = 0; i < ci.length; i++) {
            if(ci[i].status) {
                selectedAnLicences.add(new Licence(ci[i].label));
            }
        }

        if (avatar == null || dob == null || fullName.isEmpty() || ID.isEmpty() || PIN.isEmpty() || selectedAnLicences.size() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống bất kỳ trường nào.");
            return;
        } else if (!ID.matches("\\d{12}")) {
            JOptionPane.showMessageDialog(this, "CCCD bao gồm 12 chữ số.");
            return;
        } else if (!PIN.matches("\\d{6}")) {
            JOptionPane.showMessageDialog(this, "Mã PIN bao gồm 6 chữ số.");
            return;
        }
        String birthDay = DateUtils.sdf.format(dob); 
        String pinHash = calculateSHA256(PIN);

        try {
            String eID = encryptAES(ID, pinHash);
            String eFullName = encryptAES(fullName, pinHash);
            String eBirthday = encryptAES(birthDay, pinHash);
            JOptionPane.showMessageDialog(this, "Mã hóa thành công");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnAvatarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvatarActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String name = selectedFile.getName();
            String formatName = selectedFile.getAbsolutePath().substring(
                    selectedFile.getAbsolutePath().lastIndexOf(".") + 1
            );
            if (
                    "png".equalsIgnoreCase(formatName) ||
                    "jpg".equalsIgnoreCase(formatName) ||
                    "jpeg".equalsIgnoreCase(formatName)
            ) {
                try {
                    Dimension size = avtLbl.getSize();
                    int height = size.height;
                    int width = size.width;
                    Image image = ImageIO.read(new File(selectedFile.getAbsolutePath()));
                    ImageIcon icon = new ImageIcon(image);
                    icon  = new ImageIcon(icon.getImage().getScaledInstance(size.width, size.height, Image.SCALE_SMOOTH));
                    avtLbl.setIcon(icon);
                    avtLbl.setSize(width, height);

                    System.out.println(selectedFile.length());
                    System.out.println(selectedFile.getAbsolutePath());
                    BufferedImage bufferedImage = ImageIO.read(selectedFile);
                    BufferedImage bufferedImageResult = new BufferedImage(
                            width,
                            width,
                            bufferedImage.getType()
                    );
                    Graphics2D g2d = bufferedImageResult.createGraphics();
                    g2d.drawImage(
                            bufferedImage,
                            0,
                            0,
                            width,
                            width,
                            null
                    );
                    g2d.dispose();
                    ImageIO.write(
                            bufferedImageResult,
                            formatName,
                            new File("E:\\demo.jpg")
                    );
                    System.out.println("ok");
                }
                catch (Exception e) {
                    System.out.println(e);
                }

            }
        }
    }//GEN-LAST:event_btnAvatarActionPerformed

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
            java.util.logging.Logger.getLogger(TrangChu_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChu_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChu_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChu_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() { 
                TrangChu_View view = new TrangChu_View(); 
                view.setVisible(true);  
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avtLbl;
    private javax.swing.JButton btnAvatar;
    private javax.swing.JButton btnCreate;
    private javax.swing.JComboBox<CustomerItem> cbLicense;
    private com.toedter.calendar.JDateChooser dobChoser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JMenu menuBlock;
    private javax.swing.JMenu menuDoiPIN;
    private javax.swing.JMenu menuDoiTT;
    private javax.swing.JMenu menuNapTien;
    private javax.swing.JMenu menuThanhToan;
    private javax.swing.JMenu menuThemLoi;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtPIN;
    // End of variables declaration//GEN-END:variables
}
