import java.awt.*;


import javax.swing.*;

public class Gui {

    //在类中定义主函数
    public static void main(String[] args) {
        //在主函数中，实例化Login类的对象，调用初始化界面的方法
        Gui init = new Gui();
        init.initUI();

    }

    //在类中定义初始化界面的方法
    public void initUI() {
        //在initUI中实例化JFrame类的对象
        JFrame frame = new JFrame();
        //设置窗体对象的属性值
        frame.setTitle("生成行驶证");//设置窗体标题
        frame.setSize(400, 250);//设置窗体大小，只对顶层容器生效
        frame.setDefaultCloseOperation(3);//设置窗体关闭操作，3表示关闭窗体退出程序
        frame.setLocationRelativeTo(null);//设置窗体相对于另一组间的居中位置，参数null表示窗体相对于屏幕的中央位置
        frame.setResizable(false);//禁止调整窗体大小
        frame.setFont(new Font("宋体",Font.PLAIN,14));//设置字体，显示格式正常，大小

        //实例化FlowLayout流式布局类的对象，指定对齐方式为居中对齐组件之间的间隔为10个像素
//        FlowLayout fl = new FlowLayout(FlowLayout.CENTER,10,10);
        //实例化流式布局类的对象
        frame.setLayout(null);

        //实例化JLabel标签对象，该对象显示“车牌号”
        JLabel labVanNumber = new JLabel("车牌号：");
        labVanNumber.setFont(new Font("宋体",Font.PLAIN,14));
        labVanNumber.setBounds(40,20,60,30);

        //将labname标签添加到窗体上
        frame.add(labVanNumber);

        //实例化JTextField标签对象化
        JTextField text_VanNumber = new JTextField();
        Dimension dim1 = new Dimension(200,30);
        text_VanNumber.setBounds(120,20,200,30);
        text_VanNumber.setPreferredSize(dim1);//设置除顶级容器组件以外其他组件的大小
        //将text_VanNumber标签添加到窗体上
        frame.add(text_VanNumber);

        //实例化JLabel标签对象，该对象显示“车辆类型”
        JLabel labCarType = new JLabel("车辆类型：");
        labCarType.setFont(new Font("宋体",Font.PLAIN,14));
        labCarType.setBounds(40,70,80,30);
        //将labCarType添加到窗体上
        frame.add(labCarType);

        //实例化JTextField
        JTextField text_CarType = new JTextField();
        text_CarType.setBounds(120,70,200,30);
        //设置大小
        text_CarType.setPreferredSize(dim1);
        //添加到窗体
        frame.add(text_CarType);


        //实例化JButton组件
        JButton button1 = new JButton();
        //设置按键的显示内容
        Dimension dim2 = new Dimension(100,30);
        button1.setBounds(50,130,100,30);
        button1.setText("一键生成");
        button1.setFont(new Font("宋体",Font.PLAIN,14));
        //设置按键大小
        button1.setSize(dim2);
        frame.add(button1);

        //实例化JButton组件
        JButton button2 = new JButton();
        //设置按键的显示内容
        button2.setBounds(190,130,100,30);
        button2.setText("打开图片");
        button2.setFont(new Font("宋体",Font.PLAIN,14));
        //设置按键大小
        button2.setSize(dim2);
        frame.add(button2);

        //新增两个lable显示错误提示
        JLabel jLabelva = new JLabel();
        JLabel jLabelca = new JLabel();
        JLabel jLabelSuccess = new JLabel();
        jLabelva.setBounds(130, 45, 120, 30);//设置车牌号错误提示的位置
        jLabelca.setBounds(130, 95, 120, 30);//设置车辆类型错误提示的位置
        jLabelSuccess.setBounds(130,160,120,30);//设置生成成功的提示位置
        jLabelSuccess.setFont(new Font("宋体", Font.PLAIN, 14));  //宋体，正常风格，14号字体
        jLabelca.setFont(new Font("宋体", Font.PLAIN, 14));  //宋体，正常风格，14号字体
        jLabelva.setFont(new Font("宋体", Font.PLAIN, 14));  //宋体，正常风格，14号字体
        jLabelSuccess.setForeground(Color.red);//设置字体颜色为红色
        jLabelva.setForeground(Color.red);//设置字体颜色为红色
        jLabelca.setForeground(Color.red);//设置字体颜色为红色
        //将lable加载到frame上
        frame.add(jLabelva);
        frame.add(jLabelca);
        frame.add(jLabelSuccess);


        frame.setVisible(true);//窗体可见，一定要放在所有组件加入窗体后

        //创建一个监听实例，将界面元素加载进监听器
        Listener listener = new Listener(text_VanNumber,text_CarType,jLabelva,jLabelca,jLabelSuccess);
        button1.addActionListener(listener);
        button2.addActionListener(listener);
        text_VanNumber.addActionListener(listener);
        text_CarType.addActionListener(listener);
    }
}