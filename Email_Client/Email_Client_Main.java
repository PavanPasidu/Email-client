import java.util.*; 
import java.io.*; 
import java.time.LocalDate; 
import javax.mail.*; 
import java.time.format.DateTimeFormatter; 
 
class Email_Client_Main { 
 
  public static void main(String[] args) throws MessagingException, IOException { 
    File file = new File("clientList.txt"); 
    try { 
      file.createNewFile(); 
    } catch (IOException e1) { 
      e1.printStackTrace(); 
    } 
     
    DeserializeData takeArray  = new DeserializeData(); 
     
    //add deserialized data to the arrayList 
    ArrayList<E_mail> sentemails = takeArray.doDeSerialize(); 
    ArrayList<Recipients> recipients =new ArrayList<Recipients>(); 
     
    Scanner readit = new Scanner(file);  
    Recipients in =new Recipients(null,null); 
      //add recipient in clientList text file to an arrayList 
      while(readit.hasNextLine()){  
        String recipientListitem =readit.nextLine(); 
        in.catagarize(recipientListitem, file,recipients);  
      } 
       
    LocalDate DateObj = LocalDate.now();  
    DateTimeFormatter FormatDate =DateTimeFormatter.ofPattern("yyyy/MM/dd");  
    String todaydate =DateObj.format(FormatDate); 
     
    int option=9; 
     
    while(option!=0) { 
       
      try { 
        Scanner scanner = new Scanner(System.in); 
         
        // back to Main Menu button 
        if(option==9) { 
          System.out.println("Enter option type: \n"  
                  + "0 - Exit\n" 
                  + "1 - Adding a new recipient\n"  
                  + "2 - Sending an email\n" 
                  + "3 - Printing out all the recipients who have birthdays\n" 
                  + "4 - Printing out details of all the emails sent\n" 
                  + "5 - Printing out the number of recipient objects in the application\n" 
                + "9 - Back to Main Menu"); 
          option = scanner.nextInt(); 
        } 
         
        //check input command is correct one 
        else if(option>5 || option<0) { 
          System.out.println("Please input valid command\n"+"(Press 0 or 1 to 5)\n"); 
          option = scanner.nextInt(); 
        } 
         
        else { 
          switch (option) { 
          case 1: 
            // input format - Official: nimal,nimal@gmail.com,ceo 
            // Office_friend: kamal,kamal@gmail.com,clerk,2000/12/12 
            // Personal: sunil,<nick-name>,sunil@gmail.com,2000/10/10 
            boolean correcttInput  = false; 
       
            Scanner input = new Scanner(System.in); 
            String entry = input.nextLine(); 
             
            //create objects of recipients 
            Recipients catagary = new Recipients(null,null); 
            boolean Catagarized  =catagary.catagarize(entry, file,recipients); 
       
            //if correct entry was input  
            //save it 
            if(Catagarized) { 
            Recipients add = new Recipients(null,null); 
            add.addRecipients(entry, file); 
            correcttInput   = true; 
            } 
             
            //if wrong input was given  
            //take the recipient input again 
            else {option=1;} 
             
            //back to Main Menu 
            if(correcttInput) { 
                System.out.println("Please Enter 9 to go back to Main Menu or 0 to exit\n"); 
                option = scanner.nextInt(); 
            } 
            break; 
       
          case 2: 
            // input format - email, subject, content 
            // method to send email 
            boolean correctInput  = false;   
             
            Scanner input_2 = new Scanner(System.in); 
            String[] details = input_2.nextLine().split(","); 
       
            E_mail email = new E_mail(details[0], details[1], details[2], todaydate); 
       
            SendMail sent = new SendMail(); 
            correctInput  =  sent.send(details[0], details[1], details[2]); 
            sent.saveDraft(sentemails, email); 
             
            if(correctInput) { 
                System.out.println("Please Enter 9 to go back to Main Menu or 0 to exit\n"); 
                option = scanner.nextInt(); 
            } 
             
            break; 
         case 3: 
            //method to print all recipient who has birthday on given date 
            boolean correctBdayInput  = false; 
             
            Scanner input_3  = new Scanner(System.in); 
            String date     = input_3.nextLine(); 
            Birthday bday   = new Birthday(); 
            correctBdayInput  =  bday.findBirthday(date); 
             
            if(correctBdayInput) { 
                System.out.println("Please Enter 9 to go back to Main Menu or 0 to exit\n"); 
                option = scanner.nextInt(); 
            }else { 
               
              option  =  3; 
            } 
            break; 
       
          case 4: 
             
            //method to input details of sent emails 
            Scanner input_4 = new Scanner(System.in); 
            String day = input_4.nextLine(); 
            long numberofMails = sentemails.size(); 
       
            for (int i = 0; i < numberofMails; i++) { 
              if (sentemails.get(i).getDate().equals(day) ) { 
                System.out.println("Email: "+sentemails.get(i).getEmail() + "\n" +"Subject: "+ sentemails.get(i).getSubject()+"\n"); 
              } 
            } 
            if(true) { 
                System.out.println("Please Enter 9 to go back to Main Menu or 0 to exit\n"); 
                option = scanner.nextInt(); 
            } 
            // input format - yyyy/MM/dd (ex: 2018/09/17) 
            // code to print the details of all the emails sent on the input date 
            break; 
          case 5: 
            //print number of recipient object in application   
            Recipients get = new Recipients(null,null); 
            System.out.println(get.getCount()+"\n"); 
             
            if(true) { 
                System.out.println("Please Enter 9 to go back to Main Menu or 0 to exit\n"); 
                option = scanner.nextInt(); 
            } 
            // code to print the number of recipient objects in the application 
            break; 
       
          } 
        } 
      }catch(InputMismatchException e1) { 
        System.out.println("Please input valid command\n"+"(Press 0 or 1 to 5)\n"); 
      } 
} 
//send birthday greetings to every recipient  
BirthdayGreeting greet = new BirthdayGreeting(); 
greet.findBirthday(recipients,todaydate,sentemails); 
//serialize the data 
SerializeData sArray  = new SerializeData(); 
sArray.doSerialize(sentemails); 
// start email client 
// code to create objects for each recipient in clientList.txt 
// use necessary variables, methods and classes 
} 
}