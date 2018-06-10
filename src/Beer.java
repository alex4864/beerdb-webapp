public class Beer {
    private String name;
    private String type;
    private float size;
    private float price;
    public Beer(String name, String type, float size, float price) throws IllegalArgumentException {
        if(size < 0.0f || size > 4.0f) {
            throw new IllegalArgumentException("Beer size must be within reasonable bounds (between 0 and 4 L)");
        }
        if(price < 0.0f) {
            throw new IllegalArgumentException("Price cannot be negative");
        }

        this.name = name;
        this.type = type;
        this.size = size;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public float getSize() {
        return size;
    }
    public float getPrice() {
        return price;
    }
}
