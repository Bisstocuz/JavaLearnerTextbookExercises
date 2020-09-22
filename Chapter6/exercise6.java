package Chapter6;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class exercise6 {
    public static void main(String[] args) {
        // <> 中的参数为对象，并非数据类型
        TreeMap<Integer, String> set = new TreeMap<>();
        set.put(3, "Smith");
        set.put(5, "Amanda");
        set.put(1, "Lucy");
        set.put(4, "Aimee");
        set.put(2, "John");

        Set<Integer> keys = set.keySet();
        // 从此处开始可使用 for 进行迭代，无须手动创建迭代器
        Iterator<Integer> it = keys.iterator();
        while (it.hasNext()) {
            Integer key = it.next();
            System.out.println(set.get(key));
        }
    }
}
