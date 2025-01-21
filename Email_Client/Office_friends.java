import java.util.*; 
import java.io.*; 

//create an Office_friends object 
//Office_friend: kamal,kamal@gmail.com,clerk,2000/12/12 
class Office_friends extends Recipients{ 
    private String name; 
    private String email; 
    private String post; 
    private String DOB; 
    Office_friends(String name,String email,String post,String DOB) { 
        super(name,email); 
        this.setName(name); 
        this.setEmail(email); 
        this.setPost(post); 
        this.setDOB(DOB); 
    } 

    //add peoples to an ArrayList 
    void addtoArray(Office_friends people,ArrayList<Recipients> recipients) { 
    recipients.add(people); 
    } 
    String getName() { 
    return name; 
    } 
    void setName(String name) { 
    this.name = name; 
    } 
    String getEmail() { 
    return email; 
    } 
    void setEmail(String email) { 
    this.email = email; 
    } 
    String getPost() { 
    return post; 
    } 
    void setPost(String post) { 
    this.post = post; 
    } 
    String getDOB() { 
    return DOB; 
    } 
    void setDOB(String dOB) { 
    DOB = dOB; 
    } 
}