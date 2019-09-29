package patten.builder;

/**
 * 具体建造者
 * 2019-09-26 20:46
 */
public class ChickenBurger extends Burger{

    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }

}
