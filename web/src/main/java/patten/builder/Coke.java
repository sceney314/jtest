package patten.builder;

/**
 * @author zhengzp
 * 2019-09-26 20:47
 */
public class Coke extends ColdDrink{

    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Coke";
    }

}
