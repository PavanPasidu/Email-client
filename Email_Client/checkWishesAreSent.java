import java.util.ArrayList; 
class checkWishesAreSent { 
//check if the wishes are already sent once 
boolean notsentWishes(ArrayList<E_mail> sentemails,E_mail email) { 
    int sizetoItr=sentemails.size(); 
    for(int i=0;i<sizetoItr;i++) { 
        if(sentemails.get(i).getEmail().equals(email.getEmail()) &&  
            sentemails.get(i).getSubject().equals(email.getSubject()) &&  
            sentemails.get(i).getContent().equals(email.getContent()))  
        {return false;} 
    } 
    return true; 
    } 
}