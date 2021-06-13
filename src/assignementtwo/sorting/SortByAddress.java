package assignementtwo.sorting;

import assignementtwo.model.User;

import java.util.Comparator;

/*
 * This allows the user to get sorted according to
 * address in ascending order
 */
public class SortByAddress implements Comparator<User> {
    @Override
    public int compare(final User a, final User b) {
        return a.getAddress().compareTo(b.getAddress());
    }
}
