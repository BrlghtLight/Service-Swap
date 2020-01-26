/*
 * @author: Ethan Kronebusch
 * Date: 2020-01-26
 * Program: Profile.java
 * Description: TODO
 */

package serviceswap;

public class Profile {
    //variables
    private String username, password, fName, lName, address, phone, pictureURL, bio;
    private Request[] requestInbox;
    private String[] servicesOffered, requests;
    private Badge[] badges;
    private boolean nearMe;
    
    //constructors
    public Profile(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Profile(String username, String password, String fName, String lName, String address, String phone, String pictureURL, String[] servicesOffered, String[] requests) {
        this.username = username;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
        this.address = address;
        this.phone = phone;
        this.pictureURL = pictureURL;
        this.servicesOffered = servicesOffered;
        this.requests = requests;
    }

    public Profile(String[] servicesOffered) {
        this.servicesOffered = servicesOffered;
    }
    
    //getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPictureURL() {
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL = pictureURL;
    }

    public Request[] getRequestInbox() {
        return requestInbox;
    }

    public void setRequestInbox(Request[] requestInbox) {
        this.requestInbox = requestInbox;
    }

    public String[] getServicesOffered() {
        return servicesOffered;
    }

    public void setServicesOffered(String[] servicesOffered) {
        this.servicesOffered = servicesOffered;
    }

    public Badge[] getBadges() {
        return this.badges;
    }

    public void setBadges(Badge[] badges) {
        this.badges = badges;
    }
    
    public String[] getRequests() {
        return requests;
    }

    public void setRequests(String[] requests) {
        this.requests = requests;
    }

    public boolean isNearMe() {
        return nearMe;
    }

    public void setNearMe(boolean nearMe) {
        this.nearMe = nearMe;
    }
    
    public void setBio(String bio){
        this.bio = bio;
    }
    
    public String getBio(){
        return bio;
    }
    
    public String getFullName(){
        return this.fName + " " + this.lName;
    }
    
    //misc methods

    @Override
    public String toString() {
        return "Profile{" + "username=" + username + ", password=" + password + ", fName=" + fName + ", lName=" + lName + ", address=" + address + ", phone=" + phone + ", pictureURL=" + pictureURL + ", requestInbox=" + requestInbox + ", servicesOffered=" + servicesOffered + ", requests=" + requests + ", badges=" + badges + ", nearMe=" + nearMe + '}';
    }
    
    
}
