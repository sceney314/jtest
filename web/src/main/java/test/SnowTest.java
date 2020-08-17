package test;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 雪花算法
 * <p>
 * 2020-07-09 11:25
 */
public class SnowTest {

    private static final long autoBits = (1 << 27) - 1;

    private static final long workerIdShift = 27;

    private static final long wdBits = (1 << 4) - 1;

    private static final long timeShift = 31;

    private static final long timebits =  (1L << 32) - 1;

    private static volatile AtomicLong auto = new AtomicLong(0l);


    public static void main(String[] args) {
        SnowTest snow = new SnowTest();
        for(int i = 1; i < 16; i++){
            final int k = i;
            Thread t = new Thread(() -> {
                int i1 = 100_0000;
                while (i1-- > 0){
                    System.out.println("生成器测试线程 : " + k + ", " + snow.nextId(k));
                }
            }, "ID 生成器测试线程 :" + i);
            t.start();
        }
    }

    public long nextId(long workId){
        long id = workId & wdBits;

        long unix = System.currentTimeMillis();
        long tbit = (unix /1000) & timebits;

        long offset = auto.addAndGet(1) & autoBits;

        return  (tbit << timeShift) | (id << workerIdShift) | (offset);
    }

}
