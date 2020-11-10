import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener implements ActionListener {

    //创建成员对象，用来接收监听到的元素对象
    private final JTextField VanNumber;
    private final JTextField CarType;
    private final JLabel jLabelCarType;
    private final JLabel jLabelVanNumber;
    private final JLabel jLabelSuccess;

    //设置标签用来作为是否生成过图片的标识
    private Integer flag=0;


    /**
     * Listener构造方法
     * @param textVanNumber
     * @param textCarType
     * @param jLabelVanNumber
     * @param jLabelCarType
     * @param jLabelSuccess
     */
    public Listener(JTextField textVanNumber, JTextField textCarType, JLabel jLabelVanNumber, JLabel jLabelCarType, JLabel jLabelSuccess) {
        //将监听到的元素对象赋值给成员对象
        this.VanNumber = textVanNumber;
        this.CarType = textCarType;
        this.jLabelCarType=jLabelCarType;
        this.jLabelVanNumber=jLabelVanNumber;
        this.jLabelSuccess=jLabelSuccess;

    }


    public void actionPerformed(ActionEvent e) {
        //每次点击按钮前初始化lable
        jLabelCarType.setText(null);
        jLabelVanNumber.setText(null);
        jLabelSuccess.setText(null);
        //提取JTextField中的输入文案
        String ca = CarType.getText();
        String va = VanNumber.getText();

        if ((e.getActionCommand()).equals("一键生成")) {
            if (!va.equals("") && !ca.equals("")) {
                //生成图片
                VehicleLicense.imageBuilder(VanNumber.getText(), CarType.getText());
                //设置lable的显示内容
                jLabelSuccess.setText("证件生成成功");
                flag=1;
            } else if (ca.equals("") && !va.equals("")) {
                jLabelCarType.setText("车辆类型不能为空!");
            }
            else {
                jLabelVanNumber.setText("车牌号不能为空!");
            }
        } else if ((e.getActionCommand()).equals("打开图片")) {
            if (!va.equals("") && !ca.equals("") && flag.equals(1)) {
                //正面
                String pathface = "output/VehicleLicenseFCopy.png";// path是要打开的文件的相对路径。
                OpenImage.open(pathface);
                //背面
                String pathback = "output/VehicleLicenseBCopy.png";
                OpenImage.open(pathback);
            }
            else {
                jLabelSuccess.setText("请先生成证件图片!");
            }
        }
    }


}
