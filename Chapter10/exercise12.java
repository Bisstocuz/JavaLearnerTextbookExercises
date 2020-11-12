package Chapter10;

class Teacher implements Runnable {
    private static final Object lock = new Object();
    private int notes = 80;

    @Override
    public void run() {
        synchronized (lock) {
            while (notes > 0) {
                System.out.println(Thread.currentThread().getName() + "正在分发第" + notes-- + "份学习笔记。");
            }
        }
    }
}

public class exercise12 {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        new Thread(teacher, "老师A").start();
        new Thread(teacher, "老师B").start();
        new Thread(teacher, "老师C").start();
    }
}
