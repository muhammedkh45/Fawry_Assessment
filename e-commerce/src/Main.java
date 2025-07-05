import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        // Original test case
        Product product1 = new BaseProduct("Laptop",10, 1200.0,4000);
        Calendar cal = Calendar.getInstance();
        cal.set(2026,Calendar.MAY,12);
        Product product2 = new BaseProduct("Gift Card", 5, 50.0, cal);
        Calendar cheeseExDate = Calendar.getInstance();
        cheeseExDate.set(2025,Calendar.AUGUST, 11);
        Product product3 = new BaseProduct("Cheese", 1000, 37.5,cheeseExDate,400);
        Customer customer = new Customer("Alice", 5000.0);
        customer.addToCart(product1,2);
        customer.addToCart(product2, 4);
        customer.addToCart(product3, 3);
        customer.checkOut();

        // Insufficient quantity
        Product product4 = new BaseProduct("Phone", 1, 800.0, 300);
        Customer customer2 = new Customer("Bob", 2000.0);
        customer2.addToCart(product4, 2); 
        customer2.checkOut();

        // Product expired
        Calendar expiredDate = Calendar.getInstance();
        expiredDate.set(2020, Calendar.JANUARY, 1);
        Product product5 = new BaseProduct("Yogurt", 10, 5.0, expiredDate, 100);
        Customer customer3 = new Customer("Carol", 100.0);
        customer3.addToCart(product5, 1); 
        customer3.checkOut();

        // Product sold out
        Customer customer4 = new Customer("David", 100.0);
        customer4.addToCart(product2, 1); 
        Customer customerII = new Customer("Ali", 2000.0);
        customerII.addToCart(product2, 1);
        customerII.checkOut();
        customer4.checkOut();

        //  Insufficient balance
        Product product6 = new BaseProduct("Tablet", 5, 1000.0, 500);
        Customer customer5 = new Customer("Eve", 100.0);
        customer5.addToCart(product6, 1); 
        customer5.checkOut();

        //  Cart is empty
        Customer customer6 = new Customer("Frank", 1000.0);
        customer6.checkOut(); 


        Product product7 = new BaseProduct("Pen", 20, 2.0, 0);
        Product product8 = new BaseProduct("Notebook", 10, 5.0, 200);
        Customer customer7 = new Customer("Grace", 100.0);
        customer7.addToCart(product7, 5);
        customer7.addToCart(product8, 2);
        customer7.checkOut();
    }
}