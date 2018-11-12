public class Car  {
    private String model;
    private String make;
    private String type;
    private String Regno;
    private int year;


    public Car(){
        this("Unknown","Unknown","Unknown","Unknown",0);
    }

    public Car(String model, String make, String type,String regno,int year) {
        this.model = model;
        this.make = make;
        this.type = type;
        this.year = year;
        Regno = regno;

    }

    @Override
    public String toString() {
        return "Make: " + make + '\n' +
                "Model: " + model + '\n' +
                "Type: " + type + '\n' +
                "Year: " + year + '\n' +
                "Registration: " + Regno ;
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


}
