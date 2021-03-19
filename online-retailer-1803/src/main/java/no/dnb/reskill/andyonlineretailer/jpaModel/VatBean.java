package no.dnb.reskill.andyonlineretailer.jpaModel;

public class VatBean {
    private static final double VAT_CAT_1 = 25;
    private static final double VAT_CAT_2 = 27;
    private static final double VAT_CAT_3 = 50;

    public double vatSpecification(double price){

        if(price >= 10000 ) {
            price = price * VAT_CAT_3;
        }else if(price < 10000 && price >= 100){
            price = price * VAT_CAT_2;
        } else if(price < 100){
            price = price * VAT_CAT_1;
        }
        return price/100;
    }

}
