import java.util.*; 
//create a Personal object 
//Personal: sunil,<nick-name>,sunil@gmail.com,2000/10/10 
class Personal extends Recipients{ 
    private String name; 
    private String nick_name; 
    private String email; 
    private String DOB; 
    Personal(String name,String nick_name,String email,String DOB) { 
        super(name,email); 
        this.setName(name); 
        this.setNick_name(nick_name); 
        this.setEmail(email); 
        this.setDOB(DOB); 
    } 
    
    //add people to an arrayList 
    void addtoArray(Personal people,ArrayList<Recipients> recipients) { 
    recipients.add(people); 
    } 
    String getName() { 
    return name; 
    } 
    void setName(String name) { 
    this.name = name; 
    } 
    String getNick_name() { 
    return nick_name; 
    } 
    void setNick_name(String nick_name) { 
    this.nick_name = nick_name; 
    } 
    String getEmail() { 
    return email; 
    } 
    void setEmail(String email) { 
    this.email = email; 
    } 
    String getDOB() { 
    return DOB; 
    } 
    void setDOB(String dOB) { 
    DOB = dOB; 
    } 
}