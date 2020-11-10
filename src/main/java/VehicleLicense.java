import lombok.SneakyThrows;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;
import java.util.List;


/**
 * @use 利用Java代码给图片添加文字(透明图调低点, 也可以当做水印)
 */

public class VehicleLicense {

    /**
     * 创建ImageDTO数据传输对象, 每一个对象,代表在该图片中要插入的一段文字内容:
     *
     * @param text  : 文本内容;
     * @param color : 字体颜色(前三位)和透明度(第4位,值越小,越透明);
     * @param font  : 字体的样式和字体大小;
     * @param x     : 当前字体在该图片位置的横坐标;
     * @param y     : 当前字体在该图片位置的纵坐标;
     * @return
     */
    private static ImageDTO createImageDTO(String text, Color color, Font font, int x, int y) {
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setText(text);
        imageDTO.setColor(color);
        imageDTO.setFont(font);
        imageDTO.setX(x);
        imageDTO.setY(y);
        return imageDTO;
    }

    /**
     * 编辑图片,往指定位置添加文字
     *
     * @param srcFile    :源图片路径
     * @param targetImgPath :保存图片路径
     * @param list          :文字集合
     */
    @SneakyThrows
    public static void writeImage(File srcFile, File  targetImgPath, List<ImageDTO> list) {
        Image srcImg = ImageIO.read(srcFile);//打开图片
        int srcImgWidth = srcImg.getWidth(null);//获取图片的宽，没有需要等待图像被加载的对象，所以observer置为null
        int srcImgHeight = srcImg.getHeight(null);//获取图片的高

        System.out.println("宽：" + srcImgWidth + "高" + srcImgHeight);

        //添加文字:
        //创建一个图片同等大小、RGB颜色组件的图像编辑实例，
        BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
        //创建一个二维图像编辑实例
        Graphics2D g = bufImg.createGraphics();
        //将图片加载进编辑实例中
        g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);

        //创建一个ImageDTO实例接收图片的数据集合
        for (ImageDTO imgDTO : list) {
            g.setColor(imgDTO.getColor());                                  //根据图片的背景设置水印的颜色和透明度
            g.setFont(imgDTO.getFont());                                    //设置字体
            g.drawString(imgDTO.getText(), imgDTO.getX(), imgDTO.getY());   //画出水印
        }
        //本次图片编辑结束前，源文件不可编辑
        g.dispose();

        // 输出图片
        FileOutputStream outImgStream = new FileOutputStream(targetImgPath);
        ImageIO.write(bufImg, "png", outImgStream);
    }


    @SneakyThrows
    public static void imageBuilder(String VanNumber, String CarType) {
        File file=new File("file/VehicleLicenseFCopy.png");//正面源图片地址
        File fileTage=new File("output/VehicleLicenseFCopy.png");//正面目标图片的地址
        File backSrcImg=new File("file/VehicleLicenseBCopy.png");//背面源图片地址
        File backTarImg=new File("output/VehicleLicenseBCopy.png");//背面目标图片的地址


        //获取正面数据集合
        ArrayList<ImageDTO> facelist = new ArrayList<>();
        //车牌号
        facelist.add(createImageDTO(VanNumber, new Color(128, 119, 128), new Font("宋体", Font.PLAIN, 56), 242, 227));
        //车辆类型
        facelist.add(createImageDTO(CarType, new Color(128, 119, 128), new Font("宋体", Font.PLAIN, 56), 821, 227));
        //所有人
        facelist.add(createImageDTO("测试人员", new Color(128, 119, 128), new Font("宋体", Font.PLAIN, 56), 242, 336));
        //住址
        facelist.add(createImageDTO("四川省成都市锦江区三色路火炬动力港A区", new Color(128, 119, 128), new Font("宋体", Font.PLAIN, 56), 242, 450));
        //识别码
        facelist.add(createImageDTO("SNK12345677654321", new Color(128, 119, 128), new Font("宋体", Font.PLAIN, 56), 652, 691));
        //发动机号
        facelist.add(createImageDTO("SNK654321", new Color(128, 119, 128), new Font("宋体", Font.PLAIN, 56), 629, 784));


        //获取背面数据集合
        ArrayList<ImageDTO> backList = new ArrayList<>();
        backList.add(createImageDTO(VanNumber, new Color(128, 119, 128), new Font("宋体", Font.PLAIN, 56), 242, 80));


        //编辑正面图片
        writeImage(file,fileTage, facelist);
        //编辑背面图片
        writeImage(backSrcImg, backTarImg, backList);

    }
}
