public class Customer {
    private String name;
    private String DOB;
    private String email;

    @Override
    public String toString() {
        return "Name='" + name + '\n' +
                "DOB" + DOB + '\n' +
                "Email" + email ;
    }

    public Customer(){
        this("Unknown","Unknown","Unknown");
    }
    public Customer(String name, String DOB, String email) {
        this.name = name;
        this.DOB = DOB;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

