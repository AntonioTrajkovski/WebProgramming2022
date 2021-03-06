package mk.ukim.finki.wbaud.service;

import mk.ukim.finki.wbaud.model.Product;
import mk.ukim.finki.wbaud.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    List<Product> listAllProductsInShoppingCart(Long cartId);
    ShoppingCart getActiveShoppingCart(String username);
    ShoppingCart addProductToShoppingCart(String username, Long productId);


}
