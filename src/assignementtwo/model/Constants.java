package assignementtwo.model;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * This class stores all the literals used in project
 */
public class Constants {

    /*
     * put a check on the limit of options input
     */
    public static final int MAX_LIMIT = 100;

    /*
     * The choices the user are going to enter
     * in order to procced the process
     * each option is clearly defined at the
     * where it is use
     */
    public static final int CHOICE_1 = 1;
    public static final int CHOICE_2 = 2;
    public static final int CHOICE_3 = 3;
    public static final int CHOICE_4 = 4;
    public static final int CHOICE_5 = 5;

    /*
     * initialise zero values to the counter and other place
     */
    public static final int ZERO = 0;

    /*
     * courses the user can select for the study
     */
    public static final ArrayList<String> AVAILABLE_SUBJECTS = new ArrayList<>(
            Arrays.asList("A", "B", "C", "D", "E", "F"));

    /*
     * yes symbolise that user want to enter more option
     */
    public static final String YES = "Y";


}
