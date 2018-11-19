import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Nigel Guerin
 */
public class Login extends JFrame implements ActionListener {
    private String user;
    private String pass;
    JPanel pnInput;
    JTextField tfUser;
    JTextField tfPass;
    JLabel lbUser;
    JLabel lbPass;
    JButton btLogin;
    JButton btCancel;
    File wavFile;
    URL defaultSound;
    public static Clip clip;
    public static AudioInputStream audioInputStream;

    //------------------------------------------------------------------------------

    public Login(String url) {
        try {
            setTitle("Enter Details");
            try {
                setIconImage(new ImageIcon(getClass().getResource("car.jpg")).getImage());
            } catch (Exception x){

            }


            pnInput = new JPanel();
            GridBagLayout gbInput = new GridBagLayout();
            GridBagConstraints gbcInput = new GridBagConstraints();
            pnInput.setLayout(gbInput);
            defaultSound = new URL(url);

            this.tfUser = new JTextField();
            gbcInput.gridx = 6;
            gbcInput.gridy = 2;
            gbcInput.gridwidth = 10;
            gbcInput.gridheight = 1;
            gbcInput.fill = GridBagConstraints.BOTH;
            gbcInput.weightx = 1;
            gbcInput.weighty = 0;
            gbcInput.anchor = GridBagConstraints.NORTH;
            gbInput.setConstraints(tfUser, gbcInput);
            pnInput.add(tfUser);

            this.tfPass = new JPasswordField();
            gbcInput.gridx = 6;
            gbcInput.gridy = 4;
            gbcInput.gridwidth = 10;
            gbcInput.gridheight = 1;
            gbcInput.fill = GridBagConstraints.BOTH;
            gbcInput.weightx = 1;
            gbcInput.weighty = 0;
            gbcInput.anchor = GridBagConstraints.NORTH;
            gbInput.setConstraints(tfPass, gbcInput);
            pnInput.add(tfPass);

            lbUser = new JLabel("Username:");
            gbcInput.gridx = 2;
            gbcInput.gridy = 2;
            gbcInput.gridwidth = 4;
            gbcInput.gridheight = 1;
            gbcInput.fill = GridBagConstraints.BOTH;
            gbcInput.weightx = 1;
            gbcInput.weighty = 1;
            gbcInput.anchor = GridBagConstraints.NORTH;
            gbInput.setConstraints(lbUser, gbcInput);
            pnInput.add(lbUser);

            lbPass = new JLabel("Password:");
            gbcInput.gridx = 2;
            gbcInput.gridy = 4;
            gbcInput.gridwidth = 4;
            gbcInput.gridheight = 1;
            gbcInput.fill = GridBagConstraints.BOTH;
            gbcInput.weightx = 1;
            gbcInput.weighty = 1;
            gbcInput.anchor = GridBagConstraints.NORTH;
            gbInput.setConstraints(lbPass, gbcInput);
            pnInput.add(lbPass);

            this.btLogin = new JButton("Login");
            this.btLogin.addActionListener(this);
            gbcInput.gridx = 2;
            gbcInput.gridy = 6;
            gbcInput.gridwidth = 5;
            gbcInput.gridheight = 1;
            gbcInput.fill = GridBagConstraints.BOTH;
            gbcInput.weightx = 1;
            gbcInput.weighty = 0;
            gbcInput.anchor = GridBagConstraints.NORTH;
            gbInput.setConstraints(btLogin, gbcInput);
            pnInput.add(btLogin);

            this.btCancel = new JButton("Cancel");
            this.btCancel.addActionListener(this);
            gbcInput.gridx = 8;
            gbcInput.gridy = 6;
            gbcInput.gridwidth = 5;
            gbcInput.gridheight = 1;
            gbcInput.fill = GridBagConstraints.BOTH;
            gbcInput.weightx = 1;
            gbcInput.weighty = 0;
            gbcInput.anchor = GridBagConstraints.NORTH;
            gbInput.setConstraints(btCancel, gbcInput);
            pnInput.add(btCancel);

            setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            setContentPane(pnInput);
            setSize(300, 100);
            setVisible(true);
            setResizable(false);
            setLocationRelativeTo(null);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// end Login

    //Code for sound was adapted from https://stackoverflow.com/questions/27533617/play-sound-on-button-click
    public void play() {
        try {
            audioInputStream = AudioSystem.getAudioInputStream(defaultSound);

            try {
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.loop((int) 0.5f);
                clip.start();

            } catch (LineUnavailableException e) {
            }

        } catch (UnsupportedAudioFileException | IOException e) {
        }
    }

    public void stop() {
        clip.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String login = e.getActionCommand();
        if ((e.getSource() == this.btLogin) || login.equals("Login")) {
            play();
            this.user = this.tfUser.getText();
            this.pass = this.tfPass.getText();
            if (!this.user.equals("") && !this.pass.equals("")) {
                CarSystem carSystem = new CarSystem();
                carSystem.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "The email or password is incorrect", "Error", JOptionPane.WARNING_MESSAGE);
                this.tfUser.setText("");
                this.tfPass.setText("");
                this.tfUser.requestFocus();
            }


        } else if (e.getSource() == this.btCancel || login.equals("Cancel")) {
            System.exit(0);
        }
    }
}