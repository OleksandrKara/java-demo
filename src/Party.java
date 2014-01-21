import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Oleksandr_Kara
 * Date: 1/13/14
 * Time: 5:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class Party {
    private String name;
    private String address;
    private final Map<String, String> properties = new HashMap<String, String>();
    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public String setName(String newName){
        return this.name = newName;
    }

    public Map<String, String> getProperties(){
        return properties;
    }
}
