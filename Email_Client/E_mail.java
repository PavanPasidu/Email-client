import java.io.Serializable; 
@SuppressWarnings("serial") 

//create an E_mail object 
class E_mail implements Serializable{ 
    private String email; 
    private String subject; 
    private String content; 
    private String date; 
    //constructor of E_mail class 
    E_mail(String email,String subject,String content,String date) { 
        this.setEmail(email); 
        this.setSubject(subject); 
        this.setContent(content); 
        this.setDate(date); 
    } 
    String getEmail() { 
        return email; 
    } 
    void setEmail(String email) { 
        this.email = email; 
    } 
    String getSubject() { 
        return subject; 
    } 
    void setSubject(String subject) { 
        this.subject = subject; 
    } 
    String getContent() { 
        return content; 
    } 
    void setContent(String content) { 
        this.content = content; 
    } 
    String getDate() { 
        return date; 
    } 
    void setDate(String date) { 
        this.date = date; 
    } 
}