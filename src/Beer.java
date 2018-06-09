public class Beer {
    private String name;
    private float size;
    private float percentage;
    public Beer(String name, float size, float percentage) throws IllegalArgumentException {
        if(percentage < 0.0f || percentage > 100.0f){
            throw new IllegalArgumentException("Percentage must be between 0.0 and 1.0");
        }

        this.name = name;
        this.size = size;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }
    public float getSize() {
        return size;
    }
    public float getPercentage() {
        return percentage;
    }
}
