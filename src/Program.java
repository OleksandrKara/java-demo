import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;
/**
 * Created with IntelliJ IDEA.
 * User: Oleksandr_Kara
 * Date: 1/13/14
 * Time: 6:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class Program {
final int  MAX_DEALS = 1;
    /*final int MAX_PRODUCTS = 1;*/
    final static String ERROR_MSG = "You've entered wrong data.";
    private Collection <Deal> deals;
    public static void main(String[] args){
        new Program().allActions();
    }

    public void allActions(){
          input();
          System.out.println("-----------------------");
          output();
    }

    public void input(){
        deals = new LinkedList<Deal>();
        for (Deal i: deals){
            i = inputDeal();
        }
    }

    public void output(){
        for(Deal d: deals){
            System.out.println("Date: \t"+d.getDate());
            System.out.println("The buyer is: \t "+d.getBuyer().getName()+".\nAnd seller is: \t "+d.getSeller().getName());
            for (Product product: d.getProducts()){
                System.out.println("The name of the product is: \t "+product.getTitle());
                System.out.println("The price of one product is: \t "+product.getPrice());
                System.out.println("Quantity:\t "+product.getQuantity());
                System.out.println("Your sale: \t"+product.calcDiscount()+"%");
            }
            System.out.println("Total: \t"+d.getSum());
            System.out.println( "---------------------------------------" );
        }
    }

   public Deal inputDeal(){
       Product[] products = new Product[MAX_PRODUCTS];
       System.out.println("Enter the name of the buyer \t ");
       Party buyer = inputParty();
       System.out.println("Enter the name of the seller \t ");
       Party seller = inputParty();
       for(int i = 0; i<products.length; i++){
            products[i] = inputProduct();
       }
       Deal deal = new Deal(buyer, seller, products);
       return deal;
    }

    public Party inputParty() {
        String partyName = keyboard("---");
        Party party = new Party();
        party.setName(partyName);
        return party;
    }

    public Product inputProduct() {
        String typeOfTheProduct = keyboard("Select the type of the product(1 = Botinki. 2 = Foto.)");
        Product product = null;

        String price = null;
        Double dPrice = null;
        String quantity = null;
        Integer iQuantity = null;

        String title = keyboard("Enter the name of the product");
        try {
            price = keyboard("Enter the price of the product");
            /*Double */dPrice = Double.valueOf(price);
            quantity = keyboard("Enter the quantity");
            /*Integer */iQuantity = Integer.valueOf(quantity);
        } catch (NumberFormatException e){
            System.err.println(ERROR_MSG);
            System.exit(1);
        }

        if(Integer.valueOf(typeOfTheProduct) == 1) {
            BotinkiProduct productBotinki = new BotinkiProduct();
            String color = keyboard("Enter the color of the shoes");
                productBotinki.setColor(color);
            product = productBotinki;
        } else if (Integer.valueOf(typeOfTheProduct) == 2) {
            FotoProduct productFoto = new FotoProduct();
            try {
            String megapx = keyboard("Enter the number of megapixels ");
                productFoto.setMegapx(Double.valueOf(megapx));
            String digital = keyboard("Does it digital(True or False)");
                productFoto.setDigital(Boolean.valueOf(digital));
            } catch (NumberFormatException e){
                System.err.println(ERROR_MSG);
                System.exit(1);
            }
                product = productFoto;
        } else {
            System.err.println(ERROR_MSG);
            System.exit(1);
        }

        try {
            product.setTitle(title);
            product.setPrice(dPrice);
            product.setQuantity(iQuantity);
        } catch (NumberFormatException e){
            System.err.println(ERROR_MSG);
            System.exit(1);
        }

        return product;
    }

    public String keyboard(String message){
        System.out.println(message);
        Scanner keys = new Scanner(System.in);
        return keys.nextLine();
    }

    private boolean continueInput() {
        String continueInput = keyboard("Do you want to buy 1 more product?(Yes - y No n)");
        if(continueInput == "y"){
            return true;
        }else if (continueInput == "n"){
            return false;
        }  else {
            System.out.println(ERROR_MSG);
            System.exit(1);
            return false;
            }
        }

    }
}
