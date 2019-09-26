package patten.builder;

/**
 * @author zhengzp
 * 2019-09-26 20:46
 */
public class VegBurger extends Burger{
    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }

}
