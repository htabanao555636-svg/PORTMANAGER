package hamprii;
import java.util.ArrayDeque;
import java.util.Scanner;

public class PortManager {
    private ArrayDeque<Container> containerStack; // LIFO
    private ArrayDeque<Ship> shipQueue;           // FIFO
    private Scanner sc;

    // Constructor
    public PortManager() {
        containerStack = new ArrayDeque<>();
        shipQueue = new ArrayDeque<>();
        sc = new Scanner(System.in);
    }

    // Display menu
    public void start() {
        int choice;
        do {
            System.out.println("\n=== Port Container Management System ===");
            System.out.println("[1] Store container (push)");
            System.out.println("[2] View port containers");
            System.out.println("[3] Register arriving ship (enqueue)");
            System.out.println("[4] View waiting ships");
            System.out.println("[5] Load next ship (pop + poll)");
            System.out.println("[0] Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> storeContainer();
                case 2 -> viewContainers();
                case 3 -> registerShip();
                case 4 -> viewShips();
                case 5 -> loadNext();
                case 0 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    // [1] Store container
    private void storeContainer() {
        System.out.print("Enter container ID: ");
        String id = sc.nextLine();
        System.out.print("Enter description: ");
        String desc = sc.nextLine();
        System.out.print("Enter weight (kg): ");
        int weight = sc.nextInt();
        sc.nextLine();

        Container c = new Container(id, desc, weight);
        containerStack.push(c); // LIFO
        System.out.println("Stored: " + c);
    }

    // [2] View port containers
    private void viewContainers() {
        if (containerStack.isEmpty()) {
            System.out.println("No containers in port.");
        } else {
            System.out.println("\nTOP →");
            for (Container cont : containerStack) {
                System.out.println(cont);
            }
            System.out.println("← BOTTOM");
        }
    }

    // [3] Register arriving ship
    private void registerShip() {
        System.out.print("Enter ship name: ");
        String name = sc.nextLine();
        System.out.print("Enter captain's name: ");
        String captain = sc.nextLine();

        Ship s = new Ship(name, captain);
        shipQueue.add(s); // FIFO
        System.out.println("Registered: " + s);
    }

    // [4] View waiting ships
    private void viewShips() {
        if (shipQueue.isEmpty()) {
            System.out.println("No ships waiting.");
        } else {
            System.out.println("\nFRONT →");
            for (Ship ship : shipQueue) {
                System.out.println(ship);
            }
            System.out.println("← REAR");
        }
    }

    // [5] Load next ship
    private void loadNext() {
        if (containerStack.isEmpty()) {
            System.out.println("No containers to load!");
        } else if (shipQueue.isEmpty()) {
            System.out.println("No ships waiting!");
        } else {
            Container loadedContainer = containerStack.pop(); // remove top
            Ship targetShip = shipQueue.poll(); // remove front
            System.out.println("Loaded: " + loadedContainer + " → " + targetShip);
            System.out.println("Remaining containers: " + containerStack.size());
            System.out.println("Remaining ships waiting: " + shipQueue.size());
        }
    }
}

