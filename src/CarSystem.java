import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CarSystem extends JFrame {
    private JButton buttonFile;
    private JPanel panelMain;
    private JPanel panelHome;
    private JPanel panelFile;
    private JPanel panelAddSaleCar;
    private JPanel panelCustomer;
    private JPanel panelBooking;
    private JLabel jLabelFile;
    private JLabel jLabelEmp;
    private JLabel jLabelBook;
    private GroupLayout layoutfile;
    private GroupLayout layoutAddSaleCar;
    private GroupLayout layoutBooking; //https://docs.oracle.com/javase/tutorial/uiswing/layout/group.html

    /*
    Creates GUI
     */
    public   CarSystem() {

        //Code is from https://stackoverflow.com/questions/7065309/jsplitpane-set-resizable-false
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT) {
            private final int location = 150;

            {
                setDividerLocation(location);
            }

            @Override
            public int getDividerLocation() {
                return location;
            }

            @Override
            public int getLastDividerLocation() {
                return location;
            }
        };


        //Creates menu and buttons for the menu
        JPanel sidebar = new JPanel();
        panelMain = new JPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        sidebar.setBackground(new Color(255, 255, 255));
        sidebar.setLayout(new GridLayout(20, 1));


        JButton buttonHome = new JButton();
        buttonHome.setText("Home");
        buttonHome.addActionListener(this::homeButtonActionPerformed);//Method Reference
        sidebar.add(buttonHome);

        JButton buttonCustomer = new JButton();
        buttonCustomer.setText("Login");
        buttonCustomer.addActionListener(this::customerButtonActionPerformed);
        sidebar.add(buttonCustomer);

        JButton buttonAddSaleCar = new JButton();
        buttonAddSaleCar.setText("Add Car");
        buttonAddSaleCar.addActionListener(this::addSaleCarButtonActionPerformed);
        sidebar.add(buttonAddSaleCar);


/*
        bookingButton = new JButton();
        bookingButton.setText("Add Employee");
        bookingButton.addActionListener(this::bookingButtonActionPerformed);
        sidebar.add(bookingButton);

         fileButton = new JButton();
        fileButton.setText("File");
        fileButton.addActionListener(this::fileButtonActionPerformed);
        sidebar.add(fileButton);

*/

        //left menu
        split.setLeftComponent(sidebar);

        panelMain.setLayout(new CardLayout());// https://docs.oracle.com/javase/tutorial/uiswing/layout/card.html


        //Creates the panel for the corresponding button click

        /* Home */
        panelHome = new JPanel();
        JLabel jLabelHome = new JLabel();
        jLabelHome.setText("Home");

        GroupLayout layoutHome = new GroupLayout(panelHome);
        panelHome.setLayout(layoutHome);
        layoutHome.setHorizontalGroup(
                layoutHome.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layoutHome.createSequentialGroup()
                                .addGap(500, 500, 500)
                                .addComponent(jLabelHome)
                                .addContainerGap(400, Short.MAX_VALUE))
        );

        layoutHome.setVerticalGroup(
                layoutHome.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layoutHome.createSequentialGroup()
                                .addGap(300, 300, 300)
                                .addComponent(jLabelHome)
                                .addContainerGap(350, Short.MAX_VALUE))
        );
        panelMain.add(panelHome);


        JTextField textFile = new JTextField(6);
        /* Customer */
        panelCustomer = new JPanel();
        JPanel filetesting = new JPanel(new GridLayout(4, 1));
        filetesting.add(new JLabel("TextField" ));
        filetesting.add(textFile);


        GroupLayout layoutEmployee = new GroupLayout(panelCustomer);
        panelCustomer.setLayout(layoutEmployee);
        layoutEmployee.setHorizontalGroup(
                layoutEmployee.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layoutEmployee.createSequentialGroup()
                                .addGap(500, 500, 500)
                                .addComponent(filetesting)
                                .addContainerGap(400, Short.MAX_VALUE))
        );

        layoutEmployee.setVerticalGroup(
                layoutEmployee.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layoutEmployee.createSequentialGroup()
                                .addGap(300, 300, 300)
                                .addComponent(filetesting)
                                .addContainerGap(350, Short.MAX_VALUE))
        );
        panelMain.add(panelCustomer);




        panelAddSaleCar = new JPanel();
        JLabel jLabelAddSaleCar = new JLabel();

        jLabelAddSaleCar.setText("Add car");

        GroupLayout layoutAddSaleCar = new GroupLayout(panelAddSaleCar);
        panelAddSaleCar.setLayout(layoutAddSaleCar);
        layoutAddSaleCar.setHorizontalGroup(
                layoutAddSaleCar.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layoutAddSaleCar.createSequentialGroup()
                                .addGap(500, 500, 500)
                                .addComponent(jLabelAddSaleCar)
                                .addContainerGap(400, Short.MAX_VALUE))
        );

        layoutAddSaleCar.setVerticalGroup(
                layoutAddSaleCar.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layoutAddSaleCar.createSequentialGroup()
                                .addGap(300, 300, 300)
                                .addComponent(jLabelAddSaleCar)
                                .addContainerGap(350, Short.MAX_VALUE))
        );
        panelMain.add(panelAddSaleCar);
/*
        panelEmployee = new JPanel();
        jLabelEmp = new JLabel();

        panelBooking = new JPanel();
        jLabelBook = new JLabel();
*/
        //right panel
        split.setRightComponent(panelMain);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(split)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(split)
        );

        setFont(new Font("Calibri", Font.PLAIN, 24));
        setTitle("Car System");
        setResizable(false);
        setVisible(true);
        pack();

    }

    private void homeButtonActionPerformed(ActionEvent actionEvent) {
        panelMain.removeAll();
        panelMain.add(panelHome);
        panelMain.repaint();
        panelMain.revalidate();
    }

    private void customerButtonActionPerformed(ActionEvent actionEvent) {
        panelMain.removeAll();
        panelMain.add(panelCustomer);
        panelMain.repaint();
        panelMain.revalidate();
    }


    private void addSaleCarButtonActionPerformed(ActionEvent actionEvent) {
        panelMain.removeAll();
        panelMain.add(panelAddSaleCar);
        panelMain.repaint();
        panelMain.revalidate();
    }
/*
    private void (ActionEvent actionEvent) {
    }

    private void bookingButtonActionPerformed(ActionEvent actionEvent) {
    }

*/
}//end
