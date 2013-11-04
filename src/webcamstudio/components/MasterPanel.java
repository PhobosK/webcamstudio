/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MasterPanel.java
 *
 * Created on 4-Apr-2012, 6:52:17 PM
 */
package webcamstudio.components;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.SpinnerNumberModel;
import webcamstudio.channels.MasterChannels;
import webcamstudio.mixers.Frame;
import webcamstudio.mixers.MasterMixer;
import webcamstudio.mixers.SystemPlayer;
import webcamstudio.streams.SourceChannel;
import webcamstudio.streams.SourceText;
import webcamstudio.streams.Stream;
import webcamstudio.util.Tools;

/**
 *
 * @author patrick (modified by karl)
 */
public class MasterPanel extends javax.swing.JPanel implements MasterMixer.SinkListener {

    protected Viewer viewer = new Viewer();
    private SystemPlayer player = null;
    private MasterMixer mixer = MasterMixer.getInstance();
    MasterChannels master = MasterChannels.getInstance();
    final static public Dimension PANEL_SIZE = new Dimension(150, 400);
    ArrayList<Stream> streamM = MasterChannels.getInstance().getStreams();   
    

    /** Creates new form MasterPanel */
    public MasterPanel() {
        initComponents();
        spinFPS.setModel(new SpinnerNumberModel(5, 5, 30, 5));
        spinWidth.setValue(mixer.getWidth());
        spinHeight.setValue(mixer.getHeight());
        this.setVisible(true);
        viewer.setOpaque(true);
        panelPreview.add(viewer, BorderLayout.CENTER);
        player = SystemPlayer.getInstance(viewer);
        mixer.register(this);
        spinFPS.setValue(MasterMixer.getInstance().getRate());
        panChannels.add(new ChannelPanel(), BorderLayout.CENTER);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPreview = new javax.swing.JPanel();
        tabMixers = new javax.swing.JTabbedPane();
        panChannels = new javax.swing.JPanel();
        panMixer = new javax.swing.JPanel();
        tglSound = new javax.swing.JToggleButton();
        lblWidth = new javax.swing.JLabel();
        lblHeight = new javax.swing.JLabel();
        spinWidth = new javax.swing.JSpinner();
        spinHeight = new javax.swing.JSpinner();
        btnApply = new javax.swing.JButton();
        lblHeight1 = new javax.swing.JLabel();
        spinFPS = new javax.swing.JSpinner();
        btnApplyToStreams = new javax.swing.JButton();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("webcamstudio/Languages"); // NOI18N
        setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("PREVIEW"))); // NOI18N
        setLayout(new java.awt.BorderLayout());

        panelPreview.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        panelPreview.setMaximumSize(new java.awt.Dimension(180, 120));
        panelPreview.setMinimumSize(new java.awt.Dimension(180, 120));
        panelPreview.setName("panelPreview"); // NOI18N
        panelPreview.setPreferredSize(new java.awt.Dimension(180, 120));
        panelPreview.setLayout(new java.awt.BorderLayout());
        add(panelPreview, java.awt.BorderLayout.NORTH);

        tabMixers.setName("tabMixers"); // NOI18N

        panChannels.setName("panChannels"); // NOI18N
        panChannels.setLayout(new java.awt.BorderLayout());
        tabMixers.addTab(bundle.getString("CHANNELS"), panChannels); // NOI18N

        panMixer.setName("panMixer"); // NOI18N

        tglSound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/webcamstudio/resources/tango/audio-card.png"))); // NOI18N
        tglSound.setToolTipText("Audio Monitor Switch");
        tglSound.setName("tglSound"); // NOI18N
        tglSound.setPreferredSize(new java.awt.Dimension(32, 30));
        tglSound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglSoundActionPerformed(evt);
            }
        });

        lblWidth.setText(bundle.getString("WIDTH")); // NOI18N
        lblWidth.setName("lblWidth"); // NOI18N

        lblHeight.setText(bundle.getString("HEIGHT")); // NOI18N
        lblHeight.setName("lblHeight"); // NOI18N

        spinWidth.setName("spinWidth"); // NOI18N

        spinHeight.setName("spinHeight"); // NOI18N

        btnApply.setText(bundle.getString("APPLY")); // NOI18N
        btnApply.setToolTipText("Apply Mixer Settings");
        btnApply.setName("btnApply"); // NOI18N
        btnApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyActionPerformed(evt);
            }
        });

        lblHeight1.setText(bundle.getString("FRAMERATE")); // NOI18N
        lblHeight1.setName("lblHeight1"); // NOI18N

        spinFPS.setName("spinFPS"); // NOI18N

        btnApplyToStreams.setText("Apply to Streams");
        btnApplyToStreams.setToolTipText("Apply Mixer Settings Proportionally to all Streams.");
        btnApplyToStreams.setName("btnApplyToStreams"); // NOI18N
        btnApplyToStreams.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApplyToStreamsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panMixerLayout = new javax.swing.GroupLayout(panMixer);
        panMixer.setLayout(panMixerLayout);
        panMixerLayout.setHorizontalGroup(
            panMixerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMixerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panMixerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panMixerLayout.createSequentialGroup()
                        .addGroup(panMixerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHeight1)
                            .addComponent(lblWidth)
                            .addComponent(lblHeight))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panMixerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(spinFPS, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(spinHeight)
                            .addComponent(spinWidth)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panMixerLayout.createSequentialGroup()
                        .addComponent(btnApply, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tglSound, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnApplyToStreams, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
                .addContainerGap())
        );
        panMixerLayout.setVerticalGroup(
            panMixerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panMixerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panMixerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWidth))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panMixerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHeight))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panMixerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinFPS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHeight1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panMixerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnApply, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tglSound, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnApplyToStreams, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        tabMixers.addTab(bundle.getString("MIXER"), panMixer); // NOI18N

        add(tabMixers, java.awt.BorderLayout.CENTER);
        tabMixers.getAccessibleContext().setAccessibleName(bundle.getString("MIXER")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents

    public void releaseTglButton(){
        tglSound.setEnabled(!player.stopMePub);
    }
    private void tglSoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglSoundActionPerformed
        if (tglSound.isSelected()) {
            try {
                player.play();
            } catch (LineUnavailableException ex) {
                Logger.getLogger(MasterPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            player.stop();
        }
    }//GEN-LAST:event_tglSoundActionPerformed
    public void applyLoadedMixer(){
        int w = (Integer) spinWidth.getValue();
        int h = (Integer) spinHeight.getValue();
        if (tglSound.isSelected()) {
            player.stop();
        }
        mixer.stop();
        mixer.setWidth(w);
        mixer.setHeight(h);
        mixer.setRate((Integer) spinFPS.getValue());
        MasterMixer.getInstance().start();
        if (tglSound.isSelected()) {
            try {
                player.play();
            } catch (LineUnavailableException ex) {
                Logger.getLogger(MasterPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private void btnApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyActionPerformed
        SystemPlayer.getInstance(null).stop();
        Tools.sleep(30);
        MasterChannels.getInstance().stopAllStream();
        for (Stream s : streamM){
            s.updateStatus();
        }
        Tools.sleep(30);
        int w = (Integer) spinWidth.getValue();
        int h = (Integer) spinHeight.getValue();
        if (tglSound.isSelected()) {
            player.stop();
        }
        mixer.stop();
        mixer.setWidth(w);
        mixer.setHeight(h);
        mixer.setRate((Integer) spinFPS.getValue());
        MasterMixer.getInstance().start();
        if (tglSound.isSelected()) {
            try {
                player.play();
            } catch (LineUnavailableException ex) {
                Logger.getLogger(MasterPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnApplyActionPerformed

    private void btnApplyToStreamsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApplyToStreamsActionPerformed
        ArrayList<Stream> allStreams = MasterChannels.getInstance().getStreams();
//        SystemPlayer.getInstance(null).stop();
//        Tools.sleep(30);
//        MasterChannels.getInstance().stopAllStream();
//        for (Stream s : allStreams){
//            s.updateStatus();
//        }
        int wi = mixer.getWidth();
        int he = mixer.getHeight();
        int oldCW = mixer.getWidth();
        int oldCH = mixer.getHeight();
        for (int l=0; l< allStreams.size(); l++) {
            if (allStreams.get(l) instanceof SourceText) {       
            } else {
            oldCW = allStreams.get(l).getCaptureWidth();
            oldCH = allStreams.get(l).getCaptureHeight();
            }
            int oldW = allStreams.get(l).getWidth();
            int oldH = allStreams.get(l).getHeight();
            int oldX = allStreams.get(l).getX();
            int oldY = allStreams.get(l).getY();
            int newW = (oldW * wi) / oldCW;
            int newH = (oldH * he) / oldCH;
            int newX = (oldX * wi) / oldCW;
            int newY = (oldY * he) / oldCH;
            if (allStreams.get(l) instanceof SourceText) {
                allStreams.get(l).setWidth(newW);
                allStreams.get(l).setHeight(newH);
                allStreams.get(l).setX(newX);
                allStreams.get(l).setY(newY);
                allStreams.get(l).setCaptureWidth(newW);
                allStreams.get(l).setCaptureHeight(newH);
                allStreams.get(l).updateStatus();
                for (SourceChannel ssc : allStreams.get(l).getChannels()){
                    ssc.setWidth(newW);
                    ssc.setHeight(newH);
                    ssc.setX(newX);
                    ssc.setY(newY);
                    ssc.setCapWidth(newW);
                    ssc.setCapHeight(newH);
                }
            } else {
                allStreams.get(l).setWidth(newW);
                allStreams.get(l).setHeight(newH);
                allStreams.get(l).setX(newX);
                allStreams.get(l).setY(newY);
                allStreams.get(l).setCaptureWidth(wi);
                allStreams.get(l).setCaptureHeight(he);
                allStreams.get(l).updateStatus();
                for (SourceChannel ssc : allStreams.get(l).getChannels()){
                    ssc.setWidth(newW);
                    ssc.setHeight(newH);
                    ssc.setX(newX);
                    ssc.setY(newY);
                    ssc.setCapWidth(wi);
                    ssc.setCapHeight(he);
                }
            }   
        }
    }//GEN-LAST:event_btnApplyToStreamsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApply;
    private javax.swing.JButton btnApplyToStreams;
    private javax.swing.JLabel lblHeight;
    private javax.swing.JLabel lblHeight1;
    private javax.swing.JLabel lblWidth;
    private javax.swing.JPanel panChannels;
    private javax.swing.JPanel panMixer;
    private javax.swing.JPanel panelPreview;
    public static javax.swing.JSpinner spinFPS;
    public static javax.swing.JSpinner spinHeight;
    public static javax.swing.JSpinner spinWidth;
    private javax.swing.JTabbedPane tabMixers;
    public static javax.swing.JToggleButton tglSound;
    // End of variables declaration//GEN-END:variables

    @Override
    public void newFrame(Frame frame) {
        player.addFrame(frame);
    }
}
