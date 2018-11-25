import java.io.Serializable;

/**
 * Created by Nigel Guerin
 */
public class Car implements Serializable {
    private String model;
    private String make;
    private String type;
    private String Regno;
    private int year;
    private double cost;


    /**
     * Instantiates a new Car.
     */
    public Car() {
        this("Unknown", "Unknown", "Unknown", "Unknown", 0, 0.0);
    }

    /**
     * Instantiates a new Car.
     *
     * @param make  the make
     * @param model the model
     * @param type  the type
     * @param regno the regno
     * @param year  the year
     * @param cost  the cost
     */
    public Car(String make, String model, String type, String regno, int year, double cost) {
        this.model = model;
        this.make = make;
        this.type = type;
        this.year = year;
        Regno = regno;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Make: " + make + '\n' +
                "Model: " + model + '\n' +
                "Type: " + type + '\n' +
                "Year: " + year + '\n' +
                "Registration: " + Regno + '\n' +
                "Cost: €" + cost + "\n\n";
    }

    /**
     * Gets model.
     *
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets model.
     *
     * @param model the model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets make.
     *
     * @return the make
     */
    public String getMake() {
        return make;
    }

    /**
     * Sets make.
     *
     * @param make the make
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }


    /**
     * Gets year.
     *
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets year.
     *
     * @param year the year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Gets regno.
     *
     * @return the regno
     */
    public String getRegno() {
        return Regno;
    }

    /**
     * Sets regno.
     *
     * @param regno the regno
     */
    public void setRegno(String regno) {
        Regno = regno;
    }

    /**
     * Gets cost.
     *
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * Sets cost.
     *
     * @param cost the cost
     */
    public void setCost(double cost) {
        this.cost = cost;
    }


}
