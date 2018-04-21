package zadanie4;

import java.util.HashMap;

public class Cart {
    HashMap<Integer, Integer> cartItems;

    public Cart() {
        cartItems = new HashMap<>();
    }

    public HashMap getCartItems() {
        return cartItems;
    }

    public void addToCart(Integer itemId, Integer quantity) {
        cartItems.put(itemId, quantity);
    }

    public Integer getQuantity(Integer itemId) {
        return cartItems.get(itemId);
    }

    public void deleteFromCart(Integer itemId) {
        cartItems.remove(itemId);
    }

}
