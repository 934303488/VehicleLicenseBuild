import lombok.SneakyThrows;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class OpenImage extends JPanel
{
    @SneakyThrows
    public OpenImage(String fileName)
    {
        //打开图片并设置布局
        ImageIcon img = new ImageIcon(fileName);
        JLabel jl = new JLabel(img);
        this.setLayout(new BorderLayout());
        this.add(jl, BorderLayout.CENTER);
    }
    public static void open(String fileName){
        //创建一个弹窗，设置弹窗相关属性
        JFrame frame = new JFrame( "Image");
        frame.getContentPane().add(new OpenImage(fileName));
        frame.pack();//设置窗体根据图片自适应大小
        frame.setVisible(true);//窗体设置为可见
        //添加桌面应用监听，关闭窗口的时候可以退出程序
//        frame.addWindowListener(new WindowAdapter()
//        {
//            public void windowClosing(WindowEvent e)
//            {
//                System.exit(0);
//            }
//        });
    }
}