import java.io.Serializable;

/**
 * Created by Nigel Guerin
 */
public class FuelCar extends Car implements Serializable {
    private int emissions;
    private String transmission;
    private String fuel;
    private double engineSize;

    @Override
    public String toString() {
        return "Emissions: " + emissions +  '\n' +
                "Transmission: " + transmission + '\n' +
                "Fuel: " + fuel + '\n' +
                "Engine Size: " + engineSize +"L \n\n";
    }

    /**
     * Instantiates a new Fuel car.
     *
     * @param emissions    the emissions
     * @param transmission the transmission
     * @param fuel         the fuel
     * @param engineSize   the engine size
     */
    public FuelCar(int emissions, String transmission, String fuel, double engineSize) {
        this.emissions = emissions;
        this.transmission = transmission;
        this.fuel = fuel;
        this.engineSize = engineSize;
    }

    /**
     * Gets engine size.
     *
     * @return the engine size
     */
    public double getEngineSize() {
        return engineSize;
    }

    /**
     * Sets engine size.
     *
     * @param engineSize the engine size
     */
    public void setEngineSize(double engineSize) {
        this.engineSize = engineSize;
    }

    /**
     * Gets emissions.
     *
     * @return the emissions
     */
    public int getEmissions() {
        return emissions;
    }

    /**
     * Sets emissions.
     *
     * @param emissions the emissions
     */
    public void setEmissions(int emissions) {
        this.emissions = emissions;
    }

    /**
     * Gets transmission.
     *
     * @return the transmission
     */
    public String getTransmission() {
        return transmission;
    }

    /**
     * Sets transmission.
     *
     * @param transmission the transmission
     */
    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    /**
     * Gets fuel.
     *
     * @return the fuel
     */
    public String getFuel() {
        return fuel;
    }

    /**
     * Sets fuel.
     *
     * @param fuel the fuel
     */
    public void setFuel(String fuel) {
        this.fuel = fuel;
    }
}
