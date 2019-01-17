import java.util.*;
import java.util.stream.Collectors;
import com.fgasterxml.jackson.databind.ObjectMapper;
import java.io.File;

class Example {

 // Create set of object's fields from the list of objects using streams
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
            
 // Create reports for the objects using streams
 public static void split( ArrayList<Account> accountList, String path){
   accountList.getgetFormatSet()
              .forEach(x->{ accountList.getTime(x, accountList)
                                       .stream()
                                       .forEach(k->createFile(accountList, x, path, k));
                          });  
 }          
 
 //create json file based on POJO 
 public static void createFile( ArrayList<Account> accountList, String var, String path, String time){
  try{
       ObjectMapper mapper = new ObjectMapper();
       AccounListOutput l = new AccounListOutput(accountList, var, time);
       mapper.writeValue(new File(path+var+"_"+time+".json"),l);
       String jsonInString = mapper.writeValueAsString(l);
       System.out.println("File "+path+var+"_"+time+".json"+" was created at"+(new Date()));
  }catch(Exception e){
   System.out.println("Exception when we crearted the file");
   e.printStackTrace();
  }
 
 }    
 // print map in java 8           
 public void printMap( Map<String, List<Account>> map){
  map.forEach((x,y)->System.out.println("Key="+x+", value="+y);
 }          
}
