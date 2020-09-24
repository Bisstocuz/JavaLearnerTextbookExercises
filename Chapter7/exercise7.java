package Chapter7;

import java.io.*;

// 文件复制类
class FileCopier {
    public static void copyFileByByteStream(String srcPath, String destPath) throws Exception {
        byte[] buff = new byte[1024];     // 字节流缓冲区
        FileInputStream in = new FileInputStream(srcPath);
        FileOutputStream out = new FileOutputStream(destPath);
        int len;
        while ((len = in.read(buff)) != -1) {
            out.write(buff, 0, len);
        }
        // 关闭流
        in.close();
        out.close();
        System.out.println("Successfully copied " + srcPath + " to " + destPath + " by Byte Stream.");
    }

    public static void copyFileByCharStream(String srcPath, String destPath) throws Exception {
        char[] buff = new char[1024];      // 字符流缓冲区
        BufferedReader reader = new BufferedReader(new FileReader(srcPath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(destPath));
        int len;
        while ((len = reader.read(buff)) != -1) {
            writer.write(buff, 0, len);
        }
        // 关闭流
        reader.close();
        writer.close();
        System.out.println("Successfully copied " + srcPath + " to " + destPath + " by Character Stream.");
    }
}

// 计时器类
class Timer {
    private final long beginTime;

    Timer() {
        this.beginTime = System.currentTimeMillis();
    }

    public long getRunningTime() {
        return System.currentTimeMillis() - this.beginTime;
    }
}

// 密码输入小游戏类
class PassGame {
    private final BufferedReader in;

    PassGame() {
        this.in = new BufferedReader(new InputStreamReader(System.in));
    }

    // 读取
    private String getInputLine() throws Exception {
        return this.in.readLine();
    }

    // 开始游戏（传入参数为最多可输入的次数）
    public void startGame(int tick) throws Exception {
        boolean success = false;    // 密码正确与否的标记
        for (int i = 0; i < tick; i++) {
            String inputPassword = getInputLine();
            if (inputPassword.equals("123456")) {   // 成功
                System.out.println("恭喜你进入游戏");
                success = true;
                break;
            } else {    // 密码错误
                System.out.println("密码错误");
            }
        }
        if (!success) {     // 失败
            System.out.println("可尝试次数耗尽，结束游戏");
            System.exit(0);     // 结束游戏
        }
    }
}

public class exercise7 {
    public static void main(String[] args) throws Exception {
        // 编程题第一题
        Timer timer = new Timer();
        FileCopier.copyFileByByteStream("D:\\in.txt", "D:\\out.txt");   // 在这修改你需要复制的文件路径
        System.out.println("Process finished with " + timer.getRunningTime() + " ms.");
        timer = new Timer();
        FileCopier.copyFileByCharStream("D:\\in.txt", "D:\\out.txt");   // 在这修改你需要复制的文件路径
        System.out.println("Process finished with " + timer.getRunningTime() + " ms.");

        // 编程题第二题
        PassGame game = new PassGame();
        game.startGame(5);
    }
}
