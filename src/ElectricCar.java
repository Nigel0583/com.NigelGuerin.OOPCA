import java.io.Serializable;

/**
 * Created by Nigel Guerin
 */
public class ElectricCar extends Car implements Serializable {
    private int batterySize;
    private String Motor;


    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "BatterySize: " + batterySize + "kW/h\n" +
                "Motor: " + Motor ;
    }

    public ElectricCar(int batterySize, String motor) {
        this.batterySize = batterySize;
        Motor = motor;

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
        return Motor;
    }

    /**
     * Setter for property 'motor'.
     *
     * @param motor Value to set for property 'motor'.
     */
    public void setMotor(String motor) {
        Motor = motor;
    }


}
