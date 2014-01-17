/**
 * Created with IntelliJ IDEA.
 * User: Oleksandr_Kara
 * Date: 1/15/14
 * Time: 12:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class BotinkiProduct extends Product{
    private int size;
    private String color;

    public int getSize(){
        return size;
    }

    public String getColor(){
        return color;
    }

    public int setSize(int newSize){
        return size = newSize;
    }

    public String setColor(String newColor){
        return color = newColor;
    }

}
