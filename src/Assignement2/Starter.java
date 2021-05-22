package Assignement2;

import java.util.*;
public class Starter {
    Set<User> us;


    int showOptions()
    {
        System.out.println("Here is options number and task they perform on pressing them");
        System.out.println("1. Add user details");
        System.out.println("2. Display user details");
        System.out.println("3. Delete user details");
        System.out.println("4. Save user details");
        System.out.println("5. Exit");
        try
        {
            Scanner sc=new Scanner(System.in);
            return sc.nextInt();
        }catch (NumberFormatException e)
        {
            return 5;
        }
    }


    void addUser()
    {
        try {
            us.add(NewUser.getNewUser());
        } catch (Exception e) {
            System.out.println("Invalid Details entered : " + e.getMessage());
        }
    }


    void menu()
    {
        int count=0;
        while(count<=1000)
        {
            count++;
            int choice=showOptions();
            if(choice==1)
            {
                addUser();
            }

        }

    }
}
