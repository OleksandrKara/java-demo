import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: Oleksandr_Kara
 * Date: 1/13/14
 * Time: 5:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Deal {
    private Date date;
    private Party seller;
    private Party buyer;
    Collection <Product> products = new LinkedList<Product>();

    public Deal(Party seller, Party buyer, Collection <Product> products){
        this.seller = seller;
        this.buyer = buyer;
        this.products = products;
        date = new Date();
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

    public Collection <Product> getProducts(){
        return products;
    }

    public double getSum(){
        double rez = 0;
        for(Product product: products){
            rez += product.setCost();
        }
        return rez;
    }

}