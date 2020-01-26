/*
 * @author: Ethan Kronebusch
 * Date: 2020-01-26
 * Program: Request.java
 * Description: TODO
 */

package serviceswap;

public class Request {
    //variables
    private String want;
    private Profile sender, recipient;
    
    //constructors
    public Request(String want, Profile sender, Profile recipient) {
        this.want = want;
        this.sender = sender;
        this.recipient = recipient;
    }
    
    //getters and setters
    public String getWant() {
        return want;
    }

    public void setWant(String want) {
        this.want = want;
    }

    public Profile getSender() {
        return sender;
    }

    public void setSender(Profile sender) {
        this.sender = sender;
    }

    public Profile getRecipient() {
        return recipient;
    }

    public void setRecipient(Profile recipient) {
        this.recipient = recipient;
    }
    
    //misc methods
    //TODO
}
