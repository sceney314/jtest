package patten.command;

public class CookingCommand {
    public static void main(String[] args) {
        Waiter waiter = new Waiter(new ChangFen(), new HeFen(), new HunTun());
        waiter.chooseChangFen();
        waiter.chooseHeFen();
        waiter.chooseHunTun();
    }
}
