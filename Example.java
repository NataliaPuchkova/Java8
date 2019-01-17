import java.util.*;
import java.util.stream.Collectors;

class Example {

 // Create set of object's fields from the list of objects
  public HashSet<String> getFormat(String time, ArrayList<Subscriptor> subs){
    return (HashSet<String> subs.strewam()
                                 .filter(x->x.getTime().equals(time))
                                 .map(y->y.getFormat())
                                 .collect(Collectors.toSet());
  
  } 
}
