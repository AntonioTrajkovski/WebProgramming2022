package mk.ukim.finki.wbaud.bootstrap;

import mk.ukim.finki.wbaud.model.*;
import mk.ukim.finki.wbaud.web.servlet.CategoryServlet;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Category> categories = new ArrayList<>();
    public  static List<User> users = new ArrayList<>();
    public static List<Manufacturer> manufacturers = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();
    public static List<ShoppingCart> shoppingCarts = new ArrayList<>();

//    @PostConstruct
//    public void init(){
//        this.categories.add(new Category("Software", "Software Category"));
//        this.categories.add(new Category("Books","Books Category"));
//
//        users.add(new User("antonio.trajkovski","antr", "antonio", "trajkovski"));
//        users.add(new User("riste.stojanov","rs", "riste", "stojanov"));
//
//        Manufacturer manufacturer = new Manufacturer("Nike", "NY NY");
//        manufacturers.add(manufacturer);
//
//        Category category = new Category("Sport", "Sport category");
//        categories.add(category);
//
//        products.add(new Product("Ball 1", 235.8, 7, category, manufacturer));
//        products.add(new Product("Ball 2", 235.8, 7, category, manufacturer));
//        products.add(new Product("Ball 3", 235.8, 7, category, manufacturer));
//
//
//    }

}
