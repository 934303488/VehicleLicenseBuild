import lombok.SneakyThrows;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class OpenImage extends JPanel
{
    @SneakyThrows
    public OpenImage(String fileName)
    {
//        File file=new File(fileName);
        ImageIcon img = new ImageIcon(fileName);//创建ImageIcon实例，并加载图片
        JLabel jl = new JLabel(img);//创建Lable实例，并加载Icon
        this.setLayout(new BorderLayout());//创建布局管理器实例
        this.add(jl, BorderLayout.CENTER);//将Lable布局居中展示
    }
    public static void open(String fileName){
        JFrame frame = new JFrame( "Image");//创建一个弹窗实例，设置title名
        frame.getContentPane().add(new OpenImage(fileName));//将OpenImage对象添加到弹窗的组件中
        frame.pack();//设置窗体根据图片自适应大小
        frame.setVisible(true);//窗体设置为可见
        //添加桌面应用监听，关闭窗口的时候可以正常的退出
//        frame.addWindowListener(new WindowAdapter()
//        {
//            public void windowClosing(WindowEvent e)
//            {
//                System.exit(0);
//            }
//        });
    }
}