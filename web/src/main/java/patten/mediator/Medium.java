package patten.mediator;

/**
 * 抽象中介者：中介公司
 */
public interface Medium {
    void register(Customer member);

    void relay(String from, String ad);
}
