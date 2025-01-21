import java.io.*; 
import java.util.*; 
//import java.text.*; 
 
class Birthday { 
  //print out who has birthday on given date 
  boolean findBirthday(String date) { 
  CheckWhoHasBirthday iff  = new CheckWhoHasBirthday(); 
  boolean correctDate   = false; 
  boolean todayHasBday = true; 
   
    try { 
          File myObj = new File("clientList.txt"); 
          Scanner myReader = new Scanner(myObj); 
           
          //check and print out the birthday owner 
          while (myReader.hasNextLine()) { 
              String recipient = myReader.nextLine(); 
              String[] catagory=recipient.split(":"); 
               
                if(catagory[0].equalsIgnoreCase("Office_friend") || catagory[0].equalsIgnoreCase("Personal")) { 
                    String[] DOB = catagory[1].split(","); 
                    int last_index = DOB.length-1 ;                          
                     
                    todayHasBday  =   iff.todayIsBirthday(DOB[last_index], date); 
                    if(todayHasBday) { 
                      System.out.println(DOB[0]);                      
                    } 
                } 
                else {continue;} 
          } 
          correctDate  = iff.getCorrectDate(); 
           
          if(!todayHasBday && correctDate) {System.out.println("Today has No Birthdays.\n");} 
           
          //if given date is not in correct format give a warning 
          if(correctDate==false) { 
            System.out.println("Please enter date in yyyy/MM/dd\n"); 
            return false; 
            } 
    } 
    catch(FileNotFoundException e) { 
      System.out.println("An error occurred."); 
          e.printStackTrace(); 
    } 
    return true; 
     
  } 
} 