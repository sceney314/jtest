package forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class CountAction extends RecursiveAction {
    private int start;
    private int end;
    private static final int THRESHOLD = 2;

    public CountAction(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        boolean canCompute = (end - start) < THRESHOLD;
        if (canCompute){
            for (int i = start; i <= end; i++) {
                System.out.println(i);
            }
        }else{
            int middle = (end + start) / 2;
            CountAction task = new CountAction(start, middle);
            CountAction task1 = new CountAction(middle + 1, end);
            //执行子任务
            task.fork();
            task1.fork();
        }
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        CountAction countAction = new CountAction(1, 100);

        forkJoinPool.submit(countAction);


        while (true){
            if (countAction.isDone()){
                System.out.println(countAction.isCancelled());
                System.out.println(countAction.isCompletedAbnormally());
                System.out.println(countAction.isCompletedNormally());
                System.out.println(countAction.isDone());
                break;
            }
        }
    }
}
