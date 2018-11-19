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



    public Car() {
        this("Unknown", "Unknown", "Unknown", "Unknown", 0,0.0);
    }

    public Car(String model, String make, String type, String regno, int year,double cost) {
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
                "Cost: €" +cost;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRegno() {
        return Regno;
    }

    public void setRegno(String regno) {
        Regno = regno;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }


}
