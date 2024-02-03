
package chanchan.webcam;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.github.sarxos.webcam.Webcam;





public class WebCamApp extends javax.swing.JFrame {
	
	private int imageCounter = 1;
	private JLabel imageLabel; // Declare imageLabel at the class level
	 private Webcam webcam;

	public WebCamApp() {
		initComponents();
		webcam = Webcam.getDefault();
		webcam.setViewSize(new Dimension(640, 480));
		webcam.open();
		startWebcamFeed();
	}


	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jPanel2 = new javax.swing.JPanel();
                exitbtn = new javax.swing.JButton();
                video = new javax.swing.JLabel();
                capturebtn = new javax.swing.JButton();
                browsebtn = new javax.swing.JButton();
                panel1 = new java.awt.Panel();
                jLabel1 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jPanel1.setBackground(new java.awt.Color(255, 255, 204));
                jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jPanel2.setBackground(new java.awt.Color(153, 255, 153));
                jPanel2.setForeground(new java.awt.Color(255, 255, 255));
                jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                exitbtn.setBackground(new java.awt.Color(255, 153, 153));
                exitbtn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
                exitbtn.setForeground(new java.awt.Color(51, 51, 51));
                exitbtn.setText("Exit");
                exitbtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                exitbtnActionPerformed(evt);
                        }
                });
                jPanel2.add(exitbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 200, 70));

                video.setBackground(new java.awt.Color(153, 255, 255));
                video.setForeground(new java.awt.Color(153, 204, 255));
                video.setText("image here..");
                jPanel2.add(video, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 550, 460));

                capturebtn.setBackground(new java.awt.Color(153, 153, 255));
                capturebtn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
                capturebtn.setForeground(new java.awt.Color(51, 51, 51));
                capturebtn.setText("Capture");
                capturebtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                capturebtnActionPerformed(evt);
                        }
                });
                jPanel2.add(capturebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 200, 70));

                browsebtn.setBackground(new java.awt.Color(255, 204, 0));
                browsebtn.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
                browsebtn.setForeground(new java.awt.Color(51, 51, 51));
                browsebtn.setText("Browse");
                browsebtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                browsebtnActionPerformed(evt);
                        }
                });
                jPanel2.add(browsebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 200, 70));
                jPanel2.add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 550, 460));

                jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 940, 650));

                jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(0, 0, 0));
                jLabel1.setText("WebCamApp");
                jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));

                jLabel3.setForeground(new java.awt.Color(0, 0, 0));
                jLabel3.setText("By: Christian Barbosa");
                jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, -1, -1));

                getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 740));

                pack();
        }// </editor-fold>//GEN-END:initComponents

	private void startWebcamFeed() {
        imageLabel = new JLabel();
        imageLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel1.add(imageLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 330, 250));

        new Thread(() -> {
            while (true) {
                try {
                    BufferedImage image = webcam.getImage();
                    ImageIcon imageIcon = new ImageIcon(image);
                    imageLabel.setIcon(imageIcon);
                    video.repaint();
                    video.revalidate();
                    Thread.sleep(90); // Adjust the sleep duration based on your preference
                } catch (InterruptedException ex) {
                    Logger.getLogger(WebCamApp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
	

        private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed
           int confirmation = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);

        if (confirmation == JOptionPane.YES_OPTION) {
            // If the user confirms, exit the application
            System.exit(0);
        }
        }//GEN-LAST:event_exitbtnActionPerformed

        private void capturebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_capturebtnActionPerformed
               String directoryPath = "D:/downloads/PicTuresFromJavaApp/";
	       int currentImage = imageCounter++;
		
		Webcam webcam = Webcam.getDefault();
		webcam.open();
		try {
        String fileName = "image" + imageCounter + ".jpg"; // Use a counter for unique filenames
        ImageIO.write(webcam.getImage(), "JPG", new File(directoryPath,fileName));
        imageCounter++; // Increment the counter for the next image
	ImageIcon imageIcon = new ImageIcon(fileName);
        imageLabel.setIcon(imageIcon);
	
	 // Add the JLabel to your panel
        video.add(imageLabel);

        // Repaint the panel to reflect changes
        video.repaint();
	video.revalidate();
    } catch (IOException ex) {
        Logger.getLogger(WebCamApp.class.getName()).log(Level.SEVERE, null, ex);
    }
        }//GEN-LAST:event_capturebtnActionPerformed

        private void browsebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browsebtnActionPerformed
       // Specify the folder path
        String folderPath = "D:/downloads/PicTuresFromJavaApp";

        // Create a File object for the specified folder
        File folder = new File(folderPath);

        // Check if the folder exists
        if (folder.exists() && folder.isDirectory()) {
            try {
                // Open the folder using the system's default file manager
                Desktop.getDesktop().open(folder);
            } catch (IOException ex) {
                ex.printStackTrace();
                // Handle the exception, e.g., display an error message
                JOptionPane.showMessageDialog(this, "Error opening the folder.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Display an error message if the folder does not exist
            JOptionPane.showMessageDialog(this, "Folder does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        }//GEN-LAST:event_browsebtnActionPerformed

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
			java.util.logging.Logger.getLogger(WebCamApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(WebCamApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(WebCamApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(WebCamApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new WebCamApp().setVisible(true);
			}
		});
	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton browsebtn;
        private javax.swing.JButton capturebtn;
        private javax.swing.JButton exitbtn;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private java.awt.Panel panel1;
        private javax.swing.JLabel video;
        // End of variables declaration//GEN-END:variables
}
