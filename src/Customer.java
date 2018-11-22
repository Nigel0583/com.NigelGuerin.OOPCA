import java.io.Serializable;

/**
 * Created by Nigel Guerin
 */

public class Customer implements Serializable {
    private String name;
    private String DOB;
    private String email;


    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "Name: " + name + '\n' +
                "DOB: " + DOB + '\n' +
                "Email: " + email ;
    }

    /** Constructs a new Customer. */
    public Customer(){
        this("Unknown","Unknown","Unknown");
    }
    public Customer(String name, String DOB, String email) {
        this.name = name;
        this.DOB = DOB;
        this.email = email;
    }

    /**
     * Getter for property 'name'.
     *
     * @return Value for property 'name'.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for property 'name'.
     *
     * @param name Value to set for property 'name'.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for property 'DOB'.
     *
     * @return Value for property 'DOB'.
     */
    public String getDOB() {
        return DOB;
    }

    /**
     * Setter for property 'DOB'.
     *
     * @param DOB Value to set for property 'DOB'.
     */
    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    /**
     * Getter for property 'email'.
     *
     * @return Value for property 'email'.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for property 'email'.
     *
     * @param email Value to set for property 'email'.
     */
    public void setEmail(String email) {
        this.email = email;
    }

}

