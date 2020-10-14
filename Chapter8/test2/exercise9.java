package Chapter8.test2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// JFrame 窗口操作类
class CommonWindow {
    private final JFrame window;  // JFrame 窗口

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

    // 添加布局
    public void setLayout(LayoutManager layout) {
        this.window.setLayout(layout);
    }

    // 添加组件
    public void addComponent(Component component, Object constraints) {
        this.window.add(component, constraints);
    }
}

public class exercise9 {
    public static void main(String[] args) {
        CommonWindow window = new CommonWindow("编程作业第二题");
        window.setLayout(new BorderLayout());

        // 新建 JPanel
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // 新建 JPanel 中的组件
        JLabel labelA = new JLabel("兴趣：");
        JCheckBox checkBox1 = new JCheckBox("羽毛球"), checkBox2 = new JCheckBox("乒乓球"), checkBox3 = new JCheckBox("唱歌");
        JLabel labelB = new JLabel("      性别：");
        JRadioButton radioButton1 = new JRadioButton("男"), radioButton2 = new JRadioButton("女");
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(radioButton1);
        radioGroup.add(radioButton2);

        // 新建 JScrollPane 和 JTextArea
        JScrollPane scrollPane = new JScrollPane();
        JTextArea textArea = new JTextArea();
        scrollPane.setViewportView(textArea);   // 将 JTextArea 添加到 JScrollPane 中

        // 新建 ActionListener 监听器
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Action Performed.");    // 调试输出
                textArea.setText("");   // 清空
                textArea.append("性别：");
                if (radioButton1.isSelected())
                    textArea.append("男\r\n");
                else if (radioButton2.isSelected())
                    textArea.append("女\r\n");
                else
                    textArea.append("未选定\r\n");     // 没有选定性别
                int hobbyCount = 0;     // 计数：用于判定是否添加前置顿号
                textArea.append("兴趣：\r\n");
                if (checkBox1.isSelected()) {
                    textArea.append("羽毛球");
                    hobbyCount++;
                }
                if (checkBox2.isSelected()) {
                    textArea.append((hobbyCount > 0 ? "、" : "") + "乒乓球");
                    hobbyCount++;
                }
                if (checkBox3.isSelected()) {
                    textArea.append((hobbyCount > 0 ? "、" : "") + "唱歌");
                    hobbyCount++;
                }
                if (hobbyCount == 0)    // 没有选中兴趣
                    textArea.append("无");
            }
        };

        // 向组件添加监听器
        checkBox1.addActionListener(listener);
        checkBox2.addActionListener(listener);
        checkBox3.addActionListener(listener);
        radioButton1.addActionListener(listener);
        radioButton2.addActionListener(listener);

        // 向 JPanel 中添加组件
        panel.add(labelA);
        panel.add(checkBox1);
        panel.add(checkBox2);
        panel.add(checkBox3);
        panel.add(labelB);
        panel.add(radioButton1);
        panel.add(radioButton2);

        // 将组件添加到窗口中并初始化窗口
        window.addComponent(panel, BorderLayout.NORTH);
        window.addComponent(scrollPane, BorderLayout.CENTER);
        window.initialize(500, 300);
    }
}
