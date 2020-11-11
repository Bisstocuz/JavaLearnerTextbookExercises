package Chapter10;

import java.util.concurrent.*;

class Summator implements Callable {

    @Override
    public Object call() {
        int sum = 0;
        String[] params = Thread.currentThread().getName().split(",");
        int from = Integer.parseInt(params[0]), to = Integer.parseInt(params[1]);
        for (int i = from; i <= to; i++) {
            sum += i;
            System.out.println("Adding " + i);
        }
        return sum;
    }
}

public class exercise13 {
    public static void main(String[] args) {
        // 初始化
        Summator summator = new Summator();
        FutureTask<Integer>[] result = new FutureTask[10];
        Thread[] thread = new Thread[10];
        for (int tick = 0; tick < 10; tick++) {
            result[tick] = new FutureTask<>(summator);
            thread[tick] = new Thread(result[tick], (tick * 10 + 1) + "," + (tick * 10 + 10));
        }

        // 启动线程
        for (Thread obj : thread)
            obj.start();

        // 统计结果
        int sum = 0;
        for (FutureTask<Integer> obj : result)
            try {
                sum += obj.get();
            } catch (Exception e) {
                e.printStackTrace();
            }

        System.out.println("Result is " + sum);
    }
}
