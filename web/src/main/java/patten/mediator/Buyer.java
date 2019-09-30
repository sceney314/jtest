package patten.mediator;

/**
 * 具体同事类：买方
 */
public class Buyer extends Customer {

    public Buyer(String name) {
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
