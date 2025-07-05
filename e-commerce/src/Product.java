import java.util.Calendar;
public interface Product {

    double getPrice() ;
    int getQuantity() ;
    Calendar getExpDate();
    boolean isExpired();
    boolean isShippable();

}
