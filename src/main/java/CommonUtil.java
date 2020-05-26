import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

public class CommonUtil {
    public void generateIdCard(String srcImgPath, String tarImgPath, String idNumber, String customerName) {

        try {
            // 读取原图片信息
            File srcImgFile = new File(srcImgPath);// 得到文件
            Image srcImg = ImageIO.read(srcImgFile);// 文件转化为图片
            int srcImgWidth = srcImg.getWidth(null);// 获取图片的宽
            int srcImgHeight = srcImg.getHeight(null);// 获取图片的高
            // 加水印
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufImg.createGraphics();
            g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
            Color color = new Color(0, 0, 0);
            Font font = new Font("微软雅黑", Font.PLAIN, 25);
            g.setColor(color); // 根据图片的背景设置水印颜色
            g.setFont(font); // 设置字体
            String year = idNumber.substring(6, 10);
            String month = null;
            String day = null;
            if (Integer.valueOf(idNumber.substring(10, 12)) < 10) {
                month = idNumber.substring(11, 12);
            } else {
                month = idNumber.substring(10, 12);
            }

            if (Integer.valueOf(idNumber.substring(12, 14)) < 10) {
                day = idNumber.substring(13, 14);
            } else {
                day = idNumber.substring(12, 14);
            }
            g.drawString(customerName, 124, 63);
            g.drawString(year, 114, 156); // 画出水印
            g.drawString(month, 204, 156);
            g.drawString(day, 254, 156);
            g.drawString(idNumber, 209, 319);
            font = new Font("微软雅黑", Font.PLAIN, 20);//change font
            g.setFont(font);
            g.drawString("上海市奉贤区南桥镇贝港", 125, 199);
            g.drawString("新村120号104室", 125, 233);
            g.dispose();
            // 输出图片
            FileOutputStream outImgStream = new FileOutputStream(tarImgPath);
            ImageIO.write(bufImg, "jpg", outImgStream);
            // System.out.println("添加水印完成");
            outImgStream.flush();
            outImgStream.close();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
