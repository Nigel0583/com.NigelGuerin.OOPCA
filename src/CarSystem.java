import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class CarSystem extends JFrame  {
    private JPanel panelMain;
    private JPanel pnPanelSearchHome;
    private JPanel panelAddSaleCar;
    private JPanel panelCustomer;
    private JPanel panelViewCars;
    private JComboBox cmbMinYear;
    private JComboBox cmbMaxYear;
    private JTextField tfModel;
    private JTextField tfMinPrice;
    private JTextField tfMaxPrice;
    private JComboBox cmbBodyType;
    private JButton btSearchCar;
    private JTextField tfMake;

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

        panelMain.setLayout(new GridBagLayout());// https://docs.oracle.com/javase/tutorial/uiswing/layout/card.html


        //Creates the panel for the corresponding button click
        /*
        Home
        */

        //https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html

        JComboBox cmbMinYear;
        JComboBox cmbMaxYear;
        JTextField tfModel;
        JTextField tfMinPrice;
        JTextField tfMaxPrice;
        JComboBox cmbBodyType;
        JButton btSearchCar;
        JTextField tfMake;
        JLabel lbModel;
        JLabel lbMaxYear;
        JLabel lbMaxPrice;
        JLabel lbMake;
        JLabel lbMinYear;
        JLabel lbMinPrice;
        JLabel lbBodyType;

        pnPanelSearchHome = new JPanel();
        pnPanelSearchHome.setBorder( BorderFactory.createTitledBorder( "Search For Cars" ) );
        GridBagLayout gbPanelSearchHome = new GridBagLayout();
        GridBagConstraints gbcPanelSearchHome = new GridBagConstraints();
        pnPanelSearchHome.setLayout( gbPanelSearchHome );

        String []dataMinYear = { "182", "181", "172", "171", "162", "161", "152", "151",
                "142", "141", "132", "131", "2012", "2011", "2010",
                "2009", "2008", "2007", "2006", "2005", "2004", "2003",
                "2002", "2001", "2000" };
        cmbMinYear = new JComboBox( dataMinYear );
        gbcPanelSearchHome.gridx = 1;
        gbcPanelSearchHome.gridy = 1;
        gbcPanelSearchHome.gridwidth = 1;
        gbcPanelSearchHome.gridheight = 1;
        gbcPanelSearchHome.fill = GridBagConstraints.BOTH;
        gbcPanelSearchHome.weightx = 1;
        gbcPanelSearchHome.weighty = 0;
        gbcPanelSearchHome.anchor = GridBagConstraints.NORTH;
        gbPanelSearchHome.setConstraints( cmbMinYear, gbcPanelSearchHome );
        pnPanelSearchHome.add( cmbMinYear );

        String []dataMaxYear = { "2000", "2001", "2002", "2003", "2004", "2005", "2006",
                "2007", "2008", "2009", "2010", "2011", "2012", "131",
                "132", "141", "142", "151", "152", "161", "162", "171",
                "172", "181", "182" };
        cmbMaxYear = new JComboBox( dataMaxYear );
        gbcPanelSearchHome.gridx = 3;
        gbcPanelSearchHome.gridy = 1;
        gbcPanelSearchHome.gridwidth = 1;
        gbcPanelSearchHome.gridheight = 1;
        gbcPanelSearchHome.fill = GridBagConstraints.BOTH;
        gbcPanelSearchHome.weightx = 1;
        gbcPanelSearchHome.weighty = 0;
        gbcPanelSearchHome.anchor = GridBagConstraints.NORTH;
        gbPanelSearchHome.setConstraints( cmbMaxYear, gbcPanelSearchHome );
        pnPanelSearchHome.add( cmbMaxYear );

        tfModel = new JTextField( );
        gbcPanelSearchHome.gridx = 3;
        gbcPanelSearchHome.gridy = 0;
        gbcPanelSearchHome.gridwidth = 1;
        gbcPanelSearchHome.gridheight = 1;
        gbcPanelSearchHome.fill = GridBagConstraints.BOTH;
        gbcPanelSearchHome.weightx = 1;
        gbcPanelSearchHome.weighty = 0;
        gbcPanelSearchHome.anchor = GridBagConstraints.CENTER;
        gbPanelSearchHome.setConstraints( tfModel, gbcPanelSearchHome );
        pnPanelSearchHome.add( tfModel );

        tfMinPrice = new JTextField( );
        gbcPanelSearchHome.gridx = 1;
        gbcPanelSearchHome.gridy = 2;
        gbcPanelSearchHome.gridwidth = 1;
        gbcPanelSearchHome.gridheight = 1;
        gbcPanelSearchHome.fill = GridBagConstraints.BOTH;
        gbcPanelSearchHome.weightx = 1;
        gbcPanelSearchHome.weighty = 0;
        gbcPanelSearchHome.anchor = GridBagConstraints.NORTH;
        gbPanelSearchHome.setConstraints( tfMinPrice, gbcPanelSearchHome );
        pnPanelSearchHome.add( tfMinPrice );

        tfMaxPrice = new JTextField( );
        gbcPanelSearchHome.gridx = 3;
        gbcPanelSearchHome.gridy = 2;
        gbcPanelSearchHome.gridwidth = 1;
        gbcPanelSearchHome.gridheight = 1;
        gbcPanelSearchHome.fill = GridBagConstraints.BOTH;
        gbcPanelSearchHome.weightx = 1;
        gbcPanelSearchHome.weighty = 0;
        gbcPanelSearchHome.anchor = GridBagConstraints.NORTH;
        gbPanelSearchHome.setConstraints( tfMaxPrice, gbcPanelSearchHome );
        pnPanelSearchHome.add( tfMaxPrice );

        String []dataBodyType = { "Cabriolet", "Commercial", "Coupe", "Estate",
                "Hatchback", "Saloon", "SUV", "Other" };
        cmbBodyType = new JComboBox( dataBodyType );
        gbcPanelSearchHome.gridx = 1;
        gbcPanelSearchHome.gridy = 3;
        gbcPanelSearchHome.gridwidth = 1;
        gbcPanelSearchHome.gridheight = 1;
        gbcPanelSearchHome.fill = GridBagConstraints.BOTH;
        gbcPanelSearchHome.weightx = 1;
        gbcPanelSearchHome.weighty = 0;
        gbcPanelSearchHome.anchor = GridBagConstraints.NORTH;
        gbPanelSearchHome.setConstraints( cmbBodyType, gbcPanelSearchHome );
        pnPanelSearchHome.add( cmbBodyType );

        btSearchCar = new JButton( "Search"  );
        gbcPanelSearchHome.gridx = 2;
        gbcPanelSearchHome.gridy = 3;
        gbcPanelSearchHome.gridwidth = 2;
        gbcPanelSearchHome.gridheight = 1;
        gbcPanelSearchHome.fill = GridBagConstraints.BOTH;
        gbcPanelSearchHome.weightx = 0;
        gbcPanelSearchHome.weighty = 0;
        gbcPanelSearchHome.anchor = GridBagConstraints.NORTH;
        gbPanelSearchHome.setConstraints( btSearchCar, gbcPanelSearchHome );
        pnPanelSearchHome.add( btSearchCar );

        tfMake = new JTextField( );
        gbcPanelSearchHome.gridx = 1;
        gbcPanelSearchHome.gridy = 0;
        gbcPanelSearchHome.gridwidth = 1;
        gbcPanelSearchHome.gridheight = 1;
        gbcPanelSearchHome.fill = GridBagConstraints.BOTH;
        gbcPanelSearchHome.weightx = 1;
        gbcPanelSearchHome.weighty = 0;
        gbcPanelSearchHome.anchor = GridBagConstraints.NORTH;
        gbPanelSearchHome.setConstraints( tfMake, gbcPanelSearchHome );
        pnPanelSearchHome.add( tfMake );

        lbModel = new JLabel( "Model"  );
        gbcPanelSearchHome.gridx = 2;
        gbcPanelSearchHome.gridy = 0;
        gbcPanelSearchHome.gridwidth = 1;
        gbcPanelSearchHome.gridheight = 1;
        gbcPanelSearchHome.fill = GridBagConstraints.BOTH;
        gbcPanelSearchHome.weightx = 1;
        gbcPanelSearchHome.weighty = 1;
        gbcPanelSearchHome.anchor = GridBagConstraints.CENTER;
        gbPanelSearchHome.setConstraints( lbModel, gbcPanelSearchHome );
        pnPanelSearchHome.add( lbModel );

        lbMaxYear = new JLabel( "Max Year"  );
        gbcPanelSearchHome.gridx = 2;
        gbcPanelSearchHome.gridy = 1;
        gbcPanelSearchHome.gridwidth = 1;
        gbcPanelSearchHome.gridheight = 1;
        gbcPanelSearchHome.fill = GridBagConstraints.BOTH;
        gbcPanelSearchHome.weightx = 1;
        gbcPanelSearchHome.weighty = 1;
        gbcPanelSearchHome.anchor = GridBagConstraints.NORTH;
        gbPanelSearchHome.setConstraints( lbMaxYear, gbcPanelSearchHome );
        pnPanelSearchHome.add( lbMaxYear );

        lbMaxPrice = new JLabel( "Max Price"  );
        gbcPanelSearchHome.gridx = 2;
        gbcPanelSearchHome.gridy = 2;
        gbcPanelSearchHome.gridwidth = 1;
        gbcPanelSearchHome.gridheight = 1;
        gbcPanelSearchHome.fill = GridBagConstraints.BOTH;
        gbcPanelSearchHome.weightx = 1;
        gbcPanelSearchHome.weighty = 1;
        gbcPanelSearchHome.anchor = GridBagConstraints.NORTH;
        gbPanelSearchHome.setConstraints( lbMaxPrice, gbcPanelSearchHome );
        pnPanelSearchHome.add( lbMaxPrice );

        lbMake = new JLabel( "Make"  );
        gbcPanelSearchHome.gridx = 0;
        gbcPanelSearchHome.gridy = 0;
        gbcPanelSearchHome.gridwidth = 1;
        gbcPanelSearchHome.gridheight = 1;
        gbcPanelSearchHome.fill = GridBagConstraints.BOTH;
        gbcPanelSearchHome.weightx = 1;
        gbcPanelSearchHome.weighty = 1;
        gbcPanelSearchHome.anchor = GridBagConstraints.CENTER;
        gbPanelSearchHome.setConstraints( lbMake, gbcPanelSearchHome );
        pnPanelSearchHome.add( lbMake );

        lbMinYear = new JLabel( "Min Year"  );
        gbcPanelSearchHome.gridx = 0;
        gbcPanelSearchHome.gridy = 1;
        gbcPanelSearchHome.gridwidth = 1;
        gbcPanelSearchHome.gridheight = 1;
        gbcPanelSearchHome.fill = GridBagConstraints.BOTH;
        gbcPanelSearchHome.weightx = 1;
        gbcPanelSearchHome.weighty = 1;
        gbcPanelSearchHome.anchor = GridBagConstraints.CENTER;
        gbPanelSearchHome.setConstraints( lbMinYear, gbcPanelSearchHome );
        pnPanelSearchHome.add( lbMinYear );

        lbMinPrice = new JLabel( "Min Price"  );
        gbcPanelSearchHome.gridx = 0;
        gbcPanelSearchHome.gridy = 2;
        gbcPanelSearchHome.gridwidth = 1;
        gbcPanelSearchHome.gridheight = 1;
        gbcPanelSearchHome.fill = GridBagConstraints.BOTH;
        gbcPanelSearchHome.weightx = 1;
        gbcPanelSearchHome.weighty = 1;
        gbcPanelSearchHome.anchor = GridBagConstraints.NORTH;
        gbPanelSearchHome.setConstraints( lbMinPrice, gbcPanelSearchHome );
        pnPanelSearchHome.add( lbMinPrice );

        lbBodyType = new JLabel( "Body Type"  );
        gbcPanelSearchHome.gridx = 0;
        gbcPanelSearchHome.gridy = 3;
        gbcPanelSearchHome.gridwidth = 1;
        gbcPanelSearchHome.gridheight = 1;
        gbcPanelSearchHome.fill = GridBagConstraints.BOTH;
        gbcPanelSearchHome.weightx = 1;
        gbcPanelSearchHome.weighty = 1;
        gbcPanelSearchHome.anchor = GridBagConstraints.NORTH;
        gbPanelSearchHome.setConstraints( lbBodyType, gbcPanelSearchHome );
        pnPanelSearchHome.add( lbBodyType );


       /*//https://docs.oracle.com/javase/tutorial/uiswing/layout/group.html
        GroupLayout layoutHome = new GroupLayout(panelHome);
        panelHome.setLayout(layoutHome);
        layoutHome.setHorizontalGroup(
                layoutHome.createSequentialGroup()
                        .addGroup(layoutHome.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabelHome)
                                .addContainerGap(4, Short.MAX_VALUE))
        );

        layoutHome.setVerticalGroup(
                layoutHome.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layoutHome.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(jLabelHome)
                                .addContainerGap(5, Short.MAX_VALUE))
        );
*/
        panelMain.add(pnPanelSearchHome);
        //end home

        /*
        Customer
        */

/*
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
        //end customer
*/
        /*
        View Cars
        */
/*
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
*/
        /*
        AddSaleCar
        */
/*
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




        setTitle("Car System");
        setResizable(false);
        setVisible(true);
        setSize(900,700);

    }


    private void homeButtonActionPerformed(ActionEvent actionEvent) {
        panelMain.removeAll();
        panelMain.add(pnPanelSearchHome);
        panelMain.repaint();
        panelMain.revalidate();
    }
/*
    private void customerButtonActionPerformed(ActionEvent actionEvent) {
        panelMain.removeAll();
        panelMain.add(panelCustomer);
        panelMain.repaint();
        panelMain.revalidate();
    }
*/
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
