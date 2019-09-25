/***************************************************************
* file: HighScoreScreen.java
* author: Gary Machorro, Brandon Helt, Sonya Eller
* class: CS 2450 – Programming Graphical User Interfaces
*
* assignment: Project 1
* date last modified: 9/24/19
*
* purpose: This file is for the high scores screen.  Updates according to
* a text file. Does replace the 'back' button with the 'end' button when the 
* user decides to 'skip' a game.
*
****************************************************************/ 

package cs245.project;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.KeyStroke;


public class HighScoreScreen extends javax.swing.JFrame {

    /**
     * Creates new form HighScoreScreen
     */
    int score;
     private static final String FILE_NAME = "highscorerecord.txt";

    public HighScoreScreen() {
        initComponents();
        displayScores();
        addBindings();
        Player_Score.setVisible(false);
        End.setVisible(false);
        ScoreBox.setEditable(false);
        
    }
    
    //method: addBindings
    //purpose: adds keyBindings to the label jLabel1
    public void addBindings(){
        Action exit = new AbstractAction(){
            public void actionPerformed(ActionEvent e){
                dispose();
                System.exit(0);
            }
        };
        Action credits = new AbstractAction(){
            public void actionPerformed(ActionEvent e){
                System.out.print("test1\n");
                MainMenu menu = new MainMenu();
                CreditsScreen credits = new CreditsScreen();
                menu.setVisible(false);
                credits.setVisible(true);
                dispose();
            }
        };
        String actName = "exit";
        jLabel1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"),
                actName);
        jLabel1.getActionMap().put(actName, exit);
        actName = "credits";
        jLabel1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("F1"),
                actName);
        jLabel1.getActionMap().put(actName, credits);
    }
    
        // method: displayScores
            // purpose: reads and displays scores from the text file
    public void displayScores() {
        try{
        FileReader reader = new FileReader(FILE_NAME);
        BufferedReader br = new BufferedReader(reader);
        ScoreBox.read(br, null);
        br.close();
        }
        
        catch(Exception e) {
            
        }
    }
    public void setPlayerScore(int score)
    {
        this.score = score;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Back = new javax.swing.JButton();
        Player_Score = new javax.swing.JLabel();
        End = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ScoreBox = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        Back.setText("Back");
        Back.setToolTipText("Exit to main menu.");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        Player_Score.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        Player_Score.setText("Your Score: 100");

        End.setText("End");
        End.setToolTipText("Exit to main menu.");
        End.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EndActionPerformed(evt);
            }
        });

        ScoreBox.setColumns(20);
        ScoreBox.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        ScoreBox.setRows(5);
        ScoreBox.setMaximumSize(new java.awt.Dimension(150, 115));
        ScoreBox.setMinimumSize(new java.awt.Dimension(150, 115));
        ScoreBox.setVerifyInputWhenFocusTarget(false);
        jScrollPane1.setViewportView(ScoreBox);
        try{
            FileReader reader = new FileReader(FILE_NAME);
            BufferedReader br = new BufferedReader(reader);
            ScoreBox.read(br, null);
            br.close();
        }
        catch(Exception e) {

        }
        ScoreBox.setLineWrap(true);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("HIGHSCORES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Back)
                        .addGap(212, 212, 212)
                        .addComponent(End)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 217, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(Player_Score)
                                    .addGap(206, 206, 206))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(214, 214, 214)))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Player_Score)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Back)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(End)
                        .addGap(19, 19, 19))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        MainMenu menu = new MainMenu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void EndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EndActionPerformed
        // TODO add your handling code here:
        MainMenu menu = new MainMenu();
        menu.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_EndActionPerformed

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
            java.util.logging.Logger.getLogger(HighScoreScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HighScoreScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HighScoreScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HighScoreScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HighScoreScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Back;
    public javax.swing.JButton End;
    public javax.swing.JLabel Player_Score;
    private javax.swing.JTextArea ScoreBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}