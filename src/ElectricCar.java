public class ElectricCar extends Car {
    private String batterySize;
    private String Motor;


    @Override
    public String toString() {
        return "ElectricCar" +
                "BatterySize: " + batterySize + '\n' +
                "Motor: " + Motor ;
    }

    public ElectricCar(String batterySize, String motor) {
        this.batterySize = batterySize;
        Motor = motor;

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


}
