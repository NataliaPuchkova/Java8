import java.util.*;
import java.util.stream.Collectors;

class Example {

 // Create set of object's fields from the list of objects
  public HashSet<String> getFormat(String time, ArrayList<Subscriptor> subs){
    return (HashSet<String> subs.stream()
                                 .filter(x->x.getTime().equals(time))
                                 .map(y->y.getFormat())
                                 .collect(Collectors.toSet());
  
  } 
  //Create set from subsets in stream          
  public HashSet<String>getTime (String var, ArrayList<Account> accountList){
   return (HashSet<String>) accountList.stream()
                                       .filter(x->x.getSomething().equals(var))
                                       .map(y->y.getSubscriptors()
                                                .stream()
                                                .map(z->z.getFormat())
                                                .collect(Collectors.toSet()))
                                       .flatMap(Set::stream)
                                       .collect(Collectors.toSet());
  }         
            
 // Create map from the list where key is one of the object's field           
  public Map<String, List<Account>> getAccounts(ArrayList<Account> accountList){
    return accountList.stream()
                      .collect(Collectors.groupBy(Account::getSomething));
  }          
}
