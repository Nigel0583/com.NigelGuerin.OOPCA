import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
    private JPanel pnRightpanel;
    private JPanel pnSearchCars;
    private JLabel lbMake;
    private JTextField tfMake;
    private JTextField tfModel;
    private JComboBox cmbMinYear;
    private JComboBox cmbMaxYear;
    private JTextField tfMinPrice;
    private JTextField tfMaxPrice;
    private JButton btSearch;
    private JLabel lbModel;
    private JLabel lbMinYear;
    private JLabel lbMaxYear;
    private JLabel lbMinPrice;
    private JLabel lbMaxPrice;
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
    private JFrame frameG = new JFrame("Add Car sale");
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
    private JTextField tfEmmissionsG = new JTextField(10);
    private JTextField tfFuelG = new JTextField(10);
    private JTextField tfEngineG = new JTextField(10);
    private JTextField tfBatteryG = new JTextField(10);
    private JTextField tfMotorG = new JTextField(10);
    private JComboBox cmbCarBodyTypes;
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


       /* gbcSidebar.gridy = 3;
        gbcSidebar.gridwidth = 1;
        gbcSidebar.gridheight = 1;
        gbcSidebar.fill = GridBagConstraints.BOTH;
        gbcSidebar.weightx = 1;
        gbcSidebar.anchor = GridBagConstraints.NORTH;
        gbSidebar.setConstraints(btSellCar, gbcSidebar);
        pnSidebar.add(this.btSellCar);*/

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

        String[] dataMinYear = {"2000", "2001", "2002", "2003", "2004", "2005", "2006",
                "2007", "2008", "2009", "2010", "2011", "2012", "131",
                "132", "141", "142", "151", "152", "161", "162", "171",
                "172", "181", "182"};
        cmbMinYear = new JComboBox(dataMinYear);
        gbcSearchCars.gridx = 1;
        gbcSearchCars.gridy = 2;
        gbcSearchCars.gridwidth = 1;
        gbcSearchCars.gridheight = 1;
        gbcSearchCars.fill = GridBagConstraints.BOTH;
        gbcSearchCars.weightx = 1;
        gbcSearchCars.anchor = GridBagConstraints.NORTH;
        gbSearchCars.setConstraints(cmbMinYear, gbcSearchCars);
        pnSearchCars.add(cmbMinYear);

        String[] dataMaxYear = {"182", "181", "172", "171", "162", "161", "152", "151",
                "142", "141", "132", "131", "2012", "2011", "2010",
                "2009", "2008", "2007", "2006", "2005", "2004", "2003",
                "2002", "2001", "2000"};
        cmbMaxYear = new JComboBox(dataMaxYear);
        gbcSearchCars.gridx = 1;
        gbcSearchCars.gridy = 3;
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

        tfMaxPrice = new JTextField();
        gbcSearchCars.gridx = 1;
        gbcSearchCars.gridy = 5;
        gbcSearchCars.gridwidth = 1;
        gbcSearchCars.gridheight = 1;
        gbcSearchCars.fill = GridBagConstraints.BOTH;
        gbcSearchCars.weightx = 1;
        gbcSearchCars.anchor = GridBagConstraints.NORTH;
        gbSearchCars.setConstraints(tfMaxPrice, gbcSearchCars);
        pnSearchCars.add(tfMaxPrice);

        btSearch = new JButton("Search");
        gbcSearchCars.gridx = 1;
        gbcSearchCars.gridy = 6;
        gbcSearchCars.gridwidth = 1;
        gbcSearchCars.gridheight = 1;
        gbcSearchCars.fill = GridBagConstraints.BOTH;
        gbcSearchCars.weightx = 1;
        gbcSearchCars.anchor = GridBagConstraints.NORTH;
        gbSearchCars.setConstraints(btSearch, gbcSearchCars);
        pnSearchCars.add(btSearch);

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

        lbMinYear = new JLabel("Min Year");
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

        lbMaxYear = new JLabel("Max Year");
        gbcSearchCars.gridx = 0;
        gbcSearchCars.gridy = 3;
        gbcSearchCars.gridwidth = 1;
        gbcSearchCars.gridheight = 1;
        gbcSearchCars.fill = GridBagConstraints.BOTH;
        gbcSearchCars.weightx = 1;
        gbcSearchCars.weighty = 1;
        gbcSearchCars.anchor = GridBagConstraints.NORTH;
        gbSearchCars.setConstraints(lbMaxYear, gbcSearchCars);
        pnSearchCars.add(lbMaxYear);

        lbMinPrice = new JLabel("Min Price");
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

        lbMaxPrice = new JLabel("Max Price");
        gbcSearchCars.gridx = 0;
        gbcSearchCars.gridy = 5;
        gbcSearchCars.gridwidth = 1;
        gbcSearchCars.gridheight = 1;
        gbcSearchCars.fill = GridBagConstraints.BOTH;
        gbcSearchCars.weightx = 1;
        gbcSearchCars.weighty = 1;
        gbcSearchCars.anchor = GridBagConstraints.NORTH;
        gbSearchCars.setConstraints(lbMaxPrice, gbcSearchCars);
        pnSearchCars.add(lbMaxPrice);
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
        boolean valid = false;

        while (!valid) {
            try {
                String name = JOptionPane.showInputDialog("Enter your name");
                //Regex for name from https://www.regextester.com/93648
                if (name.matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")) {
                    String DOB = JOptionPane.showInputDialog("Enter your date of birth");
                    //Regex for DOB https://stackoverflow.com/questions/15491894/regex-to-validate-date-format-dd-mm-yyyy
                    if (DOB.matches("^(?:(?:31([/\\-.])(?:0?[13578]|1[02]))\\1|(?:(?:29|30)([/\\-.])(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^" +
                            "(?:29([/\\-.])0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^" +
                            "(?:0?[1-9]|1\\d|2[0-8])([/\\-.])(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$")) {
                        String email = JOptionPane.showInputDialog("Please enter your email");
                        //Regex for email https://emailregex.com/
                        if (email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:" +
                                "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}" +
                                "(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\" +
                                "[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])")) {
                            String type = (String) JOptionPane.showInputDialog(null, "Customer type",
                                    "Customer type", JOptionPane.QUESTION_MESSAGE, null, customerTypeList, customerTypeList[0]);
                            if (type.equals("Seller")) {
                                String sellerType = JOptionPane.showInputDialog("Enter seller type");
                                String phone = JOptionPane.showInputDialog("Enter phone number");
                                //Regex for phone  from  https://stackoverflow.com/questions/30347086/regex-for-english-and-irish-phone-numbers
                                if (phone.matches("^\\+(353|44)(\\s*\\d){9,12}$")) {
                                    this.customer = new Customer(name, DOB, email);
                                    this.seller = new Seller(phone, sellerType);
                                    JOptionPane.showMessageDialog(null, customers + "\n" + seller);
                                    ObjectOutputStream oosCustomer = new ObjectOutputStream(new FileOutputStream("customer.dat"));
                                    oosCustomer.writeObject(this.customer);
                                    oosCustomer.close();
                                    ObjectOutputStream oosSeller = new ObjectOutputStream(new FileOutputStream("seller.dat"));
                                    oosSeller.writeObject(this.seller);
                                    oosSeller.close();

                                    valid = true;
                                } else {
                                    phone = JOptionPane.showInputDialog("Invalid phone number. +353123456789 Please re-enter");
                                }


                            } else if (type.equals("Buyer")) {
                                this.customer = new Customer(name, DOB, email);

                                JOptionPane.showMessageDialog(null, customer);
                                ObjectOutputStream oosCustomer = new ObjectOutputStream(new FileOutputStream("customer.dat"));
                                oosCustomer.writeObject(this.customer);
                                oosCustomer.close();

                                valid = true;
                            }
                        } else {
                            email = JOptionPane.showInputDialog("Invalid email. Re-enter your date of email");
                        }
                    } else {
                        DOB = JOptionPane.showInputDialog("Invalid DOB. Re-enter your date of birth");
                    }
                } else {
                    name = JOptionPane.showInputDialog("Enter your name");
                }
            } catch (NullPointerException n) {
                int choice = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice == 0) {
                    String name = JOptionPane.showInputDialog("Enter your name");
                } else {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        this.sellers.add(this.seller);
        this.customers.add(this.customer);
    }


    /**
     * Add car sale.
     */
    public void addCarSale()  {

        btResetG.addActionListener(this);
        btAddG.addActionListener(this);



        String[] dataCarBodyTypes = {"Cabriolet", "Commercial", "Coupe", "Estate", "Hatchback", "Saloon", "SUV"};
        cmbCarBodyTypes = new JComboBox(dataCarBodyTypes);

        Container container = frameG.getContentPane();
        GroupLayout addSaleLayout = new GroupLayout(container);
        container.setLayout(addSaleLayout);

        try {
            frameG.setIconImage(new ImageIcon(getClass().getResource("car.jpg")).getImage());
        } catch (Exception x) {

        }
        frameG.setVisible(true);
        frameG.setLocationRelativeTo(null);


        addSaleLayout.setAutoCreateContainerGaps(true);
        addSaleLayout.setAutoCreateGaps(true);
        addSaleLayout.preferredLayoutSize(container);

       /* String[] dataFuelType = {"Combustion engine", "Electric"};
        cmbFuelType = new JComboBox(dataFuelType);*/

        addSaleLayout.setHorizontalGroup(
                addSaleLayout.createSequentialGroup()
                        .addGroup(addSaleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(lbMakeG)
                                .addComponent(lbModelG)
                                .addComponent(lbTypeG)
                                .addComponent(lbRegnoG)
                                .addComponent(lbCostG)
                                .addComponent(lbYearG)
                        )
                        .addGroup(addSaleLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(tfMakeG)
                                .addComponent(tfModelG)
                                .addComponent(cmbCarBodyTypes)
                                .addComponent(tfRegNoG)
                                .addComponent(tfCostG)
                                .addComponent(tfYearG)
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
                                .addComponent(btResetG)
                                .addComponent(btAddG)

                        )
        );
        frameG.setResizable(false);
        frameG.pack();
    } //end addCarSale


    public void addCar() {
        String make = tfMakeG.getText();
        String model  = tfModelG.getText();
        String type = Objects.requireNonNull(cmbCarBodyTypes.getSelectedItem()).toString();
        String regno = tfRegNoG.getText();
        String year = tfYearG.getText();
        int years = Integer.parseInt(year);
        String cost = tfCostG.getText();
        double costs = Integer.parseInt(cost);
        this.car = new Car(make,model,type,regno,years,costs);
        JOptionPane.showMessageDialog(null, car , "Added Car", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void resetbutton() {
        tfMakeG.setText("");
        tfModelG.setText("");
        tfRegNoG.setText("");
        tfCostG.setText("");
        tfYearG.setText("");
    }


    /**
     * View cars.
     */
    public void viewCars() {
        JTextArea taCars = new JTextArea();
        try {
            for (Car car1 : this.cars) {
                this.car = car1;
                taCars.append(this.car + "\n");

            }
            JOptionPane.showMessageDialog(null, taCars, "Cars for sale", JOptionPane.PLAIN_MESSAGE);

        } catch (NullPointerException n) {
            JOptionPane.showMessageDialog(null, "No cars found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String menu = e.getActionCommand();
        if ( btSellCar.getName().equals( ( (Component)e.getSource() ).getName())) {
            addCarSale();
        } else if (menu.equals("Register") || e.getSource() == btRegister) {
            addCustomer();
        } else if ((menu.equals("View car")) || e.getSource() == btViewCars) {
            viewCars();
        } else if ( e.getSource() == btAddG) {
            addCar();
        } else if (e.getSource() == btResetG) {
            resetbutton();
        }


    }// end actionPerformed
} // end class CarSystem
