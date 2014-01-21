import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Oleksandr_Kara
 * Date: 1/13/14
 * Time: 5:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Deal {
    private Date date = new Date();
    private Party seller;
    private Party buyer;
    private final Map<Product, Integer> products = new HashMap<Product, Integer>();

    public Deal(Party seller, Party buyer){
        /*super();*/
        this.seller = seller;
        this.buyer = buyer;
    }

    public Date getDate(){
        return date;
    }

    public Party getSeller(){
        return seller;
    }

    public Party getBuyer(){
        return buyer;
    }

    public Map<Product, Integer> getProducts(){
        return products;
    }

    public double getSum(){
        double rez = 0;
        for(Map.Entry<Product, Integer> entry : products.entrySet()){
            Product product = entry.getKey();
            int quantity = entry.getValue();
            rez += product.getCost(quantity);
        }
        return rez;
    }

}