package assign3;

/*
 * This class is use to store unique Node Of tree
 */
public class Node {
    private final int id;
    private final String name;

    public Node(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
