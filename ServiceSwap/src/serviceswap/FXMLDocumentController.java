/*
 * @author: Ethan Kronebusch
 * Date: 2020-01-26
 * Program: FXMLDocumentController.java
 * Description: Makes the GUI actually do program stuff.
 */
package serviceswap;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author not
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label talentTextArea;
    @FXML
    private Label needsTextArea;
    @FXML
    private Label bioField;
    @FXML
    private Button leftButton;
    @FXML
    private Button requestButton;
    @FXML
    private Button rightButton;
    @FXML
    private ImageView profilePic;
    @FXML
    private ImageView badgeOne;
    @FXML
    private ImageView badgeTwo;
    @FXML
    private ImageView badgeThree;
    @FXML
    private ImageView nearMe;
    @FXML
    private Label profileName;
    private int index;
    private Profile[] users;
    private Tooltip tipOne = new Tooltip("Background Check Cleared");
    private Tooltip tipTwo = new Tooltip();
    private Tooltip tipThree = new Tooltip("New User");
    private Tooltip tipNear = new Tooltip();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        users = setUsers();
        loadProfile(0);
    }    

    @FXML
    private void leftClicked(MouseEvent event) {
        System.out.println("Left button clicked");
        if(index != 0){
            index--;
            loadProfile(index);
        } else {
            index=users.length-1;
            loadProfile(index);
        }
    }

    @FXML
    private void requestClicked(MouseEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION, "Successfully requested " + users[index].getFullName() + ". You'll be notified if they accept your trade.");
        alert.setTitle("Request Sent!");
        alert.show();
    }

    @FXML
    private void rightClicked(MouseEvent event) {
        System.out.println("Right button clicked");
        if(index != users.length-1){
            index++;
            loadProfile(index);
        } else {
            index=0;
            loadProfile(index);
        }
    }
    
    private Profile[] setUsers(){
        Badge backgroundCheck = new Badge("Background Checked","This person has no criminal history.","background.png");
        Badge firstgood = new Badge("1 Positive Experience","This person has no criminal history.","1good.png");
        Badge fiftygood = new Badge("50 Positive Experiences","This person has no criminal history.","50good.png");
        Badge hundredgood = new Badge("100 Positive Experiences","This person has no criminal history.","100good.png");
        Badge newbie = new Badge("New User","This person has no criminal history.","new.png");
        String[] grandmaSkills = {"Cooking","Sewing"};
        String[] grandmaWants = {"Lawnmowing", "Snow shovelling"};
        Badge[] grandmaBadges = {backgroundCheck, newbie};
        String[] sketchySkills = {"Knowing things", "Staring", "Oversharing"};
        String[] sketchyWants = {"Back rubs","Help moving","a girlfriend"};
        Badge[] sketchyBadges = {};
        String[] niceSkills = {"Lawn services", "Snow clearance", "Manual labour"};
        String[] niceWants = {"Nice home cooked meals", "Haircut"};
        Badge[] niceBadges = {backgroundCheck,hundredgood};
        String[] truckerSkills = {"Car repair","Has a truck"};
        String[] truckerWants = {"Babysitter", "Tutoring for my kids"};
        Badge[] truckerBadges = {backgroundCheck,newbie};
        String[] girlSkills = {"Babysitting","Tutoring","Making great coffee"};
        String[] girlWants = {"An oil change for my car","Someone to lift heavy things","a way out of my crippling debt"};
        Badge[] girlBadges = {newbie,firstgood};
        Profile grandma = new Profile("grandma69","whatever","Susan","Miller","123 Main St","5072532635","grandma.jpg", grandmaSkills, grandmaWants);
        grandma.setBadges(grandmaBadges);
        grandma.setBio("A 73 year old woman who cannot perform manual labor anymore, but can cook a great meal, bake delicous brownies, or patch some jeans in exchange for some help around the house.");
        Profile sketchy = new Profile("TotallyTrustworthy","password","Chad","Creepalot","TODO","TODO","sketchy.jpg",sketchySkills,sketchyWants);
        sketchy.setBadges(sketchyBadges);
        sketchy.setBio("Stereotypical creeper on a social media site. Not someone who you would want to trade with. Showcases the application’s badge features showing this person is NOT verified, does NOT live nearby, and has no “good experiences” whatsoever.");
        Profile niceGuy = new Profile("justOrdinary", "killthemall","Dan","Smith","TODO","TODO","nice.jpg",niceSkills,niceWants);
        niceGuy.setBadges(niceBadges);
        niceGuy.setNearMe(true);
        niceGuy.setBio("A 27 year old bachelor who is fit and able to perform manual labor in exchange for a home-cooked meal, because he moved away from home a few years ago and misses his family.");
        Profile trucker = new Profile("truxx4lyfe","dr!ve1978","Chris","Walker","TODO","TODO","trucker.png",truckerSkills,truckerWants);
        trucker.setBadges(truckerBadges);
        trucker.setBio("A 30 year old married male who owns a truck and has a family. He is willing to help you move in exchange for babysitting services or someone to help tutor his children in math. Is mechanically inclined so he is able to perform basic car maintenance.");
        Profile girl = new Profile("so_much_debt","1wantto_die","Emma","Jean","TodddO","TODO","girl.jpg",girlSkills,girlWants);
        girl.setBadges(girlBadges);
        girl.setNearMe(true);
        girl.setBio("A young college grad looking to move into her new apartment. Willing to babysit or tutor children in exchange for help moving. Also looking for someone who can perform a simple oil change on her car, since she doesn't have the money to get it serviced.");
        Profile[] usrs = {grandma, sketchy, niceGuy, trucker, girl};
        return usrs;
    }
    
    private void loadProfile(int ind){
        profileName.setText(users[ind].getFullName());
        profilePic.setImage(new Image("/serviceswap/profilepics/"+users[ind].getPictureURL(),true));
        
       //System.out.println(users[2].getBadges());
       String badgeList = "";
        for(Badge b : users[ind].getBadges()){
            badgeList += b.name + "\n";
        }
        
        if(badgeList.contains("Background")){
            Tooltip.install(badgeOne, tipOne);
            badgeOne.setImage(new Image("/serviceswap/badges/background.png"));
        }else{
            badgeOne.setImage(null);
            Tooltip.uninstall(badgeOne, tipOne);
        }
        
        if(badgeList.contains("1 Positive")){
            tipTwo.setText("1 Positive Experience");
            Tooltip.install(badgeTwo, tipTwo);
            badgeTwo.setImage(new Image("/serviceswap/badges/1good.png"));
        }else if(badgeList.contains("50 Positive")){
            tipTwo.setText("50 Positive Experiences");
            Tooltip.install(badgeTwo, tipTwo);
            badgeTwo.setImage(new Image("/serviceswap/badges/50good.png"));
        }else if(badgeList.contains("100 Positive")){
            tipTwo.setText("100+ Positive Experiences");
            Tooltip.install(badgeTwo, tipTwo);
            badgeTwo.setImage(new Image("/serviceswap/badges/100good.png"));
        }else{
            Tooltip.uninstall(badgeTwo, tipTwo);
            badgeTwo.setImage(null);
        }
        
        if(badgeList.contains("New User")){
            Tooltip.install(badgeThree, tipThree);
            badgeThree.setImage(new Image("/serviceswap/badges/new.png"));
        }else{
            Tooltip.uninstall(badgeThree, tipThree);
            badgeThree.setImage(null);
        }
        
        if(users[ind].isNearMe()){
            if(ind==4){
                tipNear.setText("Emma Jean is 1.4 miles away from you.");
            }else if(ind==2){
                tipNear.setText("Dan Smith is 0.5 miles away from you.");
            }
            
            Tooltip.install(nearMe, tipNear);
            nearMe.setImage(new Image("/serviceswap/badges/close.png"));
        }else{
            Tooltip.uninstall(nearMe, tipNear);
            nearMe.setImage(null);
        }
        
        //load skills/needs
        String[] skills = {"","","","",""};
        System.arraycopy(users[ind].getServicesOffered(), 0, skills, 0, users[ind].getServicesOffered().length);
        String[] wants = {"","","","",""};
        System.arraycopy(users[ind].getRequests(), 0, wants, 0, users[ind].getRequests().length);
        
        String talents = String.format("%s%n%s%n%s%n%s",skills[0],skills[1],skills[2],skills[3]);
        talentTextArea.setText(talents);
        
        String needs = String.format("%s%n%s%n%s%n%s",wants[0],wants[1],wants[2],wants[3]);
        needsTextArea.setText(needs);
        
        //load bio
        bioField.setText(users[ind].getBio());
    }
}
