import java.io.Serializable;

/**
 * Created by Nigel Guerin
 */
public class ElectricCar extends Car implements Serializable {
    private int batterySize;
    private String Motor;


    @Override
    public String toString() {
        return "BatterySize: " + batterySize + "kW/h\n" +
                "Motor: " + Motor ;
    }

    public ElectricCar(int batterySize, String motor) {
        this.batterySize = batterySize;
        Motor = motor;

    }

    public int getBatterySize() {
        return batterySize;
    }

    public void setBatterySize(int batterySize) {
        this.batterySize = batterySize;
    }

    public String getMotor() {
        return Motor;
    }

    public void setMotor(String motor) {
        Motor = motor;
    }


}
