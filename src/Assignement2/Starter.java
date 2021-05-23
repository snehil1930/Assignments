package Assignement2;

import java.util.*;
public class Starter {
    Set<User> us;

    Starter()
    {
        this.us=new StorgeClass().getUsers();
    }


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


    void sortingByChoice()
    {
        SortOpt sro=new SortOpt(us);
        us=sro.getSorted();
    }

    void deleteRecored()
    {
        Scanner sc=new Scanner(System.in);
        int searchRol=-3;
        try
        {
            searchRol=Integer.parseInt(sc.next());
        } catch(NumberFormatException e)
        {
            System.out.println("Invalid Input");
        }
        User rec=null;
        for(User it:us)
        {
            if(it.getRollNumber()==searchRol)
            {
                rec=it;
                break;
            }
        }
        if(rec!=null)
            us.remove(rec);
        else
            System.out.println("Record Not Present");
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
            else if(choice==2)
            {
                sortingByChoice();
            }

            else if(choice==3)
            {
                deleteRecored();
            }
            else if(choice==4)
            {
                StorgeClass stc=new StorgeClass();
                stc.saveChanges(us);
            }
            else if(choice==5)
            {
                new StorgeClass().saveChanges(us);
                System.exit(0);
            }

        }

    }
}
