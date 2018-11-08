public class UsedCar extends Car {
    private String NCT;
    private int mileage;
    private String problems;
    private String service;

    @Override
    public String toString() {
        return "UsedCar" +
                "NCT: " + NCT + '\n' +
                " Mileage: " + mileage + '\n' +
                "Problems: " + problems + '\n' +
                "Service Needed: " + service ;
    }

    public UsedCar(String NCT, int mileage, String problems, String service) {
        this.NCT = NCT;
        this.mileage = mileage;
        this.problems = problems;
        this.service = service;
    }

    public String getNCT() {
        return NCT;
    }

    public void setNCT(String NCT) {
        this.NCT = NCT;
    }

    public int getMilage() {
        return mileage;
    }

    public void setMilage(int mileage) {
        this.mileage = mileage;
    }

    public String getProblems() {
        return problems;
    }

    public void setProblems(String problems) {
        this.problems = problems;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
