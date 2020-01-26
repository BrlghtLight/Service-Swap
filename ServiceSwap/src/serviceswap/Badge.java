/*
 * @author: Ethan Kronebusch
 * Date: 2020-01-26
 * Program: Badge.java
 * Description: Defines the (rather useless) Badge object.
 */

package serviceswap;

public class Badge {
    //variables
    public String name, description;
    private String iconURL;
    
    //constructors
    public Badge(String name, String description, String iconURL) {
        this.name = name;
        this.description = description;
        this.iconURL = iconURL;
    }
}
