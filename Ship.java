package hamprii;

public class Ship {
    private String name;
    private String captain;

    // Constructor to initialize fields
    public Ship(String name, String captain) {
        this.name = name;
        this.captain = captain;
    }

    // Returns a formatted string for display
    @Override
    public String toString() {
        return name + " | Capt. " + captain;
    }
}
