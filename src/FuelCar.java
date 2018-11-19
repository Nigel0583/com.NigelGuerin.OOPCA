/**
 * Created by Nigel Guerin
 */
public class FuelCar extends Car {
    private int emissions;
    private String transmission;
    private String fuel;
    private double engineSize;

    @Override
    public String toString() {
        return "Emissions: " + emissions +  '\n' +
                "Transmission: " + transmission + '\n' +
                "Fuel: " + fuel + '\n' +
                "Engine Size: " + engineSize +"L";
    }

    public FuelCar(int emissions, String transmission, String fuel, double engineSize) {
        this.emissions = emissions;
        this.transmission = transmission;
        this.fuel = fuel;
        this.engineSize = engineSize;
    }

    public double getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
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
}
