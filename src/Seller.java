import java.io.Serializable;

/**
 * Created by Nigel Guerin
 */
public class Seller extends Customer  implements Serializable {
    private String phone;
    private String sellerType;

    @Override
    public String toString() {
        return "Seller" +
                "Phone: " + phone + '\n' +
                "Type of seller: " + sellerType;
    }

    /**
     * Instantiates a new Seller.
     *
     * @param phone      the phone
     * @param sellerType the seller type
     */
    public Seller(String phone, String sellerType) {
        this.phone = phone;
        this.sellerType = sellerType;
    }

    /**
     * Gets sellertype.
     *
     * @return the sellertype
     */
    public String getSellertype() {
        return sellerType;
    }

    /**
     * Sets sellertype.
     *
     * @param sellertype the sellertype
     */
    public void setSellertype(String sellertype) {
        this.sellerType = sellertype;
    }

    /**
     * Gets phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets phone.
     *
     * @param phone the phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

}
