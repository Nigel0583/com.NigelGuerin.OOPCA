public class Customer {
    private String firstname;
    private String surname;
    private String DOB;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public Customer(String firstname, String surname, String DOB, String email) {
        this.firstname = firstname;
        this.surname = surname;
        this.DOB = DOB;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + firstname + surname+ '\n'+
                "Email: " +email;
    }

    public Customer(){
        this("Unknown","Unknown","Unknown","Unknown");
    }
}

