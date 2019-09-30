package patten.command;

/**
 * 具体命令：河粉
 */
public class HeFen implements Breakfast {

    private Receiver receiver;

    public HeFen() {
        receiver = new HeFenChef();
    }

    @Override
    public void cooking() {
        receiver.cooking();
    }
}
