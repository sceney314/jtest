package patten.builder;

/**
 * 2019-09-26 20:39
 */
public abstract class Burger implements Product {
    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();

}
