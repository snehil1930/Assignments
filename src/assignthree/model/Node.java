package assignthree.model;

/*
 * This class is use to store unique Node Of tree
 */
public class Node {

    /*
     * unique id of the node
     */
    private final int id;

    /*
     * name of the node
     */
    private final String name;

    /*
     * paramterise constructor to intialise id and name
     * @param  id id of the node
     * @param name name of the node
     */
    public Node(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    /*
     * getter function of the id
     * @return id integer value of id
     */
    public int getId() {
        return id;
    }

    /*
     * getter of the name of the node
     * @return name of the node
     */
    public String getName() {
        return name;
    }
}
