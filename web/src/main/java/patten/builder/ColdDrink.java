package patten.builder;

/**
 * 2019-09-26 20:46
 */
public abstract class ColdDrink implements Product {
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
