package Chapter5;

import java.util.Random;

public class exercise4 {
    public static void main(String[] args) {
        // 编程题 1
        String helloWorld = "Hello World";
        // StringBuffer 几乎等价于 StringBuilder，前者线程安全，后者性能更高
        StringBuilder destStr = new StringBuilder();

        int strLength = helloWorld.length();
        for (int i = strLength - 1; i >= 0; i--)    // 从最后一个字符开始遍历
        {
            char tempChar = helloWorld.charAt(i);
            System.out.println("Now traversed character '" + tempChar + "'");
            if (Character.isUpperCase(tempChar)) {      // 判断大小写并转换
                destStr.append(Character.toLowerCase(tempChar));
            } else if (Character.isLowerCase(tempChar)) {
                destStr.append(Character.toUpperCase(tempChar));
            } else {
                destStr.append(tempChar);
            }
        }
        // 输出结果
        System.out.println(destStr.toString());
        destStr.reverse();  // 字符串逆置
        System.out.println(destStr.toString());

        // 编程题 2
        for (int t = 0; t < 5; t++) {
            System.out.println(20 + new Random().nextInt(11));
        }
    }
}
