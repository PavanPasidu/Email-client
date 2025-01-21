import java.util.*; 
//create an Official object 
//Official: nimal,nimal@gmail.com,ceo 
class Official extends Recipients{ 
    private String name; 
    private String email; 
    private String post; 
    Official(String name,String email,String post) { 
        super(name,email); 
        this.setName(name); 
        this.setEmail(email); 
        this.setPost(post); 
    } 
    
    //add peoples to an arrayList 
    void addtoArray(Official people,ArrayList<Recipients> recipients) { 
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
}