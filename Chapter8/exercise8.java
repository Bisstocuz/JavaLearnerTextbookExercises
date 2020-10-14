package Chapter8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// 334 页编程题 第一题

// JFrame 窗口类：用于窗口初始化以及对窗口进行操作的类
class CommonWindow {
    private JFrame window;  // 窗口类

    CommonWindow() {    // 无参默认构造方法
        this.window = new JFrame("Default Title");
    }

    CommonWindow(String title) {    // 带标题参数构造方法
        this.window = new JFrame(title);
    }

    public void setTitle(String title) {    // 设置窗口标题
        this.window.setTitle(title);
    }

    // 初始化方法，传入参数为窗口大小及窗口标题
    public void initialize(int width, int height) {
        this.window.setSize(width, height);  // 设置长宽
        this.window.setLocationRelativeTo(null);    // 通过设置相对坐标实现窗口居中
        this.window.setVisible(true);       // 设置窗口可视
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     // 设置关闭窗口默认操作：退出程序
    }

    // 向窗口添加监听器
    public void addListener(Object listener) {
        if (MouseListener.class.isAssignableFrom(listener.getClass()))  // 判断传入的类是否继承自某接口（下同）
            this.window.addMouseListener((MouseListener) listener);     // 向窗口添加指定类型监听器（下同）
        else if (KeyListener.class.isAssignableFrom(listener.getClass()))
            this.window.addKeyListener((KeyListener) listener);
        else if (WindowListener.class.isAssignableFrom(listener.getClass()))
            this.window.addWindowListener((WindowListener) listener);
        else
            System.out.println("This Class cannot be supported.");
    }

    // 添加布局
    public void setLayout(LayoutManager layout) {
        this.window.setLayout(layout);
    }

    // 添加标签
    public void addLabel(JLabel label, Object constraints) {
        this.window.add(label, constraints);
    }
}

// 鼠标操作类
class MouseOperation implements MouseListener {
    private JLabel targetLabel;

    private String getMousePosition() {   // 获取鼠标坐标
        Point mouse = MouseInfo.getPointerInfo().getLocation();
        return "X=" + mouse.getX() + ", Y=" + mouse.getY();   // 返回坐标
    }

    MouseOperation(JLabel label) {
        this.targetLabel = label;
    }

    @Override
    public void mouseClicked(MouseEvent e) {    // 鼠标单击事件
        if (e.getButton() == MouseEvent.BUTTON3) {  // 鼠标右键
            System.out.println("Right-Clicked.");
            this.targetLabel.setText("当前鼠标位置：" + getMousePosition());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}


public class exercise8 {
    public static void main(String[] args) {
        CommonWindow window = new CommonWindow();
        window.setTitle("右键窗口获取鼠标坐标");
        window.setLayout(new BorderLayout());
        JLabel label = new JLabel("Default Text", JLabel.CENTER);   // 新建标签
        window.addLabel(label, BorderLayout.PAGE_START);                 // 标签添加到窗口（PAGE_START）
        window.addListener(new MouseOperation(label));                   // 添加侦听器
        window.initialize(600, 400);        // 窗口初始化
    }
}
