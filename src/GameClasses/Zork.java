package GameClasses;

import Handlers.TimeOfDayImage;
import GUIControler.IGUI;
import Commands.LightsOnOff;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.util.TimerTask;
import MonsterFight.MonsterOthers;
import GUIControler.UpdateMethods;
import java.awt.Image;
import java.util.ArrayList;

public class Zork extends javax.swing.JFrame implements IGUI {

    public static int secondsPassed = 9999;
    private static int CountDownForMonsterAttack;
  //  public static String currentHp = "";
    TimeOfDayImage imageHundlerTimeOfDay = new TimeOfDayImage();
    LightsOnOff imagesHundlerLighter = new LightsOnOff();
    GameOver gameOver = new GameOver();
    Game game = new Game();
    MonsterOthers monsterOthers = new MonsterOthers();
    UpdateMethods updateMethods = new UpdateMethods();
    ArrayList<IGUI> igui = new ArrayList<>();

    public Zork() {
        initComponents();

        igui = UpdateMethods.getIgui();
        igui.add(this);
        UpdateMethods.setIgui(igui);

        updateMethods.InitialState("Good Luck Have Fun!!!");
        StartTimer();

        MonsterAttackGif.setIcon(monsterOthers.spesificImageMonsterLabel(7));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        InportedText = new javax.swing.JTextField();
        FinalText = new javax.swing.JLabel();
        LabelMoves = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelHealth = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        MonsterMove = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ImageSunPossision = new javax.swing.JLabel();
        ImageLights = new javax.swing.JLabel();
        GodModeImage = new javax.swing.JLabel();
        timerLabel = new javax.swing.JLabel();
        viewTimerLabel = new javax.swing.JLabel();
        MonsterAttackGif = new javax.swing.JLabel();
        countDownMonsterLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        InportedText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        InportedText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InportedTextActionPerformed(evt);
            }
        });
        InportedText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                InportedTextKeyPressed(evt);
            }
        });

        FinalText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        LabelMoves.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Moves");

        labelHealth.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Health");

        MonsterMove.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Monster Next Move ");

        ImageLights.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImageLightsMouseClicked(evt);
            }
        });

        timerLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        timerLabel.setText("Timer");

        viewTimerLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        countDownMonsterLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(LabelMoves, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(timerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelHealth, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(viewTimerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ImageSunPossision, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ImageLights, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(GodModeImage, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(MonsterAttackGif, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MonsterMove, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(countDownMonsterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(InportedText, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(FinalText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                                    .addComponent(LabelMoves, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                                    .addComponent(labelHealth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(timerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(viewTimerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(ImageLights, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                                .addComponent(ImageSunPossision, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(MonsterAttackGif, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MonsterMove, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(countDownMonsterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(GodModeImage, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(FinalText, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(InportedText, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        GodModeImage.getAccessibleContext().setAccessibleParent(GodModeImage);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void InportedTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InportedTextKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            game.choiceTheState(InportedText.getText());
            InportedText.setText("");
            CountDownForMonsterAttack = 13;
            Game.getActiveUser().setCurrentHp(Integer.parseInt(labelHealth.getText()));
        }
    }//GEN-LAST:event_InportedTextKeyPressed

    private void InportedTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InportedTextActionPerformed

    }//GEN-LAST:event_InportedTextActionPerformed

    private void ImageLightsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImageLightsMouseClicked
        ImageLights.setIcon(new ImageIcon(imagesHundlerLighter.changeStatusOnLighterByclick()));
    }//GEN-LAST:event_ImageLightsMouseClicked

    private void StartTimer() {
        final java.util.Timer timer = new java.util.Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                if (Game.isIsPause() == false) {
                    secondsPassed--;
                    viewTimerLabel.setText(secondsPassed + "");
                    ImageSunPossision.setIcon(new ImageIcon(imageHundlerTimeOfDay.setTheImageDayOrNight()));
                    Game.getActiveUser().setCurrentHp(Integer.parseInt(labelHealth.getText()));
                    if (Game.isStillFighting() == true) {
                        CountDownForMonsterAttack--;
                        countDownMonsterLabel.setText(String.valueOf(CountDownForMonsterAttack));

                        if (CountDownForMonsterAttack > 5) {
                            MonsterAttackGif.setIcon(monsterOthers.spesificImageMonsterLabel(8));
                        } else if (CountDownForMonsterAttack == 4) {
                            MonsterAttackGif.setIcon(monsterOthers.setImageOfMonsterMove(MonsterMove.getText()));

                        } else if (CountDownForMonsterAttack == 0) {
                            CountDownForMonsterAttack = 13;
                            game.choiceTheState(InportedText.getText());
                            InportedText.setText("");
                        }
                    } else {
                        countDownMonsterLabel.setText("I will find you!!!! ");
                        MonsterAttackGif.setIcon(monsterOthers.spesificImageMonsterLabel(7));
                    }
                    if (secondsPassed <= 0) {
                        timer.cancel();
                        gameOver.gameOverState("You Lost");
                    }
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }

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
            java.util.logging.Logger.getLogger(Zork.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Zork.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Zork.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Zork.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Zork().setVisible(true);

            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FinalText;
    private javax.swing.JLabel GodModeImage;
    private javax.swing.JLabel ImageLights;
    private javax.swing.JLabel ImageSunPossision;
    private javax.swing.JTextField InportedText;
    private javax.swing.JLabel LabelMoves;
    private javax.swing.JLabel MonsterAttackGif;
    private javax.swing.JLabel MonsterMove;
    private javax.swing.JLabel countDownMonsterLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel labelHealth;
    private javax.swing.JLabel timerLabel;
    private javax.swing.JLabel viewTimerLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void ReceivedFinalText(String finalText) {
        FinalText.setText(finalText);
    }

    @Override
    public void ReceivedHealthPoints(String amtHealth) {
        labelHealth.setText(amtHealth);
    }

    @Override
    public void ReceivedMonsterNextMove(String move) {
        MonsterMove.setText(move);
    }

    @Override
    public void ReceivedGodModeImage(Image image) {
        GodModeImage.setIcon(new ImageIcon(image));
    }

    @Override
    public void ReceivedLightsImage(Image image) {
        ImageLights.setIcon(new ImageIcon(image));
    }

    @Override
    public void ReceivedTimeOfDayImage(Image image) {
        ImageSunPossision.setIcon(new ImageIcon(image));
    }

    @Override
    public void ReceivedMoves(String moves) {
        LabelMoves.setText(moves);
    }

    @Override
    public void ReceivedMonsterGif(Image image) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ReceivedTimerOfGame(String time) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
