import java.util.*;

public class Customer {
    private String name;
    private double balance;
    private int cardNum;
    private Map<Product, Integer> cart;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
        setCart();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCardNum() {
        return cardNum;
    }

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }

    public Map<Product, Integer> getCart() {
        return cart;
    }

    public void setCart() {
        this.cart = new HashMap<>();
    }

    public void addToCart(Product p, int amount) {
        if (p.getQuantity() < amount) {
            System.err.println("Insufficient Quantity");
            return;
        }
        try {
            getCart().put(p, amount);
        } catch (Exception e) {
            System.err.println("Error" + e);
        }
    }

    public void checkOut() {
        if (getCart() == null || getCart().isEmpty()) {
            System.err.println("Cart is empty");
            return;
        }
        double total = 0;
        for (Product product : getCart().keySet()) {
            if (product.getExpDate() != null && ((BaseProduct) product).getWeight() != 0 && product.isExpired()) {
                System.err.println("Product has expired");
                return;
            }
            if (product.getQuantity() == 0) {
                System.err.println("Product sold out");
                return;
            }
            total += product.getPrice() * cart.get(product); // product price * amount
            ((BaseProduct) product).setQuantity(product.getQuantity() - cart.get(product));
        }
        double shippingFees = total * 0.1;
        double paidAmount = shippingFees + total;
        if (getBalance() >= paidAmount) {
            setBalance(getBalance() - paidAmount);
            shipping((HashMap) getCart());
            System.out.println("---------------------------------------------");
            System.out.println("order subtotal: " + total);
            System.out.println("shipping fees: " + shippingFees);
            System.out.println("Paid amount: " + paidAmount);
            System.out.println("Current Balance = " + getBalance());
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
            return;
        } else {
            System.err.println("Balance is insufficient");
            for (Product product : cart.keySet()) {
                ((BaseProduct) product).setQuantity(product.getQuantity() + cart.get(product));
            }
        }
    }

    public void shipping(HashMap<Product, Integer> cart) {
        HashMap<BaseProduct, Integer> shippables = new HashMap<>();
        for (Product p : cart.keySet()) {
            if (((BaseProduct) p).getWeight() != 0) {
                shippables.put((BaseProduct) p, cart.get(p));
            }
        }
        if (!shippables.isEmpty()) {
            double totalWeight = 0.0;
            System.out.println("** Shipment Notice **");
            for (BaseProduct p : shippables.keySet()) {
                System.out.println(shippables.get(p) + "X " + p.getName() + "        " + p.getWeight() + "g");
                totalWeight += p.getWeight();
            }
            System.out.println("Total package weight " + totalWeight / 1000.0 + " Kg\n");
            System.out.println("** Checkout receipt **");
            for (Product p : cart.keySet()) {
                System.out.println(cart.get(p) + "X " + ((BaseProduct) p).getName() + "    " + p.getPrice());
                totalWeight += ((BaseProduct) p).getWeight();
            }
        }
    }
}
