import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class ShoppingCart {
    private Map<Product, Integer> cartItems;

    public ShoppingCart() {
        this.cartItems = new HashMap<>();
    }

    public void addItem(Product product, int quantity) {
        cartItems.put(product, cartItems.getOrDefault(product, 0) + quantity);
        System.out.println("Item added to the cart: " + product.getName());
    }

    public void removeItem(Product product, intquantity) {
        if (cartItems.containsKey(product)) {
            int currentQuantity = cartItems.get(product);
            if (currentQuantity <= quantity) {
                cartItems.remove(product);
            } else {
                cartItems.put(product, currentQuantity - quantity);
            }
            System.out.println("Item removed from the cart: " + product.getName());
        } else {
            System.out.println("Item not found in the cart: " + product.getName());
        }
    }

    public void viewCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Your cart is empty");
        } else {
            System.out.println("Items in your cart:");
            for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
                Product product = entry.getKey();
                int quantity = entry.getValue();
                System.out.println(product.getName() + " - Quantity: " + quantity + " - Price: $" + product.getPrice());
            }
        }
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            totalPrice += product.getPrice() * quantity;
        }
        return totalPrice;
    }
}
