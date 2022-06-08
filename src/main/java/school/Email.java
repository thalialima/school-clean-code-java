package school;

//VALUE OBJECT
public class Email {
    private String address;
    private final String regexPattern = "^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    public Email(String address) {
        if (!isValid(address)){
            throw new IllegalArgumentException("This email is not valid!");
        }
        this.address = address;
    }



    public String getAddress() {
        return address;
    }

    private boolean isValid(String address) {
        return (address != null && address.matches(regexPattern));
    }
}
