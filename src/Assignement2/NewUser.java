package Assignement2;
import java.util.*;
public class NewUser {
    public static User getNewUser()
    {
        final Scanner sc = new Scanner(System.in);
        String name ,address;
        int age,rollno;
       ArrayList<String> subj = new ArrayList<>();
        int max_sub=6;
        System.out.println("Enter name");
        name=sc.next();
        System.out.println("Enter roll no");
        rollno=sc.nextInt();
        if(rollno<0)
            throw new NumberFormatException();
        System.out.println("Enter age");
        age = sc.nextInt();
        if(age<0)
            throw new NumberFormatException();
        System.out.println("Enter address");
        address = sc.next();
        int count=0;
        System.out.println("Available Subjects are A,B,C,D,E,F ");
        ArrayList<String> availableSubjects= new ArrayList<>(Arrays.asList("A","B","C","D","E","F"));
        subj.add("A");
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
                System.out.println("enter at least 4 subjects");
            }
            else
                break;
            count++;
        }
//        System.out.println(name+age+rollno+address);
        User re=new User(name,age,rollno,address,subj);
        if(re==null)
            System.out.println("why?");
        return  re;
    }
}
