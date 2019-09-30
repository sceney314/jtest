package patten.command;

/**
 * 具体命令：肠粉
 */
public class ChangFen implements Breakfast {

    private Receiver receiver;

    public ChangFen() {
        receiver = new ChangFenChef();
    }

    @Override
    public void cooking() {
        receiver.cooking();
    }
}
