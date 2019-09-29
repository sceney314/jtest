package patten.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象建造者
 * 2019-09-26 20:48
 */
public class Meal {

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }

    public float getCost(){
        float cost = 0.0f;
        for (Product product : products) {
            cost += product.price();
        }
        return cost;
    }

    public void showProducts(){
        for (Product product : products) {
            System.out.print("Product : "+ product.name());
            System.out.print(", Packing : "+ product.packing().pack());
            System.out.println(", Price : "+ product.price());
        }
    }

}
