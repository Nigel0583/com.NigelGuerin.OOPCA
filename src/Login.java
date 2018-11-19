import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Nigel Guerin
 */
public class Login extends JDialog implements ActionListener {
    JPanel pnInput;
    JTextField tfUser;
    JTextField tfPass;
    JLabel lbUser;
    JLabel lbPass;
    JButton btLogin;
    JButton btCancel;
    //------------------------------------------------------------------------------

    public Login() {
        setTitle("Enter Details");
        setIconImage(new ImageIcon(getClass().getResource("car.jpg")).getImage());

        pnInput = new JPanel();
        GridBagLayout gbInput = new GridBagLayout();
        GridBagConstraints gbcInput = new GridBagConstraints();
        pnInput.setLayout(gbInput);

        tfUser = new JTextField();
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

        tfPass = new JTextField();
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

        btLogin = new JButton("Login");
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

        btCancel = new JButton("Cancel");
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
    } // end Login

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
