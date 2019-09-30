package patten.mediator;

/**
 * 抽象同事类：客户
 */
public abstract class Customer {
    protected Medium medium;
    protected String name;

    public String getName() {
        return name;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    public abstract void send(String ad);

    public abstract void receive(String from, String ad);
}
