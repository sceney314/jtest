package patten.command;

/**
 * 接收者：河粉厨师
 */
public class HeFenChef implements Receiver{
    @Override
    public void cooking() {
        System.out.println("河粉厨师做河粉");
    }
}
