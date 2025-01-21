import java.util.ArrayList; 
 
class BirthdayGreeting { 
  void findBirthday(ArrayList<Recipients> recipients,String todaydate,ArrayList<E_mail> sentemails) { 
   
    long noOfRecipients = recipients.size(); 
    SendMail sendWish  = new SendMail(); 
    CheckWhoHasBirthday iff  = new CheckWhoHasBirthday(); 
    checkWishesAreSent  ifff= new checkWishesAreSent(); 
     
    for(int i=0;i<noOfRecipients;i++) { 
       
      //if recipient is a Personal member check for birthday  
      //and greet him if he has the birthday today 
      if(recipients.get(i) instanceof Personal) { 
        Personal recipient  = (Personal) recipients.get(i); 
         
          if(iff.todayIsBirthday(recipient.getDOB(), todaydate)) {           
             
            E_mail email = new E_mail(recipient.getEmail(), "Greetings", "Hugs and love on your birthday.\n"+ "<Pavan Pasidu>", todaydate); 
            if(ifff.notsentWishes(sentemails,email)) { 
              sendWish.send(recipient.getEmail(),"Greetings","Hugs and love on your birthday.\n"+ "<Pavan Pasidu>"); 
              sendWish.saveDraft(sentemails, email);  //if he has birthday today and wish is sent store to an array 
            } 
          } 
          else {continue;} 
      } 
    //if recipient is a Office_friends member check for birthday  
    //and greet him if he has the birthday today 
      else if(recipients.get(i) instanceof Office_friends) { 
          Office_friends recipient  = (Office_friends) recipients.get(i); 
           
          if(iff.todayIsBirthday(recipient.getDOB(), todaydate)) {      
              E_mail email = new E_mail(recipient.getEmail(), "Greetings", "Wish you a Happy Birthday.\n" +"<Pavan Pasidu>", todaydate); 
              if(ifff.notsentWishes(sentemails,email)) {            
                sendWish.send(recipient.getEmail(),"Greetings","Wish you a Happy Birthday.\n" +"<Pavan Pasidu>"); 
                sendWish.saveDraft(sentemails, email);    //if he has birthday today and wish is sent store to an array 
              } 
          } 
          else {continue;} 
      } 
       
      else {continue;} 
       
    } 
  } 
 
}