import java.util.Calendar;

public class BaseProduct implements Product, Shippable {
    private double price;
    private String name;
    private int qunatity;
    private Calendar expireDate;
    private double weight;

    public BaseProduct(String name, int qunatity ,double price){
        this(name,qunatity,price,null,0);
    }
    public BaseProduct(String name, int qunatity ,double price , double weight){
        this(name,qunatity,price,null,weight);
    }
    public BaseProduct(String name, int qunatity ,double price,Calendar expireDate){
        this(name,qunatity,price,expireDate,0);
    }
    public BaseProduct(String name, int qunatity, double price, Calendar expireDate, double weight) {
        this.name = name;
        this.qunatity = qunatity;
        this.price = price;
        this.expireDate = expireDate;
        this.weight = weight;
    }
@Override
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    @Override
    public double getWeight(){
        return weight;
    }
    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getQuantity() {
        return qunatity;
    }
    public void setQuantity(int qunatity){
        this.qunatity = qunatity;
    }
    public Calendar getExpDate(){
        return expireDate;
    }
    
    @Override
    public boolean isExpired() {
        return expireDate != null && expireDate.before(Calendar.getInstance());
    }

    @Override
    public boolean isShippable() {
        return weight > 0 ? true : false;
    }

}
