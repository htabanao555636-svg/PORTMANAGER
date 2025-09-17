package hamprii;

public class Container {
    private String id;
    private String description;
    private int weight;

    // Constructor to initialize fields
    public Container(String id, String description, int weight) {
        this.id = id;
        this.description = description;
        this.weight = weight;
    }

    // Returns a formatted string for display
    @Override
    public String toString() {
        return id + " | " + description + " | " + weight + "kg";
    }
}
