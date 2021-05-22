package Assignement2;
import java.util.*;
public class NewUser {
    public static User getNewUser()
    {
        final Scanner sc = new Scanner(System.in);
        String name , address;
        int age,rollno;
        List<String> subj = new ArrayList<>();
        int max_sub=6;
        System.out.println("Enter name");
        name=sc.next();
        System.out.println("Enter roll no");
        rollno=sc.nextInt();
        System.out.println("Enter age");
        age = sc.nextInt();
        System.out.println("Enter address");
        address = sc.next();
        int count=0;
        System.out.println("Available Subjects are A,B,C,D,E,F ");
        ArrayList<String> availableSubjects= new ArrayList<>(Arrays.asList("A","B","C","D","E","F"));
        while(count<max_sub)
        {
            System.out.println("want to add subject ? if yes type 'y/Y' else type any character ");
            String st = sc.next();
            if(st.equalsIgnoreCase("y"))
            {
                String sub = sc.next();
                if(availableSubjects.contains(sub))
                    subj.add(sub);
                else {
                    System.out.println("Available Subjects are A,B,C,D,E,F only.Select Among these !!");
                    count=count-1;
                }
            }
            else if(count<4 && !(st.equalsIgnoreCase("y"))) {
                System.out.println("enter atleast 4 subjects");
            }
            else
                break;
            count++;
        }
        return  new User(name,age,rollno,address,subj);
    }
}
