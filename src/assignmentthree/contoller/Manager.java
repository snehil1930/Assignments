package assignmentthree.contoller;

import java.util.Scanner;

import assignmentthree.constants.ErrorConstants;
import assignmentthree.constants.ValueConstants;
import assignmentthree.exceptions.InvalidInput;
import assignmentthree.model.Graph;
import assignmentthree.model.Node;

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
     * this method get the list immediate parent of input node
     */
    private void immediateParent() {
        final var node = scan.nextInt();
        System.out.println(String.format("immediate parents of %d", node));
        System.out.println(graph.getImmediateParent(node));
    }

    /*
     * this method get the list immediate child of input node
     */
    private void immediateChild() {
        final var node = scan.nextInt();
        System.out.println(String.format("immediate child of %d", node));
        System.out.println(graph.getImmediateChild(node));
    }

    /*
     * this method find all the nodes that are subgraph of given node
     */
    private void findAncestors() {
        final var node = scan.nextInt();
        System.out.println(String.format("ancestors of %d", node));
        System.out.println(graph.getAllAncestors(node));
    }

    /*
     * This method represent the previously connected node in a graph
     */
    private void findDescendants() {
        final var node = scan.nextInt();
        System.out.println(String.format("descendants of %d", node));
        System.out.println(graph.getAllDescendendants(node));
    }

    /*
     * this method will remove the connection between the node if present
     */
    private void deleteDependency() {
        final var parentId = scan.nextInt();
        final var childId = scan.nextInt();
        graph.deleteDependency(parentId, childId);
    }

    /*
     * This method will delete the all the node attached to the input node
     */
    private void deleteNode() throws InvalidInput {
        final var nodeId = scan.nextInt();
        graph.deleteNode(nodeId);
    }

    /*
     * This method will add connection between the given node
     * and check whether added connection will not fom cycle
     */
    private void addDependency() {
        final var parentId = scan.nextInt();
        final var childId = scan.nextInt();
        graph.addDependency(parentId, childId);
    }

    /*
     * This will simply add new value to the graph
     */
    private void addNode() {
        final var nodeId = scan.nextInt();
        final var name = scan.next();
        final var node = new Node(nodeId, name);
        graph.addNode(node.getId(), node);
    }

    /*
     * Controller function for chossing options
     */
    public void start() {

        //Initial input for feeding the graph
        final var node1 = new Node(1, ValueConstants.CAT);
        final var node2 = new Node(2, ValueConstants.TIGER);
        graph.addNode(node1.getId(), node1);
        graph.addNode(node2.getId(), node1);
        graph.addDependency(node1.getId(), node2.getId());
        showOptions();
        var query = ValueConstants.ZERO;
        while (query < ValueConstants.MAX_LIMIT) {
            System.out.println("Do you Want enter more query.Press Y/N");
            final var answer = scan.next();
            if (!ValueConstants.YES.equals(answer)) {
                break;
            }
            final var choice = scan.nextInt();
            if (choice < ValueConstants.CHOICE_1 || choice > ValueConstants.CHOICE_8) {
                throw new InvalidInput(ErrorConstants.INVALID_INPUT);
            }
            switch (choice) {
                case ValueConstants.CHOICE_1:
                    immediateParent();
                    break;
                case ValueConstants.CHOICE_2:
                    immediateChild();
                    break;
                case ValueConstants.CHOICE_3:
                    findAncestors();
                    break;
                case ValueConstants.CHOICE_4:
                    findDescendants();
                    break;
                case ValueConstants.CHOICE_5:
                    deleteDependency();
                    break;
                case ValueConstants.CHOICE_6:
                    deleteNode();
                    break;
                case ValueConstants.CHOICE_7:
                    addDependency();
                    break;
                case ValueConstants.CHOICE_8:
                    addNode();
                    break;
                default:
                    System.out.println("Invalid input");
            }
            query++;
        }
    }
}
