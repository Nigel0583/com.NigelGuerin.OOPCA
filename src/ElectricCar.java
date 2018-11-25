import java.io.Serializable;

/**
 * Created by Nigel Guerin
 */
public class ElectricCar extends Car implements Serializable {
    private int batterySize;
    private String motor;


    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "BatterySize: " + batterySize + "kW/h\n" +
                "Motor: " + motor +"\n" ;
    }

    /**
     * Instantiates a new Electric car.
     *
     * @param batterySize the battery size
     * @param motor       the motor
     */
    public ElectricCar(int batterySize, String motor) {
        this.batterySize = batterySize;
        this.motor = motor;

    }

    /**
     * Getter for property 'batterySize'.
     *
     * @return Value for property 'batterySize'.
     */
    public int getBatterySize() {
        return batterySize;
    }

    /**
     * Setter for property 'batterySize'.
     *
     * @param batterySize Value to set for property 'batterySize'.
     */
    public void setBatterySize(int batterySize) {
        this.batterySize = batterySize;
    }

    /**
     * Getter for property 'motor'.
     *
     * @return Value for property 'motor'.
     */
    public String getMotor() {
        return motor;
    }

    /**
     * Setter for property 'motor'.
     *
     * @param motor Value to set for property 'motor'.
     */
    public void setMotor(String motor) {
      this.motor = motor;
    }


}
