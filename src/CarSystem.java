import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CarSystem extends JFrame implements ActionListener {
    private JPanel pnMain;
    private JPanel pnSidebar;
    private JButton btHome;
    private JButton btViewCars;
    private JButton btSellCar;
    private JButton btLogin;
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
    private JButton btSellcar;
    private Car car;
    ArrayList<Car> cars = new ArrayList<>();
    //------------------------------------------------------------------------------

    public CarSystem() {
        super("CarSystem");
        setIconImage(new ImageIcon(getClass().getResource("car.jpg")).getImage());

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
        //https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
        //Layout manager that allows you to position components relative to one another using constraints
        GridBagLayout gbSidebar = new GridBagLayout();
        GridBagConstraints gbcSidebar = new GridBagConstraints();
        pnSidebar.setLayout(gbSidebar);

        btHome = new JButton("Home");
        gbcSidebar.gridwidth = 1;
        gbcSidebar.gridheight = 1;
        gbcSidebar.fill = GridBagConstraints.BOTH;
        gbcSidebar.anchor = GridBagConstraints.NORTH;
        gbSidebar.setConstraints(btHome, gbcSidebar);
        pnSidebar.add(btHome);

        btViewCars = new JButton("View Cars");
        gbcSidebar.gridy = 1;
        gbcSidebar.gridwidth = 1;
        gbcSidebar.gridheight = 1;
        gbcSidebar.fill = GridBagConstraints.BOTH;
        gbcSidebar.weightx = 1;
        gbcSidebar.anchor = GridBagConstraints.NORTH;
        gbSidebar.setConstraints(btViewCars, gbcSidebar);
        pnSidebar.add(btViewCars);

        this.btSellCar = new JButton("Sell Car");
        this.btSellCar.addActionListener(this);
        gbcSidebar.gridy = 3;
        gbcSidebar.gridwidth = 1;
        gbcSidebar.gridheight = 1;
        gbcSidebar.fill = GridBagConstraints.BOTH;
        gbcSidebar.weightx = 1;
        gbcSidebar.anchor = GridBagConstraints.NORTH;
        gbSidebar.setConstraints(btSellCar, gbcSidebar);
        pnSidebar.add(this.btSellCar);

        btLogin = new JButton("Login");
        this.btLogin.setToolTipText("Login to sell a car");
        gbcSidebar.gridy = 2;
        gbcSidebar.gridwidth = 1;
        gbcSidebar.gridheight = 1;
        gbcSidebar.fill = GridBagConstraints.BOTH;
        gbcSidebar.weightx = 1;
        gbcSidebar.anchor = GridBagConstraints.NORTH;
        gbSidebar.setConstraints(btLogin, gbcSidebar);
        pnSidebar.add(btLogin);
        sppSplit.setLeftComponent(pnSidebar);

        /*
            Right panel
        */
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

        btSellcar = new JButton("Sell Car");
        gbcAd.gridx = 0;
        gbcAd.gridy = 3;
        gbcAd.gridwidth = 1;
        gbcAd.gridheight = 1;
        gbcAd.fill = GridBagConstraints.NONE;
        gbcAd.weightx = 1;
        gbcAd.weighty = 0;
        gbcAd.anchor = GridBagConstraints.NORTH;
        gbAd.setConstraints(btSellcar, gbcAd);
        pnAd.add(btSellcar);
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

    public void addCarSale() {
        String[] fuelTypeList = {"Fossil Fuel", "Electric"};
        String[] CarBodyTypes = {"Cabriolet","Commercial","Coupe","Estate","Hatchback","Saloon","SUV"};
        String make;

        boolean valid = false;
        while (!valid) {
            try {
                make = JOptionPane.showInputDialog("Enter the make of the car");
                if (make.length() > 0 && make.length() < 60) {
                    String model = JOptionPane.showInputDialog("Enter the model of the car");
                    if (model.length() > 0 && model.length() < 60) {
                        String regno = JOptionPane.showInputDialog("Enter the registration of the car");
                        String r = regno.toUpperCase();
                        //Regex validation from https://stackoverflow.com/questions/20070387/java-regex-pattern-matching-irish-car-registration
                         /*
                        A regular expression defines a search pattern for strings
                        The ^ Finds regex that must match at the beginning of the line.
                        The \d  Any digit, short for [0-9].
                        The ? Occurs no or one times, ? is short for {0,1}.
                        The {2,3} Must occur between 2 to 3.
                        */
                        if (r.matches("^(\\d{2,3}-?(KK|WW|C|CE|CN|CW|D|DL|G|KE|KY|L|LD|LH|LK|LM|LS|MH|MN|MO|OY|SO|RN|TN|TS|W|WD|WH|WX)-?\\d{1,4})$")) {
                            int year = Integer.parseInt(JOptionPane.showInputDialog("Enter the year of the car"));
                            if (year == (int) year) {
                                String type = (String) JOptionPane.showInputDialog(null, "Body type",
                                        "Body type", JOptionPane.QUESTION_MESSAGE, null, CarBodyTypes, CarBodyTypes[0]);

                                String fuelType = (String) JOptionPane.showInputDialog(null, "Fuel Type",
                                        "Fuel Type", JOptionPane.QUESTION_MESSAGE, null, fuelTypeList, fuelTypeList[0]);

                                if (fuelType.equals("Fossil Fuel")) {
                                    int emissions = Integer.parseInt(JOptionPane.showInputDialog("Enter the emissions of the car"));
                                    String transmission = JOptionPane.showInputDialog("Enter the transmission type of the car");
                                    String fuel = JOptionPane.showInputDialog("Enter the fuel type of the car");
                                    double engineSize = Double.parseDouble(JOptionPane.showInputDialog("Enter the engine size of the car"));
                                    this.car = new FuelCar(emissions,transmission,fuel,engineSize);
                                    this.car = new Car(make, model, type, regno, year);
                                    JOptionPane.showMessageDialog(null, car );

                                    valid = true;

                                } else if (fuelType.equals("Electric")) {
                                    int batterySize = Integer.parseInt(JOptionPane.showInputDialog("Enter the battery capacity of the car"));
                                    String motor = JOptionPane.showInputDialog("Enter the motor type of the car");
                                    this.car = new ElectricCar(batterySize,motor);
                                    this.car = new Car(make, model, type, regno, year);
                                    JOptionPane.showMessageDialog(null, car );

                                    valid = true;
                                }
                            } else {
                                year = Integer.parseInt(JOptionPane.showInputDialog("Year is invalid. Please re-enter"));
                            }


                        } else if (r.equals("")) {
                            regno = JOptionPane.showInputDialog("Registration must have a value. 11(1)-XX-1(1111) Please re-enter");
                            r = regno.toUpperCase();

                        } else {
                            regno = JOptionPane.showInputDialog("Invalid registration. 11(1)-XX-1(1111) Please re-enter");
                            r = regno.toUpperCase();
                        }
                    } else if (model.equals("")) {
                        model = JOptionPane.showInputDialog("Model must have a value. Please re-enter");
                    } else {
                        model = JOptionPane.showInputDialog("Invalid model. Please re-enter");
                    }
                } else if (make.equals("")) {
                    make = JOptionPane.showInputDialog("Make must have a value. Please re-enter");
                } else {
                    make = JOptionPane.showInputDialog("Invalid Make. Please re-enter");
                }
            } catch (NullPointerException n) {
                int choice = JOptionPane.showConfirmDialog(null, "Field must not be empty. Do you want to continue?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (choice == 0) {
                    make = JOptionPane.showInputDialog("Enter the make of the car");
                } else {
                    break;
                }
            }
        }
    }//end addCarSale

    @Override
    public void actionPerformed(ActionEvent e) {
        String menu = e.getActionCommand();
        if ((menu.equals("Sell Car")) || e.getSource() == btSellCar) {
            addCarSale();
        }
    }// end actionPerformed
} // end class CarSystem
