import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CarSystem extends JFrame {
    private JPanel panelMain;
    private JPanel panelHome;
    private JPanel panelAddSaleCar;
    private JPanel panelCustomer;
    private JPanel panelViewCars;
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

        JButton buttonViewCars = new JButton();
        buttonViewCars.setText("View Cars");
        buttonViewCars.addActionListener(this::ViewCarsButtonActionPerformed);
        sidebar.add(buttonViewCars);

        JButton buttonAddSaleCar = new JButton();
        buttonAddSaleCar.setText("Add Car");
        buttonAddSaleCar.addActionListener(this::addSaleCarButtonActionPerformed);
        sidebar.add(buttonAddSaleCar);

        //left menu
        split.setLeftComponent(sidebar);

        panelMain.setLayout(new CardLayout());// https://docs.oracle.com/javase/tutorial/uiswing/layout/card.html


        //Creates the panel for the corresponding button click

        /*
        Home
        */

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
        //end home

        /*
        Customer
        */
//remove this later
        JTextField textFile = new JTextField(6);

        panelCustomer = new JPanel();
        JPanel filetesting = new JPanel(new GridLayout(4, 1));
        filetesting.add(new JLabel("TextField" ));
        filetesting.add(textFile);
//need to remove end

        GroupLayout layoutEmployee = new GroupLayout(panelCustomer); //https://docs.oracle.com/javase/tutorial/uiswing/layout/group.html
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
        //end customer

        /*
        View Cars
        */

        panelViewCars = new JPanel();
        JLabel jLabelViewCars = new JLabel();

        jLabelViewCars.setText("View Cars");

        GroupLayout layoutViewCars = new GroupLayout(panelViewCars);
        panelViewCars.setLayout(layoutViewCars);
        layoutViewCars.setHorizontalGroup(
                layoutViewCars.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layoutViewCars.createSequentialGroup()
                                .addGap(500, 500, 500)
                                .addComponent(jLabelViewCars)
                                .addContainerGap(400, Short.MAX_VALUE))
        );

        layoutViewCars.setVerticalGroup(
                layoutViewCars.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layoutViewCars.createSequentialGroup()
                                .addGap(300, 300, 300)
                                .addComponent(jLabelViewCars)
                                .addContainerGap(350, Short.MAX_VALUE))
        );
        panelMain.add(panelViewCars);
        //end view cars

        /*
        AddSaleCar
        */

        panelAddSaleCar = new JPanel();
        JLabel jLabelAddSaleCar = new JLabel();

        jLabelAddSaleCar.setText("Sell Car");

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
        //end AddSaleCar



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

    private void ViewCarsButtonActionPerformed(ActionEvent actionEvent) {
        panelMain.removeAll();
        panelMain.add(panelViewCars);
        panelMain.repaint();
        panelMain.revalidate();
    }


}//end
