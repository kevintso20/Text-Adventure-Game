package GameClasses;

import MonsterFight.AfterHiting;
import Storys.MainStory;
import javax.swing.ButtonGroup;
import static javax.swing.JOptionPane.showMessageDialog;
import java.awt.Image;
import javax.swing.ImageIcon;

public class StartingForm extends javax.swing.JFrame {

    private static ButtonGroup grupDifficulity = new ButtonGroup();
    private static ButtonGroup groupStory = new ButtonGroup();
    private static String selectedStory = "";

    public StartingForm() {
        initComponents();
        groupButtons();
        backgroundLabel.setIcon(new ImageIcon(backGroundImage()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        textName = new javax.swing.JTextField();
        HomeVersion = new javax.swing.JRadioButton();
        AloneInForrest = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        Easy = new javax.swing.JRadioButton();
        Hard = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        Medium = new javax.swing.JRadioButton();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Play");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        textName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        HomeVersion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        HomeVersion.setForeground(new java.awt.Color(255, 255, 255));
        HomeVersion.setText("Home version");

        AloneInForrest.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AloneInForrest.setForeground(new java.awt.Color(255, 255, 255));
        AloneInForrest.setText("Alone In forrest");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Difficulty");

        Easy.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Easy.setForeground(new java.awt.Color(255, 255, 255));
        Easy.setText("Easy");
        Easy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EasyActionPerformed(evt);
            }
        });

        Hard.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Hard.setForeground(new java.awt.Color(255, 255, 255));
        Hard.setText("Hard");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Choice Story");

        Medium.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Medium.setForeground(new java.awt.Color(255, 255, 255));
        Medium.setText("Medium");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(414, 414, 414)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(AloneInForrest, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(Easy, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(401, 401, 401)
                .addComponent(HomeVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(Medium, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(383, 383, 383)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(615, 615, 615)
                .addComponent(Hard, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(backgroundLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AloneInForrest, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(Easy, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HomeVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Medium, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(434, 434, 434)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(Hard, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(backgroundLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Zork zork = new Zork();
        if (grupDifficulity.getSelection() != null && groupStory.getSelection() != null && !textName.getText().isEmpty()) {
            Game.getActiveUser().setUserName(textName.getText());

            dificulity();
            story();

            this.setVisible(false);
            zork.setVisible(true);
        } else {
            if (grupDifficulity.getSelection() == null && groupStory.getSelection() == null) {
                showMessageDialog(null, "You need to choice difficulity and game mode and type your name");
            } else if (grupDifficulity.getSelection() == null) {
                showMessageDialog(null, "You need to choice difficulity");
            } else if (groupStory.getSelection() == null) {
                showMessageDialog(null, "You need to choice game mode ");
            } else if (textName.getText().isEmpty()) {
                showMessageDialog(null, "Type your name ");
            }
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void EasyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EasyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EasyActionPerformed

    private Image backGroundImage() {
        ImageIcon SortByIcon = new ImageIcon(getClass().getResource("/Images/Lights/zorknemesis.png"));
        Image image = SortByIcon.getImage().getScaledInstance(934, 537, 150);
        return image;
    }

    private void groupButtons() {
        grupDifficulity.add(Easy);
        grupDifficulity.add(Medium);
        grupDifficulity.add(Hard);

        Easy.setActionCommand("easy");
        Medium.setActionCommand("medium");
        Hard.setActionCommand("hard");

        groupStory.add(AloneInForrest);
        groupStory.add(HomeVersion);

        AloneInForrest.setActionCommand("aloneinforest");
        HomeVersion.setActionCommand("homeversion");

    }

    private void dificulity() {

        if (grupDifficulity.getSelection().getActionCommand().equals("easy")) {
            easy();
        } else if (grupDifficulity.getSelection().getActionCommand().equals("medium")) {
            midium();
        } else if (grupDifficulity.getSelection().getActionCommand().equals("hard")) {
            hard();
        }

    }

    private void story() {

        if (groupStory.getSelection().getActionCommand().equals("aloneinforest")) {
            MainStory.selectedStory = "aloneinforest";
            Game.getActiveUser().setRoomYouAre("forest");
            AfterHiting.story = "aloneinforest";

        } else if (groupStory.getSelection().getActionCommand().equals("homeversion")) {
            MainStory.selectedStory = "homeversion";
            AfterHiting.story = "homeversion";
            Game.getActiveUser().setRoomYouAre("kitchen");

        }

    }

    public void easy() {
        Zork.secondsPassed = 1200;
        Game.setHowPicesIsDay(98);
        Game.setMaximumMoves(300);
    }

    public void midium() {
        Zork.secondsPassed = 900;
        Game.setHowPicesIsDay(64);
        Game.setMaximumMoves(150);
    }

    public void hard() {
        Zork.secondsPassed = 600;
        Game.setHowPicesIsDay(30);
        Game.setMaximumMoves(100);
    }

    public static ButtonGroup getGrupDifficulity() {
        return grupDifficulity;
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartingForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton AloneInForrest;
    private javax.swing.JRadioButton Easy;
    private javax.swing.JRadioButton Hard;
    private javax.swing.JRadioButton HomeVersion;
    private javax.swing.JRadioButton Medium;
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField textName;
    // End of variables declaration//GEN-END:variables
}
