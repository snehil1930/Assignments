package assignementtwo.constant;

/*
 * printing message constants is here in the class
 *
 */
public class MessageConstants {
    /*
     * printing message to tell number of subjects
     */
    public static final String MESSAGE_1 =
            "Available Subjects are A,B,C,D,E,F ";

    /*
     * prompt to enter next input
     */
    public static final String MESSAGE_2 =
            "want to add subject ? if yes type 'y/Y' else type any character ";

    /*
     * This will ask user to input correct input in the avalaible subject
     */
    public static final String MESSAGE_3 =
            "Available Subjects are A,B,C,D,E,F only.Select Among these !!";

    /*
     * it will printed when entered subjects is less than 4
     */
    public static final String MESSAGE_4 = "enter at least 4 subjects";

    /*
     * name input
     */
    public static final String MESSAGE_5 = "Enter name";

    /*
     * roll number input by user
     */
    public static final String MESSAGE_6 = "Enter roll no";

    /*
     * age input by user
     */
    public static final String MESSAGE_7 = "Enter age";

    /*
     * address input by user
     */
    public static final String MESSAGE_8 = "Enter address";

    /*
     * message that data is save in file
     */
    public static final String MESSAGE_9 = "Saved to disk";


    /*
     * guiding input for the input of choice
     */
    public static final void openingMessage() {
        System.out.println(
                "Here is options number "
                        + "and task they perform on pressing them");
        System.out.println("1. Add user details");
        System.out.println(
                "2. Sort user details according to choice and order specified");
        System.out.println("3. Delete user details");
        System.out.println("4. Save user details");
        System.out.println("5. Exit");
    }

    /*
     * guiding user for the sorting input
     */
    public static final void choiceMessage() {
        System.out.println("1. Sort by Name");
        System.out.println("2. Sort by Age");
        System.out.println("3. Sort by RollNo.");
        System.out.println("4. Sort by Address");
    }


}
