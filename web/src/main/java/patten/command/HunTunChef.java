package patten.command;

/**
 * 接收者：馄饨厨师
 */
public class HunTunChef implements Receiver {
    @Override
    public void cooking() {
        System.out.println("馄饨厨师做馄饨");
    }
}
