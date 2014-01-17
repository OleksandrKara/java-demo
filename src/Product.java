/**
 * Created with IntelliJ IDEA.
 * User: Oleksandr_Kara
 * Date: 1/13/14
 * Time: 5:51 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Product {
    public static final int DEF_DISCOUNT = 10;
    private String title;
    private double price;
    private int quantity;

    public String getTitle(){
        return title;
    }

    public int getQuantity(){
        return quantity;
    }

    public double getPrice(){
        return price;
    }

    public int setQuantity(int newQuantity){
        return this.quantity = newQuantity;
    }

    public String setTitle(String newTitle){
        return this.title = newTitle;
    }

    public double setPrice(double newPrice){
            return this.price = newPrice;
    }

    public double setCost(){
        double realCost = quantity*price;
        return realCost-(realCost*calcDiscount()/100);
    }

    protected int calcDiscount(){
        if (quantity > 10){
            return DEF_DISCOUNT;
        }
        else return 0;
    }

}
