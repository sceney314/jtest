package test;

import java.util.concurrent.locks.LockSupport;

/**
 * 交叉打印
 * <p>
 * 2020-05-29 11:37
 */
public class ChangePrint {
    public static void main(String[] args) {
        XPrint xp = new XPrint();

        xp.pta = new Thread(xp::printA);
        xp.ptb = new Thread(xp::printB);

        xp.pta.start();
        xp.ptb.start();
    }

    private static class XPrint{
        Thread pta;
        Thread ptb;
        volatile boolean flag = false;
        void printA(){
            int an = 0;
            while (an++ < 10){
                for (;;){
                    if(!flag){
                        break;
                    }
                }
                System.out.println("A");

                try{
                    Thread.sleep(200L);
                }catch (Exception e){
                    e.printStackTrace();
                }
                LockSupport.unpark(ptb);
                flag = true;
                LockSupport.park(this);

            }
        }

        void printB(){
            int bn = 0;
            while (bn++ < 10){
                for (;;){
                    if(flag){
                        break;
                    }
                }
                System.out.println("B");
                try{
                    Thread.sleep(200L);
                }catch (Exception e){
                    e.printStackTrace();
                }
                LockSupport.unpark(pta);
                flag = false;
                LockSupport.park(this);

            }
        }
    }
}
