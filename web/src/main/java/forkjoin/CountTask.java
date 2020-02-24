package forkjoin;

import lombok.Data;

import java.util.concurrent.*;

@Data
public class CountTask extends RecursiveTask<Integer> {
    //阙值
    private static final int THRESHOLD = 2;

    private int start;

    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }


    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end - start) < THRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            int middle = (end + start) / 2;

            CountTask task = new CountTask(start, middle);
            CountTask task1 = new CountTask(middle + 1, end);
            //执行子任务
            task.fork();
            task1.fork();
            //等子任务执行完
            Integer leftResult = task.join();
            Integer rightResult = task1.join();

            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        CountTask countTask = new CountTask(1, 100);

        Future<Integer> submit = forkJoinPool.submit(countTask);
        System.out.println(countTask.isCancelled());
        System.out.println(countTask.isCompletedAbnormally());
        System.out.println(countTask.isCompletedNormally());
        System.out.println(countTask.isDone());
        try {
            System.out.println(submit.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
