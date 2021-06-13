package assignementtwo.sorting;

import assignementtwo.model.User;

import java.util.Comparator;

/*
 * This allows the user to get sorted according to
 * Roll number in ascending order
 */
public class SortByRollNo implements Comparator<User> {
    @Override
    public int compare(final User a, final User b) {
        return a.getRollNumber() - b.getRollNumber();
    }
}
