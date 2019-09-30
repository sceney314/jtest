package patten.command;

/**
 * 具体命令：馄饨
 */
public class HunTun implements Breakfast {
    private Receiver receiver;

    public HunTun() {
        receiver = new HunTunChef();
    }

    @Override
    public void cooking() {
        receiver.cooking();
    }
}
