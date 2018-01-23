import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.*;

public class StreamExample1 {
    class Person{
    private String name;
    private int age;
    private boolean isMan;
    
    Person(String name, int age, boolean isMan){
        this.name = name;
        this.age = age;
        this.isMan = isMan;
    }
     boolean isMen(){return isMan;}
     String getName(){ return name;}
     int getAge(){ return age;}
}
    public void run(){
        List<Person> persons = Arrays.asList(
                new Person("Jack", 30, true),
                new Person("Nancy", 20, false),
                new Person("Peter", 40, true)
        );
        Person result1 = persons.stream()                        // Convert to steam
                .filter(x -> "Peter".equals(x.getName()))        // we want "Peter" only - check if Peter exists in the list
                .findAny()                                      // If 'findAny' then return found
                .orElse(null);                                  // If not found, return null
        if (result1!=null)
        System.out.println("1st part:"+result1.getName());     // will print only if we found it
         List<Person> result2 = persons.stream()                        // Convert to steam
                .filter(x ->  x.getAge()>20)        // we want oll people who older then 20
                .collect(Collectors.toList());      // convert to the new list

                System.out.println("2nd part:");
        result2.stream().map(item->item.getName()).forEach(System.out::println);
        //System.out.println(result1.getName()); 
    } 
    public static void main(String args[]) {
        
          StreamExample1 item = new StreamExample1();
          item.run();
           
    }
}
