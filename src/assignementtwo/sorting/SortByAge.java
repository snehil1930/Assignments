package assignementtwo.sorting;

import assignementtwo.model.User;

import java.util.Comparator;

/*
 * This class sort the user according to the age
 */
public class SortByAge implements Comparator<User> {
    @Override
    public int compare(final User a,final User b) {
        return a.getAge() - b.getAge();
    }
}
