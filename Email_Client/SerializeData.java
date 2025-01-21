import java.io.FileOutputStream; 
import java.io.IOException; 
import java.io.ObjectOutputStream; 
import java.util.ArrayList; 
//serialize given data 
class SerializeData { 
    void doSerialize(ArrayList<E_mail> email) { 
        if (email.isEmpty()) { 
        System.out.println("No emails has been sent!!!!"); 
    } 
    else { 
        try { 
            FileOutputStream serialF    = new FileOutputStream("serializeClientList"); 
            ObjectOutputStream obj_serial  = new ObjectOutputStream(serialF); 
            obj_serial.writeObject(email); 
            obj_serial.close(); 
            serialF.close(); 
        } catch (IOException ioe) { 
            ioe.printStackTrace(); 
        } 
    } 
    } 
}