import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Oleksandr_Kara
 * Date: 1/13/14
 * Time: 6:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class Program {
    final static String ERROR_MSG = "You've entered wrong data.";
    private Collection <Deal> deals = new LinkedList<Deal>();
    private final List<Product> products = new LinkedList<Product>();

    public static void main(String[] args){
        new Program().allActions();
    }

    public void allActions(){
          input();
          System.out.println("---------------------------------------");
          output();
    }

    public void input(){
        do {
            Deal deal = inputDeal();
            deals.add(deal);
        }   while(continueInput("Input one more deal? (Yes - y No n)"));
    }


    public void output(){
        for(Deal d: deals){
            /*System.out.println("Date: \t"+d.getDate()+"\nThe buyer is: \t "+d.getBuyer().getName()+".\nAnd seller is: \t "+d.getSeller().getName());*/
            for (Map.Entry<Product, Integer> entry: d.getProducts().entrySet()){
                Product product = entry.getKey();
                int quantity = entry.getValue();
                System.out.println("  "+ product.getTitle() + " " + quantity + " x "+
                                            + product.getPrice() + " = " + product.getCost(quantity)+"\nYour sale: \t"+product.calcDiscount(quantity)+"%");
            }
        outputParty(d.getBuyer());
        outputParty(d.getSeller());
        System.out.println("Total: \t"+d.getSum()+"$\n---------------------------------------");
        }

    }

    private void outputParty(Party party){
        for (Map.Entry<String, String> entry : party.getProperties().entrySet()) {
            System.out.println("  The party:\t" + entry.getKey() + "\t address:\t " + entry.getValue());
        }
    }


   public Deal inputDeal(){
       Party buyer = inputParty("Enter the name of the buyer \t ");
       Party seller = inputParty("Enter the name of the seller \t ");
       Deal deal = new Deal(buyer,seller);
       do {
           Product product = inputProduct();
           String quantity = keyboard("Please enter the quantity of this product.");
           deal.getProducts().put(product, Integer.valueOf(quantity));
       } while(continueInput("Input one more product? (Yes - y No n)"));

       return deal;
    }

    public Party inputParty(String message) {
        Party party = new Party();
        do {
            String partyName = keyboard(message);
            String address = keyboard("Please enter address");
            party.getProperties().put(partyName, address);
        } while(continueInput("Enter a new party? y - Yes, n - No"));

        return party;
    }

    public Product inputProduct() {
        Product product = null;
        String reply = keyboard("Select product (y - Yes, n - No)");
        if (reply.equals("y")) {
            product = selectProduct();
        }

        if (product != null) {
            return product;
        }

        String typeOfTheProduct = keyboard("Select the type of the product(1 = Botinki. 2 = Foto.)");
        String title = keyboard("Enter the name of the product");
        String price = keyboard("Enter the price of the product");
        Double dPrice = null;

        try {
            dPrice = Double.valueOf(price);
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
        } catch (NumberFormatException e){
            System.err.println(ERROR_MSG);
            System.exit(1);
        }

        // Adding product to cache
        this.products.add(product);
        return product;
    }

    private Product selectProduct() {
        if(products.isEmpty()){
            System.out.println("No products to select");
            return null;
        }
        for (int i = 0; i<products.size(); i++){
            System.out.println(" " + (i + 1) + ")"
                        + products.get(i).getTitle());
        }
        String reply = keyboard("Your choice");
        Integer index = Integer.valueOf(reply);
        if (index <= products.size()){
            return products.get(index-1);
        } else {
            System.out.println(" You've selected incorrect product index.");
            return null;
        }
    }

    public String keyboard(String message){
        System.out.println(message);
        Scanner keys = new Scanner(System.in);
        return keys.nextLine();
    }

    private boolean continueInput(String message) {
        String continueInput = keyboard(message);
        if(continueInput.equals("y")){
            return true;
        }else if(continueInput.equals("n")){
            return false;
        } else {
            System.out.println(ERROR_MSG);
            System.exit(1);
            return false;
        }
    }
}
