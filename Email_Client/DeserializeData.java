import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import java.io.IOException; 
import java.io.ObjectInputStream; 
import java.util.ArrayList; 
class DeserializeData { 
ArrayList<E_mail> doDeSerialize() throws IOException { 
ArrayList<E_mail> email  = new ArrayList<E_mail>(); 
File serializeFile  =  new File("serializeClientList"); 

//check is serialized file is not null  
if (serializeFile.length()!=0) { 
try { 
    //if file is not empty de-serialize and add to arrayList 
    FileInputStream DserialF    = new FileInputStream("serializeClientList"); 
    ObjectInputStream obj_Dserial  = new ObjectInputStream(DserialF); 
    email  = (ArrayList<E_mail>) obj_Dserial.readObject(); 
    obj_Dserial.close(); 
    DserialF.close(); 
} catch (IOException ioe) { 
// TODO Auto-generated catch block 
ioe.printStackTrace(); 
}catch (ClassNotFoundException c)  
{ 
System.out.println("Class not found"); 
c.printStackTrace(); 
} 
} 
return email;    //return the arrayList 
} 
} 
