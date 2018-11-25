import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Nigel Guerin
 */

public class CarSystem extends JFrame implements ActionListener {
    private JPanel pnMain;
    private JPanel pnSidebar;
    private JButton btViewCars;
    private JButton btSellCar;
    private JButton btRegister;
    private JButton btViewDetails;
    private JButton btDelete;
    private JPanel pnRightpanel;
    private JPanel pnSearchCars;
    private JLabel lbMake;
    private JTextField tfMake;
    private JTextField tfModel;
    private JComboBox cmbMaxYear;
    private JTextField tfMinPrice;
    private JButton btSearch;
    private JLabel lbModel;
    private JLabel lbMinYear;
    private JLabel lbMinPrice;
    private JPanel pnAd;
    private JLabel lbSellcar;
    private Car car;
    private ArrayList<Car> cars = new ArrayList<>();
    private FuelCar Fuelcar;
    private ArrayList<FuelCar> Fuelcars = new ArrayList<>();
    private ElectricCar Electriccar;
    private ArrayList<ElectricCar> ElectricCars = new ArrayList<>();
    private Customer customer;
    private ArrayList<Customer> customers = new ArrayList<>();
    private Seller seller;
    private ArrayList<Seller> sellers = new ArrayList<>();
    private JButton btResetG = new JButton("Reset");
    private JButton btAddG = new JButton("Sell Car");
    private JFrame frameF = new JFrame("Add Car sale");
    private JFrame frameE = new JFrame("Add Car sale");
    private JLabel lbMakeG = new JLabel("Make");
    private JLabel lbModelG = new JLabel("Model");
    private JLabel lbTypeG = new JLabel("Type");
    private JLabel lbRegnoG = new JLabel("RegNo");
    private JLabel lbCostG = new JLabel("Cost");
    private JLabel lbYearG = new JLabel("Year");
    private JLabel lbEmissions = new JLabel("Emissions");
    private JLabel lbTransmission = new JLabel("Transmission");
    private JLabel lbFuel = new JLabel("Fuel");
    private JLabel lbEngine = new JLabel("Engine size");
    private JLabel lbBattery = new JLabel("Battery Capacity");
    private JLabel lbMotor = new JLabel("Motor Type");
    private JTextField tfMakeG = new JTextField(10);
    private JTextField tfModelG = new JTextField(10);
    private JTextField tfRegNoG = new JTextField(10);
    private JTextField tfCostG = new JTextField(10);
    private JTextField tfYearG = new JTextField(10);
    private JTextField tfEmissionsG = new JTextField(10);
    private JTextField tfFuelG = new JTextField(10);
    private JTextField tfEngineG = new JTextField(10);
    private JTextField tfBatteryG = new JTextField(10);
    private JTextField tfMotorG = new JTextField(10);
    private JComboBox cmbCarBodyTypes;
    private JComboBox cmbTransmission;
    private JComboBox cmbFuel;
    private String fuelType;
    String motor = "";
    int battery = 0;
    int emissions = 0;
    double engine = 0;
    String make = "";
    int year = 0;
    String model = "";
    String type = "";
    String transmission = "";
    String fueltype = "";
    double cost = 0.0;
    String regno = "";
    String r;

    //------------------------------------------------------------------------------

    /**
     * Instantiates a new Car system.
     */
    public CarSystem() {
        super("CarSystem");
        try {
            setIconImage(new ImageIcon(getClass().getResource("car.jpg")).getImage());
        } catch (Exception x) {

        }

        pnMain = new JPanel();
        pnMain.setAlignmentX(1);
        pnMain.setAlignmentY(1);
        GridBagLayout gbMain = new GridBagLayout();
        GridBagConstraints gbcMain = new GridBagConstraints();
        pnMain.setLayout(gbMain);

        //Code is from https://stackoverflow.com/questions/7065309/jsplitpane-set-resizable-false
        //Divides menu panel and input panel
        JSplitPane sppSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT) {
            //Keeps split pane locked to one location
            private final int location = 100;

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
        };//end
        sppSplit.setForeground(new Color(0, 0, 0));


        pnSidebar = new JPanel();
        //Learned from https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
        //Layout manager that allows you to position components relative to one another using constraints
        GridBagLayout gbSidebar = new GridBagLayout();
        GridBagConstraints gbcSidebar = new GridBagConstraints();
        pnSidebar.setLayout(gbSidebar);


        this.btViewCars = new JButton("View Cars");
        this.btViewCars.addActionListener(this);
        gbcSidebar.gridy = 1;
        gbcSidebar.gridwidth = 1;
        gbcSidebar.gridheight = 1;
        gbcSidebar.fill = GridBagConstraints.BOTH;
        gbcSidebar.weightx = 1;
        gbcSidebar.anchor = GridBagConstraints.NORTH;
        gbSidebar.setConstraints(btViewCars, gbcSidebar);
        pnSidebar.add(this.btViewCars);


        this.btViewDetails = new JButton("View Details");
        this.btViewDetails.addActionListener(this);
        gbcSidebar.gridy = 3;
        gbcSidebar.gridwidth = 1;
        gbcSidebar.gridheight = 1;
        gbcSidebar.fill = GridBagConstraints.BOTH;
        gbcSidebar.weightx = 1;
        gbcSidebar.anchor = GridBagConstraints.NORTH;
        gbSidebar.setConstraints(btViewDetails, gbcSidebar);
        pnSidebar.add(this.btViewDetails);

        this.btRegister = new JButton("Add Details");
        this.btRegister.addActionListener(this);
        this.btRegister.setToolTipText("Add Details to sell a car");
        gbcSidebar.gridy = 2;
        gbcSidebar.gridwidth = 1;
        gbcSidebar.gridheight = 1;
        gbcSidebar.fill = GridBagConstraints.BOTH;
        gbcSidebar.weightx = 1;
        gbcSidebar.anchor = GridBagConstraints.NORTH;
        gbSidebar.setConstraints(btRegister, gbcSidebar);
        pnSidebar.add(this.btRegister);
        sppSplit.setLeftComponent(pnSidebar);

        this.btDelete = new JButton("Delete Details");
        this.btDelete.addActionListener(this);
        this.btDelete.setToolTipText("Delete details");
        gbcSidebar.gridy = 4;
        gbcSidebar.gridwidth = 1;
        gbcSidebar.gridheight = 1;
        gbcSidebar.fill = GridBagConstraints.BOTH;
        gbcSidebar.weightx = 1;
        gbcSidebar.anchor = GridBagConstraints.NORTH;
        gbSidebar.setConstraints(btDelete, gbcSidebar);
        pnSidebar.add(this.btDelete);
        sppSplit.setLeftComponent(pnSidebar);


        // Right panel

        pnRightpanel = new JPanel();
        GridBagLayout gbRightpanel = new GridBagLayout();
        GridBagConstraints gbcRightpanel = new GridBagConstraints();
        pnRightpanel.setLayout(gbRightpanel);


        pnSearchCars = new JPanel();
        pnSearchCars.setBorder(BorderFactory.createTitledBorder("Search For A Car"));
        GridBagLayout gbSearchCars = new GridBagLayout();
        GridBagConstraints gbcSearchCars = new GridBagConstraints();
        pnSearchCars.setLayout(gbSearchCars);


        lbMake = new JLabel("Make");
        gbcSearchCars.gridwidth = 1;
        gbcSearchCars.gridheight = 1;
        gbcSearchCars.fill = GridBagConstraints.BOTH;
        gbcSearchCars.weightx = 1;
        gbcSearchCars.weighty = 1;
        gbcSearchCars.anchor = GridBagConstraints.NORTH;
        gbSearchCars.setConstraints(lbMake, gbcSearchCars);
        pnSearchCars.add(lbMake);
        tfMake = new JTextField();
        gbcSearchCars.gridx = 1;
        gbcSearchCars.gridwidth = 1;
        gbcSearchCars.gridheight = 1;
        gbcSearchCars.fill = GridBagConstraints.BOTH;
        gbcSearchCars.weightx = 1;
        gbcSearchCars.anchor = GridBagConstraints.NORTH;
        gbSearchCars.setConstraints(tfMake, gbcSearchCars);
        pnSearchCars.add(tfMake);

        tfModel = new JTextField();
        gbcSearchCars.gridx = 1;
        gbcSearchCars.gridy = 1;
        gbcSearchCars.gridwidth = 1;
        gbcSearchCars.gridheight = 1;
        gbcSearchCars.fill = GridBagConstraints.BOTH;
        gbcSearchCars.weightx = 1;
        gbcSearchCars.anchor = GridBagConstraints.NORTH;
        gbSearchCars.setConstraints(tfModel, gbcSearchCars);
        pnSearchCars.add(tfModel);

        String[] dataMaxYear = {"2018", "2017", "2016", "2015", "2014",
                "2013", "2012", "2011", "2010", "2009", "2008", "2007",
                "2006", "2005", "2004", "2003", "2002", "2001", "2000"};
        cmbMaxYear = new JComboBox(dataMaxYear);
        gbcSearchCars.gridx = 1;
        gbcSearchCars.gridy = 2;
        gbcSearchCars.gridwidth = 1;
        gbcSearchCars.gridheight = 1;
        gbcSearchCars.fill = GridBagConstraints.BOTH;
        gbcSearchCars.weightx = 1;
        gbcSearchCars.anchor = GridBagConstraints.NORTH;
        gbSearchCars.setConstraints(cmbMaxYear, gbcSearchCars);
        pnSearchCars.add(cmbMaxYear);

        tfMinPrice = new JTextField();
        gbcSearchCars.gridx = 1;
        gbcSearchCars.gridy = 4;
        gbcSearchCars.gridwidth = 1;
        gbcSearchCars.gridheight = 1;
        gbcSearchCars.fill = GridBagConstraints.BOTH;
        gbcSearchCars.weightx = 1;
        gbcSearchCars.anchor = GridBagConstraints.NORTH;
        gbSearchCars.setConstraints(tfMinPrice, gbcSearchCars);
        pnSearchCars.add(tfMinPrice);

        this.btSearch = new JButton("Search");
        this.btSearch.addActionListener(this);
        gbcSearchCars.gridx = 1;
        gbcSearchCars.gridy = 6;
        gbcSearchCars.gridwidth = 1;
        gbcSearchCars.gridheight = 1;
        gbcSearchCars.fill = GridBagConstraints.BOTH;
        gbcSearchCars.weightx = 1;
        gbcSearchCars.anchor = GridBagConstraints.NORTH;
        gbSearchCars.setConstraints(btSearch, gbcSearchCars);
        pnSearchCars.add(this.btSearch);

        lbModel = new JLabel("Model");
        gbcSearchCars.gridx = 0;
        gbcSearchCars.gridy = 1;
        gbcSearchCars.gridwidth = 1;
        gbcSearchCars.gridheight = 1;
        gbcSearchCars.fill = GridBagConstraints.BOTH;
        gbcSearchCars.weightx = 1;
        gbcSearchCars.weighty = 1;
        gbcSearchCars.anchor = GridBagConstraints.NORTH;
        gbSearchCars.setConstraints(lbModel, gbcSearchCars);
        pnSearchCars.add(lbModel);

        lbMinYear = new JLabel(" Year");
        gbcSearchCars.gridx = 0;
        gbcSearchCars.gridy = 2;
        gbcSearchCars.gridwidth = 1;
        gbcSearchCars.gridheight = 1;
        gbcSearchCars.fill = GridBagConstraints.BOTH;
        gbcSearchCars.weightx = 1;
        gbcSearchCars.weighty = 1;
        gbcSearchCars.anchor = GridBagConstraints.NORTH;
        gbSearchCars.setConstraints(lbMinYear, gbcSearchCars);
        pnSearchCars.add(lbMinYear);

        lbMinPrice = new JLabel(" Price");
        gbcSearchCars.gridx = 0;
        gbcSearchCars.gridy = 4;
        gbcSearchCars.gridwidth = 1;
        gbcSearchCars.gridheight = 1;
        gbcSearchCars.fill = GridBagConstraints.BOTH;
        gbcSearchCars.weightx = 1;
        gbcSearchCars.weighty = 1;
        gbcSearchCars.anchor = GridBagConstraints.NORTH;
        gbSearchCars.setConstraints(lbMinPrice, gbcSearchCars);
        pnSearchCars.add(lbMinPrice);


        gbcRightpanel.gridx = 0;
        gbcRightpanel.gridy = 0;
        gbcRightpanel.gridwidth = 8;
        gbcRightpanel.gridheight = 4;
        gbcRightpanel.fill = GridBagConstraints.BOTH;
        gbcRightpanel.weightx = 1;
        gbcRightpanel.weighty = 0;
        gbcRightpanel.anchor = GridBagConstraints.NORTH;
        gbRightpanel.setConstraints(pnSearchCars, gbcRightpanel);
        pnRightpanel.add(pnSearchCars);

        pnAd = new JPanel();
        pnAd.setBorder(BorderFactory.createTitledBorder("Place Ad"));
        GridBagLayout gbAd = new GridBagLayout();
        GridBagConstraints gbcAd = new GridBagConstraints();
        pnAd.setLayout(gbAd);

        lbSellcar = new JLabel("Sell Your Car easily");
        gbcAd.gridx = 0;
        gbcAd.gridy = 0;
        gbcAd.gridwidth = 1;
        gbcAd.gridheight = 1;
        gbcAd.fill = GridBagConstraints.VERTICAL;
        gbcAd.weightx = 1;
        gbcAd.weighty = 1;
        gbcAd.anchor = GridBagConstraints.NORTH;
        gbAd.setConstraints(lbSellcar, gbcAd);
        pnAd.add(lbSellcar);

        this.btSellCar = new JButton("Sell Car");
        btSellCar.setName("Sell Car");
        this.btSellCar.addActionListener(this);
        gbcAd.gridx = 0;
        gbcAd.gridy = 3;
        gbcAd.gridwidth = 1;
        gbcAd.gridheight = 1;
        gbcAd.fill = GridBagConstraints.NONE;
        gbcAd.weightx = 1;
        gbcAd.weighty = 0;
        gbcAd.anchor = GridBagConstraints.NORTH;
        gbAd.setConstraints(btSellCar, gbcAd);
        pnAd.add(this.btSellCar);
        gbcRightpanel.gridx = 8;
        gbcRightpanel.gridy = 0;
        gbcRightpanel.gridwidth = 3;
        gbcRightpanel.gridheight = 4;
        gbcRightpanel.fill = GridBagConstraints.BOTH;
        gbcRightpanel.weightx = 1;
        gbcRightpanel.weighty = 0;
        gbcRightpanel.anchor = GridBagConstraints.NORTH;
        gbRightpanel.setConstraints(pnAd, gbcRightpanel);
        pnRightpanel.add(pnAd);
        sppSplit.setRightComponent(pnRightpanel);
        gbcMain.gridx = 0;
        gbcMain.gridy = 0;
        gbcMain.gridwidth = 1;
        gbcMain.gridheight = 1;
        gbcMain.fill = GridBagConstraints.BOTH;
        gbcMain.weightx = 1;
        gbcMain.weighty = 1;
        gbcMain.anchor = GridBagConstraints.NORTH;
        gbMain.setConstraints(sppSplit, gbcMain);
        pnMain.add(sppSplit);


        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setContentPane(pnMain);
        setSize(500, 300);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);


    } // end CarSystem()

    /**
     * Add customer.
     */
    public void addCustomer() {
        String[] customerTypeList = {"Seller", "Buyer"};

        try {

            String name = JOptionPane.showInputDialog("Enter your name");

            //Regex for name from https://www.regextester.com/93648
            if (!name.matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")) {
                name = JOptionPane.showInputDialog("Invalid. Please re-enter your name");
            }
            String DOB = JOptionPane.showInputDialog("Enter your date of birth");

            //Regex for DOB https://stackoverflow.com/questions/15491894/regex-to-validate-date-format-dd-mm-yyyy
            if (!DOB.matches("^(?:(?:31([/\\-.])(?:0?[13578]|1[02]))\\1|(?:(?:29|30)([/\\-.])(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^" +
                    "(?:29([/\\-.])0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^" +
                    "(?:0?[1-9]|1\\d|2[0-8])([/\\-.])(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$")) {
                DOB = JOptionPane.showInputDialog("Invalid DOB. NN-NN-NNNN Re-enter your date of birth");
            }
            String email = JOptionPane.showInputDialog("Enter your email");

            //Regex for email https://emailregex.com/
            if (!email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:" +
                    "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}" +
                    "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\" +
                    "[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])")) {
                email = JOptionPane.showInputDialog("Invalid email. Re-enter your date of email");
            }

            String type = (String) JOptionPane.showInputDialog(null, "Customer type",
                    "Customer type", JOptionPane.QUESTION_MESSAGE, null, customerTypeList, customerTypeList[0]);

            switch (type) {
                case "Seller":
                    String sellerType = JOptionPane.showInputDialog("Enter seller type");

                    if (!(sellerType.equals("Private") || !sellerType.equals("Dealership"))) {
                        sellerType = JOptionPane.showInputDialog(" Invalid. Re-enter seller type");
                    }

                    String phone = JOptionPane.showInputDialog("Enter phone number");
                    //Regex for phone  from  https://stackoverflow.com/questions/30347086/regex-for-english-and-irish-phone-numbers
                    if (!phone.matches("^\\+(353|44)(\\s*\\d){9,12}$")) {

                        phone = JOptionPane.showInputDialog("Invalid phone number. +353123456789 Please re-enter");

                    }

                    this.customer = new Customer(name, DOB, email);
                    this.seller = new Seller(phone, sellerType);

                    JOptionPane.showMessageDialog(null, customer + "\n" + seller);

                    ObjectOutputStream oosCustomer = new ObjectOutputStream(new FileOutputStream("customer.dat"));
                    oosCustomer.writeObject(this.customer);
                    oosCustomer.close();
                    ObjectOutputStream oosSeller = new ObjectOutputStream(new FileOutputStream("seller.dat"));
                    oosSeller.writeObject(this.seller);
                    oosSeller.close();

                    break;

                case "Buyer":
                    this.customer = new Customer(name, DOB, email);

                    JOptionPane.showMessageDialog(null, customer);
                    oosCustomer = new ObjectOutputStream(new FileOutputStream("customer.dat"));
                    oosCustomer.writeObject(this.customer);
                    oosCustomer.close();
                    break;

            }

        } catch (NullPointerException n) {
            int choice = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (choice == 0) {
                String name = JOptionPane.showInputDialog("Enter your name");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        this.sellers.add(this.seller);
        this.customers.add(this.customer);
    }


    /**
     * Add car sale.
     */
    public void addCarSale() {
        try {


            String[] fuelTypeList = {"Combustion engine", "Electric"};
            fuelType = (String) JOptionPane.showInputDialog(null, "Fuel Type",
                    "Fuel Type", JOptionPane.QUESTION_MESSAGE, null, fuelTypeList, fuelTypeList[0]);

            if (fuelType.equals("Combustion engine")) {
                choseFuel();
            }
            if (fuelType.equals("Electric")) {
                choseElectric();
            }
        } catch (NullPointerException n) {

        }
    } //end addCarSale

    private void choseFuel() {
        btResetG.addActionListener(this);
        btAddG.addActionListener(this);


        String[] dataCarBodyTypes = {"Cabriolet", "Commercial", "Coupe", "Estate", "Hatchback", "Saloon", "SUV"};
        cmbCarBodyTypes = new JComboBox(dataCarBodyTypes);

        String[] dataTansmission = {"Manual", "Automatic"};
        cmbTransmission = new JComboBox(dataTansmission);

        String[] dataFuel = {"Petrol", "Diesel", "Hybrid", "LPG"};
        cmbFuel = new JComboBox(dataFuel);

        Container container = frameF.getContentPane();
        GroupLayout addSaleLayout = new GroupLayout(container);
        container.setLayout(addSaleLayout);

        frameF.setVisible(true);
        frameF.setLocationRelativeTo(null);
        frameF.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        addSaleLayout.setHorizontalGroup(
                addSaleLayout.createSequentialGroup()
                        .addGroup(addSaleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(lbMakeG)
                                .addComponent(lbModelG)
                                .addComponent(lbTypeG)
                                .addComponent(lbRegnoG)
                                .addComponent(lbCostG)
                                .addComponent(lbYearG)
                                .addComponent(lbFuel)
                                .addComponent(lbTransmission)
                                .addComponent(lbEmissions)
                                .addComponent(lbEngine)
                        )
                        .addGroup(addSaleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(tfMakeG)
                                .addComponent(tfModelG)
                                .addComponent(cmbCarBodyTypes)
                                .addComponent(tfRegNoG)
                                .addComponent(tfCostG)
                                .addComponent(tfYearG)
                                .addComponent(cmbFuel)
                                .addComponent(cmbTransmission)
                                .addComponent(tfEmissionsG)
                                .addComponent(tfEngineG)
                                .addGroup(addSaleLayout.createSequentialGroup()
                                        .addComponent(btResetG)
                                        .addComponent(btAddG)

                                )
                        )
        );
        addSaleLayout.setVerticalGroup(
                addSaleLayout.createSequentialGroup()
                        .addGroup(addSaleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lbMakeG)
                                .addComponent(tfMakeG)
                        )
                        .addGroup(addSaleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lbModelG)
                                .addComponent(tfModelG)
                        )
                        .addGroup(addSaleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lbTypeG)
                                .addComponent(cmbCarBodyTypes)
                        )
                        .addGroup(addSaleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lbRegnoG)
                                .addComponent(tfRegNoG)
                        )
                        .addGroup(addSaleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lbCostG)
                                .addComponent(tfCostG)
                        )
                        .addGroup(addSaleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lbYearG)
                                .addComponent(tfYearG)
                        )
                        .addGroup(addSaleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lbFuel)
                                .addComponent(cmbFuel)
                        )
                        .addGroup(addSaleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lbTransmission)
                                .addComponent(cmbTransmission)
                        )
                        .addGroup(addSaleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lbEmissions)
                                .addComponent(tfEmissionsG)
                        )
                        .addGroup(addSaleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lbEngine)
                                .addComponent(tfEngineG)
                        )
                        .addGroup(addSaleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btResetG)
                                .addComponent(btAddG)

                        )
        );
        frameF.setResizable(false);
        frameF.pack();


    }

    private void choseElectric() {
        btResetG.addActionListener(this);
        btAddG.addActionListener(this);


        String[] dataCarBodyTypes = {"Cabriolet", "Commercial", "Coupe", "Estate", "Hatchback", "Saloon", "SUV"};
        cmbCarBodyTypes = new JComboBox(dataCarBodyTypes);


        Container container = frameE.getContentPane();
        GroupLayout addSaleLayout = new GroupLayout(container);
        container.setLayout(addSaleLayout);

        try {
            frameE.setIconImage(new ImageIcon(getClass().getResource("car.jpg")).getImage());
        } catch (Exception x) {

        }
        frameE.setVisible(true);
        frameE.setLocationRelativeTo(null);
        frameE.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        addSaleLayout.setAutoCreateContainerGaps(true);
        addSaleLayout.setAutoCreateGaps(true);
        addSaleLayout.preferredLayoutSize(container);
        addSaleLayout.setHorizontalGroup(
                addSaleLayout.createSequentialGroup()
                        .addGroup(addSaleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(lbMakeG)
                                .addComponent(lbModelG)
                                .addComponent(lbTypeG)
                                .addComponent(lbRegnoG)
                                .addComponent(lbCostG)
                                .addComponent(lbYearG)
                                .addComponent(lbBattery)
                                .addComponent(lbMotor)
                        )
                        .addGroup(addSaleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(tfMakeG)
                                .addComponent(tfModelG)
                                .addComponent(cmbCarBodyTypes)
                                .addComponent(tfRegNoG)
                                .addComponent(tfCostG)
                                .addComponent(tfYearG)
                                .addComponent(tfBatteryG)
                                .addComponent(tfMotorG)
                                .addGroup(addSaleLayout.createSequentialGroup()
                                        .addComponent(btResetG)
                                        .addComponent(btAddG)
                                )
                        )
        );
        addSaleLayout.setVerticalGroup(
                addSaleLayout.createSequentialGroup()
                        .addGroup(addSaleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lbMakeG)
                                .addComponent(tfMakeG)
                        )
                        .addGroup(addSaleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lbModelG)
                                .addComponent(tfModelG)
                        )
                        .addGroup(addSaleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lbTypeG)
                                .addComponent(cmbCarBodyTypes)
                        )
                        .addGroup(addSaleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lbRegnoG)
                                .addComponent(tfRegNoG)
                        )
                        .addGroup(addSaleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lbCostG)
                                .addComponent(tfCostG)
                        )
                        .addGroup(addSaleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lbYearG)
                                .addComponent(tfYearG)
                        )
                        .addGroup(addSaleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lbBattery)
                                .addComponent(tfBatteryG)
                        )
                        .addGroup(addSaleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lbMotor)
                                .addComponent(tfMotorG)
                        )
                        .addGroup(addSaleLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btResetG)
                                .addComponent(btAddG)

                        )
        );
        frameE.setResizable(false);
        frameE.pack();
    }

    /**
     * Display car details.
     *
     * @param c the c
     */
    public void displayCarDetails(Car c) {
        tfMakeG.setText(c.getMake());
        tfModelG.setText(c.getModel());
        tfRegNoG.setText(c.getRegno());
        tfCostG.setText(Double.toString(c.getCost()));
        tfYearG.setText(Integer.toString(c.getYear()));
    }

    /**
     * Display electric details.
     *
     * @param ec the ec
     */
    public void displayElectricDetails(ElectricCar ec) {
        tfMotorG.setText(ec.getMotor());
        tfBatteryG.setText(ec.getMotor());
    }

    /**
     * Display fuel details.
     *
     * @param fc the fc
     */
    public void displayFuelDetails(FuelCar fc) {
        tfEmissionsG.setText(Integer.toString(fc.getEmissions()));
        tfEngineG.setText(Double.toString(fc.getEngineSize()));

    }

    /**
     * Gets motor.
     *
     * @return the motor
     */
    public String getMotor() {
        return tfMotorG.getText();
    }

    /**
     * Gets battery.
     *
     * @return the battery
     */
    public String getBattery() {
        return tfBatteryG.getText();
    }

    /**
     * Gets emissions.
     *
     * @return the emissions
     */
    public String getEmissions() {
        return tfEmissionsG.getText();
    }

    /**
     * Gets engine.
     *
     * @return the engine
     */
    public String getEngine() {
        return tfEngineG.getText();
    }

    /**
     * Gets make.
     *
     * @return the make
     */
    public String getMake() {
        return tfMakeG.getText();
    }

    /**
     * Gets model.
     *
     * @return the model
     */
    public String getModel() {
        return tfModelG.getText();
    }

    /**
     * Gets regno.
     *
     * @return the regno
     */
    public String getRegno() {
        return tfRegNoG.getText();
    }

    /**
     * Gets cost.
     *
     * @return the cost
     */
    public String getCost() {
        return tfCostG.getText();
    }

    /**
     * Gets year.
     *
     * @return the year
     */
    public String getYear() {
        return tfYearG.getText();
    }

    /**
     * Add car.
     */
    public void addCar() {
        r = regno.toUpperCase();
        try {
            make = getMake().trim();
            model = getModel().trim();
            year = Integer.parseInt(getYear().trim());
            cost = Double.parseDouble(getCost().trim());
            regno = getRegno().trim();
            r = regno.toUpperCase();
            type = Objects.requireNonNull(cmbCarBodyTypes.getSelectedItem()).toString();

            if (validateString(make)) {
                //Regex validation adapted from https://stackoverflow.com/questions/20070387/java-regex-pattern-matching-irish-car-registration
                     /*
                        A regular expression defines a search pattern for strings
                        The ^ Finds regex that must match at the beginning of the line.
                        The \d  Any digit, short for [0-9].
                        The ? Occurs no or one times, ? is short for {0,1}.
                        The {2,3} Must occur between 2 to 3.
                        If a dollar sign ( $ ) is at the end of the entire regular expression, it matches the end of a line. If an entire regular expression is enclosed by a
                        caret and dollar sign ( ^like this$ ), it matches an entire line. So, to match all strings containing just one characters, use " ^.$ "
                        */
                if ((r.matches("^(\\d{2,3}-?(KK|WW|C|CE|CN|CW|D|DL|G|KE|KY|L|LD|LH|LK|LM|LS|MH|MN|MO|OY|SO|RN|TN|TS|W|WD|WH|WX)-?\\d{1,6})$"))) {
                    if (year >= 1900 && year <= 9999) {
                        if (cost >= 100) {

                            if (fuelType.equals("Electric")) {
                                motor = getMotor().trim();
                                battery = Integer.parseInt(getBattery().trim());
                                this.car = new Car(make, model, type, r, year, cost);
                                this.cars.add(this.car);
                                this.Electriccar = new ElectricCar(battery, motor);
                                this.ElectricCars.add(this.Electriccar);
                                try {
                                    ObjectOutputStream oosCar = new ObjectOutputStream(new FileOutputStream("car.dat"));
                                    oosCar.writeObject(cars);
                                    oosCar.close();
                                    ObjectOutputStream oosElectric = new ObjectOutputStream(new FileOutputStream("electric.dat"));
                                    oosElectric.writeObject(ElectricCars);
                                    oosElectric.close();
                                    frameE.repaint();
                                    frameE.revalidate();
                                    frameE.dispose();

                                    JOptionPane.showMessageDialog(null, "The car has been successfully added", "Added", JOptionPane.INFORMATION_MESSAGE);
                                } catch (IOException ioe) {
                                    JOptionPane.showMessageDialog(null, "An Error has occurred", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            if (fuelType.equals("Combustion engine")) {
                                emissions = Integer.parseInt(getEmissions().trim());
                                engine = Double.parseDouble((getEngine().trim()));
                                transmission = Objects.requireNonNull(cmbTransmission.getSelectedItem()).toString();
                                fueltype = Objects.requireNonNull(cmbFuel.getSelectedItem()).toString();
                                this.car = new Car(make, model, type, r, year, cost);
                                this.cars.add(this.car);
                                this.Fuelcar = new FuelCar(emissions, transmission, fueltype, engine);
                                this.Fuelcars.add(this.Fuelcar);

                                try {
                                    ObjectOutputStream oosCar = new ObjectOutputStream(new FileOutputStream("car.dat"));
                                    oosCar.writeObject(cars);
                                    oosCar.close();
                                    ObjectOutputStream oosFuelCar = new ObjectOutputStream(new FileOutputStream("fuel.dat"));
                                    oosFuelCar.writeObject(Fuelcars);
                                    oosFuelCar.close();
                                    frameF.repaint();
                                    frameF.revalidate();
                                    frameF.dispose();


                                    JOptionPane.showMessageDialog(null, "The car has been successfully added", "Added", JOptionPane.INFORMATION_MESSAGE);
                                } catch (IOException ioe) {
                                    JOptionPane.showMessageDialog(null, "An Error has occurred", "Error", JOptionPane.ERROR_MESSAGE);
                                }

                            }
                        }
                    } else {

                        JOptionPane.showMessageDialog(null, "Invalid Year. Please re-enter", "Invalid", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid registration. 11(1)-XX-1(1111) Please re-enter", "Invalid", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Invalid Make. Please re-enter", "Invalid", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(null, "An NumberFormatException Error has occurred", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validateString(String arg) {
        boolean valid = false;
        String[] split = arg.split(" ");

        for (String aSplit : split) {
            // This checks if the number of characters between a space is greater than 2
            valid = (aSplit.length() > 2);
            if (valid) {
                break;
            }
        }
        return valid;
    }

    /**
     * Reset button.
     */
    public void resetButton() {
        tfMakeG.setText("");
        tfModelG.setText("");
        tfRegNoG.setText("");
        tfCostG.setText("");
        tfYearG.setText("");
        tfEngineG.setText("");
        tfBatteryG.setText("");
        tfEmissionsG.setText("");
        tfMotorG.setText("");
        tfFuelG.setText("");
    }

    /**
     * View cars.
     */
    public void viewCars() {
        try {
            String[] CarTypesList = {"Combustion Engines", "Electric"};
            fuelType = (String) JOptionPane.showInputDialog(null, "Fuel Type",
                    "Fuel Type", JOptionPane.QUESTION_MESSAGE, null, CarTypesList, CarTypesList[0]);


            if (fuelType.equals("Combustion Engines")) {
                try {
                    ObjectInputStream oisCar = new ObjectInputStream(new FileInputStream("car.dat"));
                    ObjectInputStream oisCarFuel = new ObjectInputStream(new FileInputStream("fuel.dat"));
                    this.cars = (ArrayList) oisCar.readObject();
                    this.Fuelcars = (ArrayList) oisCarFuel.readObject();
                    JFrame frameC = new JFrame("Cars available");

                    frameC.setIconImage(new ImageIcon(getClass().getResource("car.jpg")).getImage());

                    frameC.setSize(200, 250);
                    frameC.setResizable(false);
                    JTextArea taCars = new JTextArea();
                    taCars.setSize(170, 220);
                    taCars.setLineWrap(true);
                    taCars.setEditable(false);
                    taCars.setVisible(true);
                    StringBuilder textCar = new StringBuilder();
                    if (this.Fuelcars.size() < 1) {
                        JOptionPane.showMessageDialog(null, "No cars added", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        for (Car car1 : this.cars) {
                            textCar.append(car1);
                        }
                        for (FuelCar car2 : this.Fuelcars) {
                            textCar.append(car2);
                        }
                        taCars.append(textCar.toString());
                        JScrollPane scView = new JScrollPane(taCars);
                        scView.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                        scView.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

                        frameC.setLocationRelativeTo(null);
                        frameC.setResizable(false);
                        frameC.add(scView);
                        frameC.setVisible(true);
                        cars.clear();

                    }

                } catch (IOException f) {
                    JOptionPane.showMessageDialog(null, "An Error has occurred. Unable to load file", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            if (fuelType.equals("Electric")) {
                try {
                    ObjectInputStream oisCar = new ObjectInputStream(new FileInputStream("car.dat"));
                    ObjectInputStream oisCarElectric = new ObjectInputStream(new FileInputStream("electric.dat"));
                    this.cars = (ArrayList) oisCar.readObject();
                    this.ElectricCars = (ArrayList) oisCarElectric.readObject();
                    JFrame frameC = new JFrame("Cars available");

                    frameC.setIconImage(new ImageIcon(getClass().getResource("car.jpg")).getImage());

                    frameC.setSize(200, 250);
                    frameC.setResizable(false);
                    JTextArea taCars = new JTextArea();
                    taCars.setSize(170, 220);
                    taCars.setLineWrap(true);
                    taCars.setEditable(false);
                    taCars.setVisible(true);
                    StringBuilder textCar = new StringBuilder();
                    if (this.ElectricCars.size() < 1) {
                        JOptionPane.showMessageDialog(null, "No cars added", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        for (Car car1 : this.cars) {
                            textCar.append(car1);

                        }
                        for (ElectricCar car3 : this.ElectricCars) {
                            textCar.append(car3);

                        }

                        taCars.append(textCar.toString());
                        JScrollPane scView = new JScrollPane(taCars);
                        scView.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                        scView.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

                        frameC.setLocationRelativeTo(null);
                        frameC.setResizable(false);
                        frameC.add(scView);
                        frameC.setVisible(true);
                        cars.clear();
                        ElectricCars.clear();

                    }


                } catch (IOException io) {
                    JOptionPane.showMessageDialog(null, "An Error has occurred. Unable to load file", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } catch (NullPointerException n) {

        }
    }//end View Cars

    /**
     * Search.
     */
    public void search() {
        String searchMake = tfMake.getText();
        String searchModel = tfModel.getText();
        int maxYear = Integer.parseInt(Objects.requireNonNull(cmbMaxYear.getSelectedItem()).toString());
        String minPrice = tfMinPrice.getText();
        double mnPrice = Double.parseDouble(minPrice);

        if (searchMake.equals(make) || searchMake.equals("")) {
            if (searchModel.equals(model) || searchModel.equals("")) {
                if (maxYear <= year) {
                    if (mnPrice <= cost) {
                        // JTextArea taSearch = new JTextArea();
                        // taSearch.append((Car) this.cars.toString());
                        JOptionPane.showMessageDialog(null, "bethbeth", "Seheh", JOptionPane.PLAIN_MESSAGE);

                    }

                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "No results", "No results", JOptionPane.PLAIN_MESSAGE);
        }

    }

    /**
     * View details.
     */
    public void viewDetails() {

        JTextArea jaCust = new JTextArea();
        StringBuilder txtCust = new StringBuilder();
        try {
            if (this.customers.size() < 1) {
                JOptionPane.showMessageDialog(null, "No Details added", "No results", JOptionPane.ERROR_MESSAGE);
            } else {
                for (Customer cust1 : this.customers) {
                    txtCust.append(cust1);
                    JOptionPane.showMessageDialog(null, txtCust, "Details", JOptionPane.PLAIN_MESSAGE);
                }
                jaCust.append(txtCust.toString());
            }

        } catch (NullPointerException n) {

        }
    }

    /**
     * Delete cust.
     */
    public void deleteCust() {
        JComboBox cmbdetails = new JComboBox();
        for (Customer c : this.customers) {
            cmbdetails.addItem(c.getName());
        }
        JOptionPane.showMessageDialog(null, cmbdetails, "Remove Details", JOptionPane.WARNING_MESSAGE);
        int details = cmbdetails.getSelectedIndex();
        this.customers.remove(details);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String menu = e.getActionCommand();
        if (btSellCar.getName().equals(((Component) e.getSource()).getName())) {
            addCarSale();
        } else if (menu.equals("Register") || e.getSource() == btRegister) {
            addCustomer();
        } else if (e.getSource() == btViewCars) {
            viewCars();
        } else if (e.getSource() == btAddG) {
            addCar();
        } else if (e.getSource() == btResetG) {
            resetButton();
        } else if (e.getSource() == btSearch) {
            search();
        } else if (e.getSource() == btViewDetails) {
            viewDetails();
        } else if (e.getSource() == btDelete) {
            deleteCust();
        }
    }// end actionPerformed

} // end class CarSystem

