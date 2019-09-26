package patten.builder;

/**
 * @author zhengzp
 * 2019-09-26 20:46
 */
public abstract class ColdDrink implements Item{
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
