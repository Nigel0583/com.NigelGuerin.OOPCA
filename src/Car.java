public class Car {
    private String model;
    private String make;
    private String type;
    private double engineSize;
    private int year;
    private String Regno;
    private int emissions;
    private String transmission;
    private String fuel;

    public Car(){
        this("Unknown","Unknown","Unknown",0.0,0,
                "Unknown",0,"Unknown","Unknown");
    }

    public Car(String model, String make, String type, double engineSize, int year,
               String regno, int emissions, String transmission, String fuel) {
        this.model = model;
        this.make = make;
        this.type = type;
        this.engineSize = engineSize;
        this.year = year;
        Regno = regno;
        this.emissions = emissions;
        this.transmission = transmission;
        this.fuel = fuel;
    }

    @Override
    public String toString() {
        return "Make: " + make + '\n' +
                "Model: " + model + '\n' +
                "Type: " + type + '\n' +
                "Engine Size: " + engineSize +
                "Year: " + year + '\n' +
                "Registration: " + Regno + '\n' +
                "Emissions: " + emissions +
                "Transmission: " + transmission + '\n' +
                "Fuel: " + fuel;
    }

    public int getEmissions() {
        return emissions;
    }

    public void setEmissions(int emissions) {
        this.emissions = emissions;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
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

    public double getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
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


}
