import java.io.*;
import java.net.*;
import java.nio.file.*;

public class AccountParser extends JSONParser{
  public static AccountList readJSONFileFromAPI () throws IOException{
    URL url = new URL("You URL request is here');
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    conn.connect();
    int responsecode = conn.getResponseCode();
    if (responseCode!=200){
      throw new RuntimeException ("Have an issue to get REST API info, HTTPResponseCode:"+responseCode);
    } else {
      try{
        jsonData = IOUtils.toByteArray(url.openStream());
       } catch(IOException e){
           System.out.println("Failed while reading bytes from..." );
       } finally{
        if (url!=null) url = null;
       }
      
    }

    
    AccountList req = objectMapper.readValue(jsonData, AccountList.class);
    return req;
    
  }
                      
 public static  AccountList readJSONFileFromFile (String path)  {
  jsonData = Files.readAllBytes(Paths.get(path));
   AccountList req = objectMapper.readValue(jsonData, AccountList.class);
    return req;
   
 }                 
}
