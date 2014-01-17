/**
 * Created with IntelliJ IDEA.
 * User: Oleksandr_Kara
 * Date: 1/15/14
 * Time: 12:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class FotoProduct extends Product{
    private double megapx;
    private boolean digital;

    public double getMegapx(){
        return megapx;
    }

    public boolean getDigital(){
        return digital;
    }

    public double setMegapx(double newMegapx){
        return megapx = newMegapx;
    }

    public boolean setDigital(boolean newDigital){
        return digital = newDigital;
    }

    @Override
    protected int calcDiscount(){
        int def = super.calcDiscount();
        if (!digital){
            def+=20;
        }
        return def;
    }
}
