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

    public String getTitle(){
        return title;
    }

      public double getPrice(){
        return price;
    }

      public String setTitle(String newTitle){
        return this.title = newTitle;
    }

    public double setPrice(double newPrice){
            return this.price = newPrice;
    }

    public double getCost(int quantity){
        double realCost = quantity*price;
        return realCost-(realCost*calcDiscount(quantity)/100);
    }

    protected int calcDiscount(int quantity){
        if (quantity > DEF_DISCOUNT){
            return 10;
        }
        else return 0;
    }

}
