import java.util.*; 
import java.io.*; 
 
class Recipients { 
  String name; 
  String email; 
  private static long count=0; 
  Recipients(String name,String email) { 
    this.name  = name; 
    this.email  = email; 
  } 
   
  //check each recipient whether they belong to Personal,Office_friend,Official  
  //then create an object for each recipient 
  boolean catagarize(String entry,File file,ArrayList<Recipients> recipients) { 
     
    boolean catagarized  = true; 
     
     try { 
      String[] catagory   = entry.split(":");   
      String[] details  = catagory[1].split(","); 
         
        //if recipient is Personal type create an object of that type 
        if(catagory[0].equals("Personal")){ 
             Personal people= new Personal(details[0],details[1],details[2],details[3]); 
             people.addtoArray(people,recipients); 
             count++; 
         } 
         
         //if recipient is Official type create an object of that type 
         else if(catagory[0].equals("Official")) { 
             Official people = new Official(details[0],details[1],details[2]); 
             people.addtoArray(people,recipients); 
             count++; 
         } 
         
        //if recipient is Office_friend type create an object of that type 
         else if(catagory[0].equals("Office_friend")){ 
             Office_friends people = new Office_friends(details[0],details[1],details[2],details[3]); 
             people.addtoArray(people,recipients); 
             count++; 
         } 
         
        //else it is a wrong input 
        //return categorized false 
         else { 
           catagarized  = false; 
           System.out.println("Wrong input"); 
           } 
     }catch(ArrayIndexOutOfBoundsException e) { 
       catagarized  = false; 
       System.out.println("Wrong Format\n"+"Correct formats are\n"+"\nOfficial: Name,gmail,Job title\n"+"Office_friend: Name,gmail,Job title,DOB(2000/02/04)\n"+"Personal: Name,<nickname>,gmail,DOB-2000/10/10\n"); 
     } 
     return catagarized; 
  }; 
   
  // add entries to a text file 
  void addRecipients(String entry,File file) { 
        try { 
         PrintWriter out = new PrintWriter(new FileWriter(file, true)); 
         out.append(entry+"\n"); 
         out.close(); 
       } 
       catch(IOException e) { 
         e.printStackTrace(); 
       } 
  } 
  long getCount() { 
    return count; 
  } 
} 