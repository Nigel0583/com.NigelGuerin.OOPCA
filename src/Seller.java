public class Seller extends Customer {
    private String phone;
    private String sellerType;

    @Override
    public String toString() {
        return "Seller" +
                "Name:'" + name + '\n' +
                "Email:" + email + '\n'+
                "Phone: " + phone + '\n' +
                "Type of seller: " + sellerType;
    }

    public Seller(String phone, String sellerType) {
        this.phone = phone;
        this.sellerType = sellerType;
    }

    public String getSellertype() {
        return sellerType;
    }

    public void setSellertype(String sellertype) {
        this.sellerType = sellertype;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
