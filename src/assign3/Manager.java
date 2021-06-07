package assign3;

import java.util.ArrayList;
import java.util.Scanner;
import assign3.Exception.InvalidInput;
/*
 * all the operations of user entry is controlled from here
 */

public class Manager {

    /*
     * Input stream for inputting the objects
     */
    private final Scanner scan = new Scanner(System.in);

    /*
     * Object made of class function for calling different method
     */
    private final Graph graph = new Graph();


    public Manager() {
//        constructor is kept intentionally blank
    }

    /*
     * operations users can perform on the graph
     */
    private void showOptions() {
        System.out.println("Here is a list of options to be chosen");
        System.out.println("1. Get immediate parent of the node");
        System.out.println("2. Get the immediate children of a node,");
        System.out.println("3. Get the ancestors of a node");
        System.out.println("4. Get the descendants of a node");
        System.out.println("5. Delete dependency from a tree");
        System.out.println("6. Delete a node from a tree");
        System.out.println("7. Add a new dependency to a tree");
        System.out.println("8. Add a new node to tree");
    }

    /*
     * display the results of array
     */
    private void print(final ArrayList<Integer> arrayList) {
        System.out.println(arrayList);
    }

    /*
     * this method get the list immediate parent of input node
     */
    private void immediateParent() {
        final int node = scan.nextInt();
        System.out.println(String.format("immediate parents of %d", node));
        print(graph.getImmediateParent(node));
    }

    /*
     * this method get the list immediate child of input node
     */
    private void immediatechild() {
        final int node = scan.nextInt();
        System.out.println(String.format("immediate child of %d", node));
        print(graph.getImmediateChild(node));
    }

    /*
     * this method find all the nodes that are subgraph of goven node
     */
    private void ancestors() {
        final int node = scan.nextInt();
        System.out.println(String.format("ancestors of %d", node));
        print(graph.getAllAncestors(node));
    }

    /*
     * This method represent the previously connected node in a graph
     */
    private void descendants() {
        final int node = scan.nextInt();
        System.out.println(String.format("descendants of %d", node));
        print(graph.getAllDescendendants(node));
    }

    /*
     * this method will remove the connection between the node if present
     */
    private void deleteDependency() {
        final int parid = scan.nextInt();
        final int childid = scan.nextInt();
        graph.deleteDependency(parid, childid);
    }

    /*
     * This method will delete the all the node attached to the input node
     */
    private void deleteNode() throws InvalidInput {
        final int nodeId = scan.nextInt();
        graph.deleteNode(nodeId);
    }

    /*
     * This method will add connection between the given node
     * and check whether added connection will not fom cycle
     */
    private void addDependency() {
        final int parid = scan.nextInt();
        final int childid = scan.nextInt();
        graph.addDependency(parid, childid);
    }

    /*
     * This will simply add new value to the graph
     */
    private void addNode() {
        final int nodeId = scan.nextInt();
        final String name = scan.next();
        final Node node = new Node(nodeId, name);
        graph.addNode(node.getId(), node);
    }

    /*
     * Controller function for chossing options
     */
    public void start() {

        //Initial input for feeding the graph
        final Node node1 = new Node(1, "cat");
        final Node node2 = new Node(2, "Tiger");
        graph.addNode(node1.getId(), node1);
        graph.addNode(node2.getId(), node1);
        graph.addDependency(node1.getId(), node2.getId());
        showOptions();
        int query = Constants.ZERO;
        while (query < Constants.MAX_LIMIT) {
            System.out.println("Do you Want enter more query.Press Y/N");
            final String answer = scan.next();
            if (!Constants.YES.equals(answer)) {
                break;
            }
            final int choice = scan.nextInt();
            if (choice < Constants.CHOICE_1 || choice > Constants.CHOICE_8) {
                throw new InvalidInput(Constants.PRINT1);
            }
            switch (choice) {
                case Constants.CHOICE_1:
                    immediateParent();
                    break;
                case Constants.CHOICE_2:
                    immediatechild();
                    break;
                case Constants.CHOICE_3:
                    ancestors();
                    break;
                case Constants.CHOICE_4:
                    descendants();
                    break;
                case Constants.CHOICE_5:
                    deleteDependency();
                    break;
                case Constants.CHOICE_6:
                    deleteNode();
                    break;
                case Constants.CHOICE_7:
                    addDependency();
                    break;
                case Constants.CHOICE_8:
                    addNode();
                    break;
                default:
                    System.out.println("Invalid input");
            }
            query++;
        }
    }
}
