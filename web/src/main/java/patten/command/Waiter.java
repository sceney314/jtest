package patten.command;

/**
 * 调用者：服务员
 */
public class Waiter {
    private Breakfast changFen;
    private Breakfast heFen;
    private Breakfast hunTun;

    public Waiter(Breakfast changFen, Breakfast heFen, Breakfast hunTun) {
        this.changFen = changFen;
        this.heFen = heFen;
        this.hunTun = hunTun;
    }

    public void chooseChangFen() {
        changFen.cooking();
    }

    public void chooseHunTun() {
        hunTun.cooking();
    }

    public void chooseHeFen() {
        heFen.cooking();
    }
}
