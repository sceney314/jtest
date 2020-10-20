package test;


/**
 * 2020-06-22 11:21
 */
public class NewTest {


    public static void main(String[] args){
        System.out.println(Integer.toBinaryString(128));
        System.out.println(128 << 1);
        System.out.println(Integer.toBinaryString(128 << 1));
        System.out.println(Integer.toBinaryString(127));
        System.out.println(Integer.toBinaryString(126));

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++){
                    try {
                        if(i == 0){
                            System.out.println("t1 is ready");
                        }else{
                            System.out.println("t1 is sleep");
                        }

                        Thread.sleep(3000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

                System.out.println("t1 is over");
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++){
                    try {
                        if(i == 0){
                            System.out.println("t2 is ready");
                            t1.join();
                        }else{
                            System.out.println("t2 is sleep");

                        }
                        Thread.sleep(3000);

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

                System.out.println("t2 is over");
            }
        });


        t1.start();
        t2.start();

    }




}
