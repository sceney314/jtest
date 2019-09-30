package patten.state;

/**
 * 具体状态A类
 */
public class ConcreteStateA extends State {

    @Override
    public void Handle(Context context) {
        System.out.println("当前状态是 A.");
    }
}
