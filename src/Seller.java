public class Seller extends Customer {
    private String reputation;
    private String address;
    private String postcode;
    private int phone;
    private String sellerType;

    @Override
    public String toString() {
        return "Seller" +
                "Reputation: " + reputation + '\n' +
                "Address: " + address + '\n' +
                "Postcode: " + postcode + '\n' +
                "Phone: " + phone + '\n' +
                "Type of seller: " + sellerType;
    }

    public Seller(String reputation, String address, String postcode, int phone, String sellerType) {
        this.reputation = reputation;
        this.address = address;
        this.postcode = postcode;
        this.phone = phone;
        this.sellerType = sellerType;
    }

    public String getSellertype() {
        return sellerType;
    }

    public void setSellertype(String sellertype) {
        this.sellerType = sellertype;
    }

    public String getReputation() {
        return reputation;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

}
