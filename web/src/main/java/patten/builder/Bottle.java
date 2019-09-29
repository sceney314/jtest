package patten.builder;

/**
 * 具体建造者
 * 2019-09-26 20:38
 */
public class Bottle implements Packing {

    @Override
    public String pack() {
        return "Bottle";
    }
}
