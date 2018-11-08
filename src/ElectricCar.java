public class ElectricCar extends Car {
    private String batterySize;
    private String Motor;
    private int NoOfMotors;

    @Override
    public String toString() {
        return "ElectricCar" +
                "BatterySize: " + batterySize + '\n' +
                "Motor: " + Motor + '\n' +
                "Number of motors: " + NoOfMotors ;
    }

    public ElectricCar(String batterySize, String motor, int noOfMotors) {
        this.batterySize = batterySize;
        Motor = motor;
        NoOfMotors = noOfMotors;
    }

    public String getBatterySize() {
        return batterySize;
    }

    public void setBatterySize(String batterySize) {
        this.batterySize = batterySize;
    }

    public String getMotor() {
        return Motor;
    }

    public void setMotor(String motor) {
        Motor = motor;
    }

    public int getNoOfMotors() {
        return NoOfMotors;
    }

    public void setNoOfMotors(int noOfMotors) {
        NoOfMotors = noOfMotors;
    }
}
