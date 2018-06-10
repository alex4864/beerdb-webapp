import java.util.regex.Pattern;

public class Customer {
    private String name;
    private String address;
    public Customer(String name, String address) throws IllegalArgumentException {
        if(!Pattern.matches("[a-zA-Z ]+", name)) {
            throw new IllegalArgumentException("Name can only contain uppercase, lowercase, and spaces.");
        }

        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
