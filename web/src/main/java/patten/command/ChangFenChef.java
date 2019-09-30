package patten.command;

/**
 * 接收者：肠粉厨师
 */
public class ChangFenChef implements Receiver{
    @Override
    public void cooking() {
        System.out.println("肠粉厨师做肠粉");
    }
}
