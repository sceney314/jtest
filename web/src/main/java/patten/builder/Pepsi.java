package patten.builder;

/**
 * @author zhengzp
 * 2019-09-26 20:48
 */
public class Pepsi extends ColdDrink{

    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }

}
