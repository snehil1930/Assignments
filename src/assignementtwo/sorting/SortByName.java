package assignementtwo.sorting;

import assignementtwo.model.User;

import java.util.Comparator;

/*
 * This allows the user to get sorted according to
 * name in ascending order
 */
public class SortByName implements Comparator<User> {

    @Override
    public int compare(User a, User b) {
        return a.getName().compareTo(b.getName());
    }
}
