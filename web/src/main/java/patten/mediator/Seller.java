package patten.mediator;

/**
 * 具体同事类：卖方
 */
public class Seller extends Customer {

    public Seller(String name) {
        this.name = name;
    }

    @Override
    public void send(String ad) {
        medium.relay(name, ad);
    }

    @Override
    public void receive(String from, String ad) {
        System.out.println(from + "说: " + ad);
    }
}
