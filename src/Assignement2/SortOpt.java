package Assignement2;

import java.util.*;
public class SortOpt {
    Set<User> us;
    int choice;
    int order;
    SortOpt(Set<User> us)
    {
        this.us=us;
    }
    private void showdetails()
    {
        final Scanner sc=new Scanner(System.in);
        try {
            System.out.println("1. Sort by Name");
            System.out.println("2. Sort by Age");
            System.out.println("3. Sort by RollNo.");
            System.out.println("4. Sort by Address");
            choice = Integer.parseInt(sc.nextLine());
            System.out.println("Please enter the order.Option are...");
            System.out.println("1.Ascending Order");
            System.out.println("2. Descending order");
            order = Integer.parseInt(sc.nextLine());
            if (order < 1 || order > 2 || choice < 1 || choice > 4)
                throw new Exception();
        } catch (Exception e) {
            System.out.println("Invalid choice entered !");
        }
    }

    public Set<User> getSorted()
    {
        showdetails();
        us.stream().sorted((a, b) -> {
            int result = 0;
            switch (choice) {
                case 1:
                    result = a.getName().compareTo(b.getName());
                    break;
                case 2:
                    result = a.getRollNumber() - b.getRollNumber();
                    break;
                case 3:
                    result = a.getAge() - b.getAge();
                    break;
                case 4:
                    result = a.getAddress().compareTo(b.getAddress());
                    break;
            }
            if (order == 2) result = -result;
            return result;
        }).forEach(System.out::println);
        return us;

    }
}
